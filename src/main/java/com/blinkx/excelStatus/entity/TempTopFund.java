package com.blinkx.excelStatus.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="temp_top_fund")
public class TempTopFund implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Transient
	private long srNo;
	
	@Column
	private String fundaName;
	
	@Column
	private String link;
	
	@Column
	private String ThreeYrReturn;
	
	@Column
	private String rating;
	
	@Column
	private String minInv;
	
	@Column
	private String category;
	
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getFundaName() {
		return fundaName;
	}

	public void setFundaName(String fundaName) {
		this.fundaName = fundaName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getThreeYrReturn() {
		return ThreeYrReturn;
	}

	public void setThreeYrReturn(String threeYrReturn) {
		ThreeYrReturn = threeYrReturn;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getMinInv() {
		return minInv;
	}

	public void setMinInv(String minInv) {
		this.minInv = minInv;
	}

	
	public TempTopFund() {
		super();
		
	}
	
	public long getSrNo() {
		return srNo;
	}

	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}

	public TempTopFund(long id, String fundaName, String link, String threeYrReturn, String rating, String minInv,
			String category) {
		super();
		Id = id;
		this.fundaName = fundaName;
		this.link = link;
		ThreeYrReturn = threeYrReturn;
		this.rating = rating;
		this.minInv = minInv;
		this.category = category;
	}

	@Override
	public String toString() {
		return "TempTopFund [Id=" + Id + ", fundaName=" + fundaName + ", link=" + link + ", ThreeYrReturn="
				+ ThreeYrReturn + ", rating=" + rating + ", minInv=" + minInv + ", category=" + category + "]";
	}

	
	
	

}
