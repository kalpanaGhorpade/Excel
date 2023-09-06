package com.blinkx.excelStatus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="m_rating_entity")
public class RatingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String listOfFund;
	
	
	@Column
	private String rating;
	
	@Column
	private String ThreeYearsReturn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getListOfFund() {
		return listOfFund;
	}

	public void setListOfFund(String listOfFund) {
		this.listOfFund = listOfFund;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getThreeYearsReturn() {
		return ThreeYearsReturn;
	}

	public void setThreeYearsReturn(String threeYearsReturn) {
		ThreeYearsReturn = threeYearsReturn;
	}

	public RatingEntity() {
		
	}

	public RatingEntity(long id, String listOfFund, String rating, String threeYearsReturn) {
		super();
		this.id = id;
		this.listOfFund = listOfFund;
		this.rating = rating;
		ThreeYearsReturn = threeYearsReturn;
	}

	@Override
	public String toString() {
		return "RatingEntity [id=" + id + ", listOfFund=" + listOfFund + ", rating=" + rating + ", ThreeYearsReturn="
				+ ThreeYearsReturn + "]";
	}
	
	
	
	

}
