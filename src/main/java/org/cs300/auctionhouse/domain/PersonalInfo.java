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
@Table(name = "PersonalInfo", catalog = "CS300")
public class PersonalInfo {

	private Integer idUser;
	private User user;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String phoneNumber;
	private String emailAddress;

	public PersonalInfo() {
	}

	public PersonalInfo(User user, String firstName, String lastName,
			String address1, String city, String state, String country,
			String zipcode, String phoneNumber, String emailAddress) {
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	public PersonalInfo(User user, String firstName, String middleName,
			String lastName, String address1, String address2, String city,
			String state, String country, String zipcode, String phoneNumber,
			String emailAddress) {
		this.user = user;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUser", unique = true, nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "FirstName", nullable = false, length = 90)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "MiddleName", length = 90)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "LastName", nullable = false, length = 90)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "Address1", nullable = false, length = 90)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "Address2", length = 90)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "City", nullable = false, length = 90)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "State", nullable = false, length = 45)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "Country", nullable = false, length = 90)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "Zipcode", nullable = false, length = 10)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "PhoneNumber", nullable = false, length = 16)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "EmailAddress", nullable = false)
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}