package com.chenchao.renthouse.entity;

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
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Street entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "street", catalog = "renthouse")
public class Street implements java.io.Serializable
{

	// Fields    

	private Integer id;

	private District district;

	private String name;
	
	private Integer districtId;

	private Set<House> houses = new HashSet<House>(0);

	// Constructors

	/** default constructor */
	public Street()
	{}

	/** full constructor */
	public Street(Integer id, String name, Integer districtId)
	{
		this.id = id;
		this.name = name;
		this.districtId = districtId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@ManyToOne(targetEntity = District.class,fetch=FetchType.EAGER)
	@JoinColumn(name = "DISTRICT_ID", insertable = false, updatable = false)
	public District getDistrict()
	{
		return this.district;
	}

	public void setDistrict(District district)
	{
		this.district = district;
	}

	@Column(name = "NAME", length = 50)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "street")
	public Set<House> getHouses()
	{
		return this.houses;
	}

	public void setHouses(Set<House> houses)
	{
		this.houses = houses;
	}
	
	@Column(name = "DISTRICT_ID", length = 50)
	public Integer getDistrictId()
	{
		return districtId;
	}

	public void setDistrictId(Integer districtId)
	{
		this.districtId = districtId;
	}

}