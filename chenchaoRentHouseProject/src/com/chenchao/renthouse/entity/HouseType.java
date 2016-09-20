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
 * HouseType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "house_type", catalog = "renthouse")
public class HouseType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<House> houses = new HashSet<House>(0);

	// Constructors

	/** default constructor */
	public HouseType() {
	}

	/** full constructor */
	public HouseType(String name, Set<House> houses) {
		this.name = name;
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

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "houseType")
	public Set<House> getHouses() {
		return this.houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

}