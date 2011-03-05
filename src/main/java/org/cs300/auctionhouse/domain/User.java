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
	private Set<Authority> authorities = new HashSet<Authority>(0);
	private Set<Bid> bids = new HashSet<Bid>(0);
	private Set<Feedback> feedbacks = new HashSet<Feedback>(0);
	private Set<PersonalInfo> personalInfos = new HashSet<PersonalInfo>(0);
	private Set<Auction> auctions = new HashSet<Auction>(0);

	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled,
			Set<Authority> authorities, Set<Bid> bids, Set<Feedback> feedbacks,
			Set<PersonalInfo> personalInfos, Set<Auction> auctions) {
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
	public Set<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Bid> getBids() {
		return this.bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<PersonalInfo> getPersonalInfos() {
		return this.personalInfos;
	}

	public void setPersonalInfos(Set<PersonalInfo> personalInfos) {
		this.personalInfos = personalInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Auction> getAuctions() {
		return this.auctions;
	}

	public void setAuctions(Set<Auction> auctions) {
		this.auctions = auctions;
	}
}