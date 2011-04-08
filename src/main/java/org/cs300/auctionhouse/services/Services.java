package org.cs300.auctionhouse.services;

import java.util.List;

import org.cs300.auctionhouse.domain.Auction;
import org.cs300.auctionhouse.domain.Authority;
import org.cs300.auctionhouse.domain.Bid;
import org.cs300.auctionhouse.domain.PersonalInfo;
import org.cs300.auctionhouse.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

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

	public void createUser(User user, PersonalInfo pi) {
		user.setEnabled(true);
		Authority auth = new Authority(user, "ROLE_USER");
		pi.setUser(user);
		sess().save(user);
		sess().save(pi);
		sess().save(auth);
	}

	public void updateUser(User user) {
		sess().update(user);
	}

	@SuppressWarnings("unchecked")
	public List<Auction> getAllAuctions() {
		return sess().createQuery("from Auction").list();
	}

	public Auction getAuctionByID(int id) {
		return (Auction)
			sess().createQuery("from Auction where idAuction=:idAuction").setInteger("idAuction", id).uniqueResult();
	}

	public User findByName(String username) {
		return (User) sess().createQuery("from User where username=:username").setString("username", username).uniqueResult();
	}
	
	public byte[] getAuctionImage(int id) {
		return getAuctionByID(id).getPicture();
	}

	public List<Bid> getBidsByAuctionID(int id) {
		return getAuctionByID(id).getBids();
	}
}