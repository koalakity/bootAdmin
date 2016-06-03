package com.snowstore.bootAdmin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.snowstore.bootAdmin.service.userDetails.UserDetailsImpl;
import com.snowstore.log.service.UserDetailDelegate;
import com.snowstore.log.vo.UserInfo;

@Component
public class UserDetailDelegateImpl implements UserDetailDelegate<UserDetailsImpl> {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailDelegateImpl.class);


	@Override
	public UserInfo getUserInfo() {
		UserInfo userInfo = new UserInfo();
		try {
			UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			userInfo.setUserName(user.getUsername());
			userInfo.setUserId(user.getId());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			userInfo.setUserName("unknow user");
			userInfo.setUserId(0L);
		}
		return userInfo;
	}

}
