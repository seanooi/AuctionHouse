package org.cs300.auctionhouse.services;

import java.util.List;

import org.cs300.auctionhouse.domain.Auction;
import org.cs300.auctionhouse.domain.Authority;
import org.cs300.auctionhouse.domain.Bid;
import org.cs300.auctionhouse.domain.Category;
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

	public int saveNewAuction(Auction auction) {
		sess().save(auction);
		return auction.getIdAuction();
	}

	@SuppressWarnings("unchecked")
	public List<Auction> getAllAuctions() {
		return sess().createQuery("from Auction").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Auction> getUserSales(String currentUser) {
		return sess().createQuery("from Auction where user.username=:id").setString("id", currentUser).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Auction> getUserBids(String currentUser) {
		return sess().createQuery("select distinct auction from Auction auction, Bid bid where auction.user.username=:id and bid.user.username=:id").setString("id", currentUser).list();
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

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		return sess().createQuery("from Category").list();
	}

	public Category getCategoryByID(int id) {
		return (Category)sess().createQuery("from Category where id=:id").setInteger("id", id).uniqueResult();
	}

	public void saveNewBid(Bid bid) {
		sess().save(bid);
	}
}