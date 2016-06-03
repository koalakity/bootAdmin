package com.snowstore.bootAdmin.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snowstore.bootAdmin.domain.AdminUser;
import com.snowstore.bootAdmin.repository.AdminUserRepository;

@Service
@Transactional
public class AdminUserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminUserService.class);


	@Autowired
	private AdminUserRepository adminUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init(){
		long userCount= adminUserRepository.count();
		if(userCount == 0){
			LOGGER.info("初始用户用户名{}，密码{}","admin","123456");
			AdminUser user = new AdminUser();
			user.setUsername("admin");
			user.setPassword(passwordEncoder.encode("123456"));
			adminUserRepository.save(user);
		}
	}
}
