package org.cs300.auctionhouse.ui;

import org.cs300.auctionhouse.domain.User;
import org.cs300.auctionhouse.domain.PersonalInfo;

public class UserPersonalInfo {

	private User user;
	private PersonalInfo pi;

	public UserPersonalInfo() {
		this.user = new User();
		this.pi = new PersonalInfo();
	}

	public UserPersonalInfo(User user, PersonalInfo pi) {
		this.user = user;
		this.pi = pi;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PersonalInfo getPersonalInfo() {
		return pi;
	}

	public void setPersonalInfo(PersonalInfo pi) {
		this.pi = pi;
	}
}
