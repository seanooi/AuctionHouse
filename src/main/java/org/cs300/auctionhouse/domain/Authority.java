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
@Table(name = "Authority", catalog = "CS300")
public class Authority {

	private Integer idAuthority;
	private User user;
	private String authority;

	public Authority() {
	}

	public Authority(User user, String authority) {
		this.user = user;
		this.authority = authority;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idAuthority", unique = true, nullable = false)
	public Integer getIdAuthority() {
		return this.idAuthority;
	}

	public void setIdAuthority(Integer idAuthority) {
		this.idAuthority = idAuthority;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Authority", nullable = false, length = 10)
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}