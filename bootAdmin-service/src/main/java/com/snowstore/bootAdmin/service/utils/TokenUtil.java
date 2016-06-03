package com.snowstore.bootAdmin.service.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtil.class);

	private static Random random = new Random();

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String genToken(String username, Long customerId) {
		long current = System.currentTimeMillis();
		long no = random.nextLong();
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("生成token出错", e);
			return current + no + "";
		}
		md5.update((username + ":" + customerId + ":" + current + ":" + no).getBytes());
		return toHex(md5.digest());

	}

	private static String toHex(byte buffer[]) {
		StringBuffer sb = new StringBuffer(buffer.length * 2);
		for (int i = 0; i < buffer.length; i++) {
			sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));
			sb.append(Character.forDigit(buffer[i] & 15, 16));
		}

		return sb.toString();
	}

	public static String getRandomString(int length) {
		String str = "0123456789";
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(10);
			sf.append(str.charAt(number));

		}
		return sf.toString();
	}

}
