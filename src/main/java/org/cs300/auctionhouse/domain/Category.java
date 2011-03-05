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

@Entity
@Table(name = "Category", catalog = "CS300")
public class Category {

	private Integer idCategory;
	private String name;
	private Set<Auction> auctions = new HashSet<Auction>(0);

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Category(String name, Set<Auction> auctions) {
		this.name = name;
		this.auctions = auctions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCategory", unique = true, nullable = false)
	public Integer getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	@Column(name = "Name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Auction> getAuctions() {
		return this.auctions;
	}

	public void setAuctions(Set<Auction> auctions) {
		this.auctions = auctions;
	}
}