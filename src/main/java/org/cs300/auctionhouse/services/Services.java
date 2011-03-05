package org.cs300.auctionhouse.services;

import org.cs300.auctionhouse.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// This class is the business services tier in the application.
// @Transactional is needed so that a Hibernate transaction is set up,
// otherwise updates won't have an affect

@Transactional
public class Services {
	
	// So Spring can inject the session factory
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory value) {
		sessionFactory = value;
	}

	// Shortcut for sessionFactory.getCurrentSession()
	public Session sess() {
		return sessionFactory.getCurrentSession();
	}
	
	public void createUser(String username, String password, String firstName,
			String middleName, String lastName, String address1, String address2,
			String city, String state, String zipcode, String country,
			String emailAddress, String phoneNumber) {
		User u = new User();
		PersonalInfo pi = new PersonalInfo();
		u.setUsername(username);
		u.setPassword(password);
		pi.setUser(u);
		pi.setFirstName(firstName);
		pi.setMiddleName(middleName);
		pi.setLastName(lastName);
		pi.setAddress1(address1);
		pi.setAddress2(address2);
		pi.setCity(city);
		pi.setState(state);
		pi.setZipcode(zipcode);
		pi.setCountry(country);
		pi.setEmailAddress(emailAddress);
		pi.setPhoneNumber(phoneNumber);
		sess().save(u);
		sess().save(pi);
	}

	@SuppressWarnings("unchecked")
	public List<Auction> getAllAuctions() {
		return sess().createQuery("from Auction").list();
	}

	public User findByName(String username) {
		return (User) sess().createQuery("from User where username=:username").setString("username", username).uniqueResult();
	}
}