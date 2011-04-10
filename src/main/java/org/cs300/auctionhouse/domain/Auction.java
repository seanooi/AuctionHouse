package org.cs300.auctionhouse.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
	private boolean finished;
	private boolean sold;
	private List<Bid> bids = new ArrayList<Bid>(0);
	private List<Feedback> feedbacks = new ArrayList<Feedback>(0);

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
			String description, byte[] picture, List<Bid> bids,
			List<Feedback> feedbacks) {
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

	@Column(name = "Picture")
	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Column(name = "Finished", nullable = false)
	public boolean getFinished() {
		return this.finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	@Column(name = "Sold", nullable = false)
	public boolean getSold() {
		return this.sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auction")
	@OrderBy("idBid DESC")
	public List<Bid> getBids() {
		return this.bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auction")
	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
}