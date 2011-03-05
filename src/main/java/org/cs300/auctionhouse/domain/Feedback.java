package org.cs300.auctionhouse.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback", catalog = "CS300")
public class Feedback {

	private Integer idSellerFeedback;
	private Auction auction;
	private User user;
	private String feedback;

	public Feedback() {
	}

	public Feedback(Auction auction, User user, String feedback) {
		this.auction = auction;
		this.user = user;
		this.feedback = feedback;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idSellerFeedback", unique = true, nullable = false)
	public Integer getIdSellerFeedback() {
		return this.idSellerFeedback;
	}

	public void setIdSellerFeedback(Integer idSellerFeedback) {
		this.idSellerFeedback = idSellerFeedback;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AuctionId", nullable = false)
	public Auction getAuction() {
		return this.auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Feedback", nullable = false)
	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}