package com.libertymutual.goforcode.wimp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	@Column(length=300, nullable=false)
	private String title; 
	
	@Column(nullable=true)
	private Date releaseDate;
	
	@Column(nullable=true)
	private Long budget;
	
	@Column(length=500, nullable=false)
	private String distributor;

	//allows you to create movies -- need to call this in order to use the version with argument
	public Movie() {}
	
	//allows you to create kids passing in name and age
	public Movie(String title, Date releaseDate, long budget, String distributor ) {
		this.title = title; 
		this.releaseDate = releaseDate; 
		this.budget = budget; 
		this.distributor = distributor; 
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

}
