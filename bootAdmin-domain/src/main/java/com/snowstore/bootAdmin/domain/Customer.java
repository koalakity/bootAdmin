package com.snowstore.bootAdmin.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "bootAdmin_customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer extends AbstractEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5948070917922733679L;
	/**
	 * 
	 */
	private String username;// 用户名
	private String email;// 邮箱
	private String idCardAccount;// 身份证号
	private String idCardName;// 身份证姓名
	private String phone;// 手机号
	private String status;
	private String password;// 密码
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdCardAccount() {
		return idCardAccount;
	}
	public void setIdCardAccount(String idCardAccount) {
		this.idCardAccount = idCardAccount;
	}
	public String getIdCardName() {
		return idCardName;
	}
	public void setIdCardName(String idCardName) {
		this.idCardName = idCardName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
