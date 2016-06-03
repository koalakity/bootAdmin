package com.snowstore.bootAdmin.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "bootAdmin_admin_user")
@EntityListeners(AuditingEntityListener.class)
public class AdminUser extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6398840872607982669L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
