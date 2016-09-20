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
 * District entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "district", catalog = "renthouse")
public class District implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Street> streets = new HashSet<Street>(0);

	// Constructors

	/** default constructor */
	public District() {
	}

	/** full constructor */
	public District(String name, Set<Street> streets) {
		this.name = name;
		this.streets = streets;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "district")
	public Set<Street> getStreets() {
		return this.streets;
	}

	public void setStreets(Set<Street> streets) {
		this.streets = streets;
	}

}