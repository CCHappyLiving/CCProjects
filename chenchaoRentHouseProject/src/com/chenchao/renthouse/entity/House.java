package com.chenchao.renthouse.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * House entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "house", catalog = "renthouse")
public class House implements java.io.Serializable {

	// Fields

	private Integer id;
	private HouseUser houseUser;
	private HouseType houseType;
	private Street street;
	private String title;
	private String description;
	private Double price;
	private Date pubdate;
	private Date adddate;
	private Float floorage;
	private String contact;
	private HousePicture housePicture;//一对一

	// Constructors

	/** default constructor */
	public House() {
	}

	/** full constructor */
	public House(HouseUser houseUser, HouseType houseType, Street street,
			String title, String description, Double price, Date pubdate,
			Date adddate, Float floorage, String contact,
			HousePicture housePicture) {
		this.houseUser = houseUser;
		this.houseType = houseType;
		this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.adddate = adddate;
		this.floorage = floorage;
		this.contact = contact;
		this.housePicture = housePicture;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	public HouseUser getHouseUser() {
		return this.houseUser;
	}

	public void setHouseUser(HouseUser houseUser) {
		this.houseUser = houseUser;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE_ID")
	public HouseType getHouseType() {
		return this.houseType;
	}

	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STREET_ID")
	public Street getStreet() {
		return this.street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	@Column(name = "TITLE", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PRICE", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PUBDATE", length = 0)
	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ADDDATE", length = 0)
	public Date getAdddate() {
		return this.adddate;
	}

	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}

	@Column(name = "FLOORAGE", precision = 12, scale = 0)
	public Float getFloorage() {
		return this.floorage;
	}

	public void setFloorage(Float floorage) {
		this.floorage = floorage;
	}

	@Column(name = "CONTACT", length = 100)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@OneToOne(targetEntity = HousePicture.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID", referencedColumnName = "HOUSE_ID")
	public HousePicture getHousePicture()
	{
		return housePicture;
	}

	public void setHousePicture(HousePicture housePicture)
	{
		this.housePicture = housePicture;
	}

}