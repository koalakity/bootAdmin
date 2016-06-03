package com.snowstore.bootAdmin.service.userDetails;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snowstore.bootAdmin.domain.AdminUser;
import com.snowstore.bootAdmin.repository.AdminUserRepository;

@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminUserRepository adminUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final AdminUser user = adminUserRepository.findByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException("用户不存在");
		}
		UserDetailsImpl userDetail = new UserDetailsImpl(user.getId());
		BeanUtils.copyProperties(user, userDetail);
		return userDetail;
	}

	public Long getCustomerId() {
		Authentication currentuser = SecurityContextHolder.getContext().getAuthentication();
		if (currentuser == null || currentuser.getPrincipal().equals("anonymousUser")) {
			return null;
		}
		return ((UserDetailsImpl) currentuser.getPrincipal()).getId();
	}
}
