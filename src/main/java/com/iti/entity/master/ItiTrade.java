package com.iti.entity.master;

import java.util.HashMap;
import java.util.Map;

import com.iti.util.HstoreDataType;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="ititrade")
public class ItiTrade {
	@Id
	private Integer tradeCode;
	private String itiCode;
	private String tradeShort;
	private Integer strength;
	private String availableForYear;
	private Integer tradeFreeze;
	private Integer convApproval;
	private Integer strengthFill;
	private Integer strengthVacant;
	private Long trno;
	private String noOfUnits;
	@Column(columnDefinition = "hstore")
	@Convert(converter = HstoreDataType.class)
	private Map<String, String> affNo = new HashMap<String, String>();
	@Column(columnDefinition = "hstore")
	@Convert(converter = HstoreDataType.class)
	private Map<String, String> affYear = new HashMap<String, String>();
	@Column(columnDefinition = "hstore")
	@Convert(converter = HstoreDataType.class)
	private Map<String, String> affDate = new HashMap<String, String>();
	@Column(columnDefinition = "hstore")
	@Convert(converter = HstoreDataType.class)
	private Map<String, String> affNoOfUnits = new HashMap<String, String>();
	private Integer unitStrength;
	private Integer mod;
	public ItiTrade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItiTrade(Integer tradeCode, String itiCode, String tradeShort, Integer strength, String availableForYear,
			Integer tradeFreeze, Integer convApproval, Integer strengthFill, Integer strengthVacant, Long trno,
			String noOfUnits, Map<String, String> affNo, Map<String, String> affYear, Map<String, String> affDate,
			Map<String, String> affNoOfUnits, Integer unitStrength, Integer mod) {
		super();
		this.tradeCode = tradeCode;
		this.itiCode = itiCode;
		this.tradeShort = tradeShort;
		this.strength = strength;
		this.availableForYear = availableForYear;
		this.tradeFreeze = tradeFreeze;
		this.convApproval = convApproval;
		this.strengthFill = strengthFill;
		this.strengthVacant = strengthVacant;
		this.trno = trno;
		this.noOfUnits = noOfUnits;
		this.affNo = affNo;
		this.affYear = affYear;
		this.affDate = affDate;
		this.affNoOfUnits = affNoOfUnits;
		this.unitStrength = unitStrength;
		this.mod = mod;
	}
	public Integer getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(Integer tradeCode) {
		this.tradeCode = tradeCode;
	}
	public String getItiCode() {
		return itiCode;
	}
	public void setItiCode(String itiCode) {
		this.itiCode = itiCode;
	}
	public String getTradeShort() {
		return tradeShort;
	}
	public void setTradeShort(String tradeShort) {
		this.tradeShort = tradeShort;
	}
	public Integer getStrength() {
		return strength;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	public String getAvailableForYear() {
		return availableForYear;
	}
	public void setAvailableForYear(String availableForYear) {
		this.availableForYear = availableForYear;
	}
	public Integer getTradeFreeze() {
		return tradeFreeze;
	}
	public void setTradeFreeze(Integer tradeFreeze) {
		this.tradeFreeze = tradeFreeze;
	}
	public Integer getConvApproval() {
		return convApproval;
	}
	public void setConvApproval(Integer convApproval) {
		this.convApproval = convApproval;
	}
	public Integer getStrengthFill() {
		return strengthFill;
	}
	public void setStrengthFill(Integer strengthFill) {
		this.strengthFill = strengthFill;
	}
	public Integer getStrengthVacant() {
		return strengthVacant;
	}
	public void setStrengthVacant(Integer strengthVacant) {
		this.strengthVacant = strengthVacant;
	}
	public Long getTrno() {
		return trno;
	}
	public void setTrno(Long trno) {
		this.trno = trno;
	}
	public String getNoOfUnits() {
		return noOfUnits;
	}
	public void setNoOfUnits(String noOfUnits) {
		this.noOfUnits = noOfUnits;
	}
	public Map<String, String> getAffNo() {
		return affNo;
	}
	public void setAffNo(Map<String, String> affNo) {
		this.affNo = affNo;
	}
	public Map<String, String> getAffYear() {
		return affYear;
	}
	public void setAffYear(Map<String, String> affYear) {
		this.affYear = affYear;
	}
	public Map<String, String> getAffDate() {
		return affDate;
	}
	public void setAffDate(Map<String, String> affDate) {
		this.affDate = affDate;
	}
	public Map<String, String> getAffNoOfUnits() {
		return affNoOfUnits;
	}
	public void setAffNoOfUnits(Map<String, String> affNoOfUnits) {
		this.affNoOfUnits = affNoOfUnits;
	}
	public Integer getUnitStrength() {
		return unitStrength;
	}
	public void setUnitStrength(Integer unitStrength) {
		this.unitStrength = unitStrength;
	}
	public Integer getMod() {
		return mod;
	}
	public void setMod(Integer mod) {
		this.mod = mod;
	}
	@Override
	public String toString() {
		return "ItiTrade [tradeCode=" + tradeCode + ", itiCode=" + itiCode + ", tradeShort=" + tradeShort
				+ ", strength=" + strength + ", availableForYear=" + availableForYear + ", tradeFreeze=" + tradeFreeze
				+ ", convApproval=" + convApproval + ", strengthFill=" + strengthFill + ", strengthVacant="
				+ strengthVacant + ", trno=" + trno + ", noOfUnits=" + noOfUnits + ", affNo=" + affNo + ", affYear="
				+ affYear + ", affDate=" + affDate + ", affNoOfUnits=" + affNoOfUnits + ", unitStrength=" + unitStrength
				+ ", mod=" + mod + "]";
	}
	
	
	

}
