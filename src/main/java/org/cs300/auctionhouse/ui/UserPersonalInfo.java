package org.cs300.auctionhouse.ui;

import org.cs300.auctionhouse.domain.User;
import org.cs300.auctionhouse.domain.PersonalInfo;

public class UserPersonalInfo {

	private User user;
	private PersonalInfo personalInfo;
	private String confirmPassword;

	public UserPersonalInfo() {
		this.user = new User();
		this.personalInfo = new PersonalInfo();
	}

	public UserPersonalInfo(User user, PersonalInfo pi) {
		this.user = user;
		this.personalInfo = pi;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
