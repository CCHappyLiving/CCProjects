package com.chenchao.renthouse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * HousePicture entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "house_picture", catalog = "renthouse")
public class HousePicture implements java.io.Serializable {

	// Fields

	private Integer id;
	private House house;  //一对一
	private String title;
	private String url;

	// Constructors

	/** default constructor */
	public HousePicture() {
	}

	/** full constructor */
	public HousePicture(House house, String title, String url) {
		this.house = house;
		this.title = title;
		this.url = url;
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

	@OneToOne(mappedBy = "housePicture")
	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	@Column(name = "TITLE", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "URL", length = 500)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}