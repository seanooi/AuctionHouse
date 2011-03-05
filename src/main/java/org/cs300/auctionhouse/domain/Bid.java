package org.cs300.auctionhouse.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Bid", catalog = "CS300")
public class Bid {

	private Integer idBid;
	private Auction auction;
	private User user;
	private BigDecimal amount;
	private Date time;

	public Bid() {
	}

	public Bid(Auction auction, User user, BigDecimal amount, Date time) {
		this.auction = auction;
		this.user = user;
		this.amount = amount;
		this.time = time;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idBid", unique = true, nullable = false)
	public Integer getIdBid() {
		return this.idBid;
	}

	public void setIdBid(Integer idBid) {
		this.idBid = idBid;
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

	@Column(name = "Amount", nullable = false, precision = 10)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Time", nullable = false, length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}