package com.chenchao.renthouse.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * HouseUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "house_user", catalog = "renthouse")
public class HouseUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String telephone;
	private String realname;
	private String isadmin;
	private Set<House> houses = new HashSet<House>(0);

	// Constructors

	/** default constructor */
	public HouseUser() {
	}

	/** full constructor */
	public HouseUser(String username, String password, String telephone,
			String realname, String isadmin, Set<House> houses) {
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.realname = realname;
		this.isadmin = isadmin;
		this.houses = houses;
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

	@Column(name = "USERNAME", length = 1)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "TELEPHONE", length = 15)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "REALNAME", length = 50)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "ISADMIN", length = 5)
	public String getIsadmin() {
		return this.isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "houseUser")
	public Set<House> getHouses() {
		return this.houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

}