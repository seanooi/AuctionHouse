package org.cs300.auctionhouse.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Auction", catalog = "CS300")
public class Auction {

	private Integer idAuction;
	private User user;
	private Category category;
	private String title;
	private String description;
	private byte[] picture;
	private Set<Bid> bids = new HashSet<Bid>(0);
	private Set<Feedback> feedbacks = new HashSet<Feedback>(0);

	public Auction() {
	}

	public Auction(User user, Category category, String title,
			String description, byte[] picture) {
		this.user = user;
		this.category = category;
		this.title = title;
		this.description = description;
		this.picture = picture;
	}

	public Auction(User user, Category category, String title,
			String description, byte[] picture, Set<Bid> bids,
			Set<Feedback> feedbacks) {
		this.user = user;
		this.category = category;
		this.title = title;
		this.description = description;
		this.picture = picture;
		this.bids = bids;
		this.feedbacks = feedbacks;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idAuction", unique = true, nullable = false)
	public Integer getIdAuction() {
		return this.idAuction;
	}

	public void setIdAuction(Integer idAuction) {
		this.idAuction = idAuction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CategoryId", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "Title", nullable = false, length = 90)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "Description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Picture", nullable = false)
	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auction")
	public Set<Bid> getBids() {
		return this.bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auction")
	public Set<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
}