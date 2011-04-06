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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "User", catalog = "CS300", uniqueConstraints = @UniqueConstraint(columnNames = "Username"))
public class User {

	private Integer idUser;
	private String username;
	private String password;
	private boolean enabled;
	private List<Authority> authorities = new ArrayList<Authority>(0);
	private List<Bid> bids = new ArrayList<Bid>(0);
	private List<Feedback> feedbacks = new ArrayList<Feedback>(0);
	private List<PersonalInfo> personalInfos = new ArrayList<PersonalInfo>(0);
	private List<Auction> auctions = new ArrayList<Auction>(0);

	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled,
			List<Authority> authorities, List<Bid> bids, List<Feedback> feedbacks,
			List<PersonalInfo> personalInfos, List<Auction> auctions) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
		this.bids = bids;
		this.feedbacks = feedbacks;
		this.personalInfos = personalInfos;
		this.auctions = auctions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUser", unique = true, nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "Username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<Bid> getBids() {
		return this.bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<PersonalInfo> getPersonalInfos() {
		return this.personalInfos;
	}

	public void setPersonalInfos(List<PersonalInfo> personalInfos) {
		this.personalInfos = personalInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public List<Auction> getAuctions() {
		return this.auctions;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}
}