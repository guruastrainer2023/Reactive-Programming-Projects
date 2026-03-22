package com.training.demo.hr.bean;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AppUsers")
public class AppUser {
	
	
	@Id
	@GeneratedValue(
	strategy=GenerationType.SEQUENCE,
	generator="appuser_seq"
	)
	@SequenceGenerator(
	name="appuser_seq",
	sequenceName="appuser_sequence",
	allocationSize=1
	)
	private int id;
	
	@Column
	private String userName;
	
	@Column
	private String password;

	public AppUser(int id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public AppUser(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public AppUser(String userName) {
		super();
		this.userName = userName;
	}

	public AppUser() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		return id == other.id;
	}
	
	
	

}
