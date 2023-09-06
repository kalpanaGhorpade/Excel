package com.blinkx.excelStatus.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="m_top_fund")
public class TopFund implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String listOfFund;
	
	@Column
	private String topFunds;
	
	@Column
	private String wealthCreation;
	
	@Column
	private String topTaxSaver;
	
	@Column
	private String balanceFunds;
	
	@Column
	private String betterThanSavings;
	
	@Column
	private String betterThanFd;

	public TopFund(long id, String listOfFund, String topFunds, String wealthCreation, String topTaxSaver,
			String balanceFunds, String betterThanSavings, String betterThanFd) {
		super();
		this.id = id;
		this.listOfFund = listOfFund;
		this.topFunds = topFunds;
		this.wealthCreation = wealthCreation;
		this.topTaxSaver = topTaxSaver;
		this.balanceFunds = balanceFunds;
		this.betterThanSavings = betterThanSavings;
		this.betterThanFd = betterThanFd;
	}

	public TopFund() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getTopFunds() {
		return topFunds;
	}

	public void setTopFunds(String topFunds) {
		this.topFunds = topFunds;
	}

	public String getWealthCreation() {
		return wealthCreation;
	}

	public void setWealthCreation(String wealthCreation) {
		this.wealthCreation = wealthCreation;
	}

	public String getTopTaxSaver() {
		return topTaxSaver;
	}

	public void setTopTaxSaver(String topTaxSaver) {
		this.topTaxSaver = topTaxSaver;
	}

	public String getBalanceFunds() {
		return balanceFunds;
	}

	public void setBalanceFunds(String balanceFunds) {
		this.balanceFunds = balanceFunds;
	}

	public String getBetterThanSavings() {
		return betterThanSavings;
	}

	public void setBetterThanSavings(String betterThanSavings) {
		this.betterThanSavings = betterThanSavings;
	}

	public String getBetterThanFd() {
		return betterThanFd;
	}

	public void setBetterThanFd(String betterThanFd) {
		this.betterThanFd = betterThanFd;
	}

	@Override
	public String toString() {
		return "TopFund [id=" + id + ", listOfFund=" + listOfFund + ", topFunds=" + topFunds + ", wealthCreation="
				+ wealthCreation + ", topTaxSaver=" + topTaxSaver + ", balanceFunds=" + balanceFunds
				+ ", betterThanSavings=" + betterThanSavings + ", betterThanFd=" + betterThanFd + "]";
	}
	

	



	
	
	
}
