package com.iti.entity.studentarea;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="student_cand_marks")
public class StudentCandMarksEntity {
	
	 @Id
	 private String regid;
	 
	 private Integer ssc_first_lang_marks; 
	 private BigDecimal  ssc_first_lang_gpa; 
	 
	 private Integer ssc_second_lang_marks; 
	 private BigDecimal  ssc_second_lang_gpa; 
	 
	 private Integer ssc_eng_marks; 
	 private BigDecimal  ssc_eng_gpa; 
	 
	 private Integer ssc_math_marks; 
	 private BigDecimal  ssc_math_gpa; 
	 
	 private Integer ssc_sci_marks; 
	 private BigDecimal  ssc_sci_gpa; 
	 
	 private Integer ssc_social_marks; 
	 private BigDecimal  ssc_social_gpa;  
	 
	 private Integer ssc_tot_marks; 
	 private BigDecimal  ssc_tot_gpa; 
	 
	 private Integer temp; 
	 
	 private Integer trno; 
	 private String groupname; 
	 
	 private String  year; 
	 private LocalDateTime entry_date;
	 
	 
	public StudentCandMarksEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentCandMarksEntity(String regid, Integer ssc_first_lang_marks, BigDecimal ssc_first_lang_gpa,
			Integer ssc_second_lang_marks, BigDecimal ssc_second_lang_gpa, Integer ssc_eng_marks,
			BigDecimal ssc_eng_gpa, Integer ssc_math_marks, BigDecimal ssc_math_gpa, Integer ssc_sci_marks,
			BigDecimal ssc_sci_gpa, Integer ssc_social_marks, BigDecimal ssc_social_gpa, Integer ssc_tot_marks,
			BigDecimal ssc_tot_gpa, Integer temp, Integer trno, String groupname, String year,
			LocalDateTime entry_date) {
		super();
		this.regid = regid;
		this.ssc_first_lang_marks = ssc_first_lang_marks;
		this.ssc_first_lang_gpa = ssc_first_lang_gpa;
		this.ssc_second_lang_marks = ssc_second_lang_marks;
		this.ssc_second_lang_gpa = ssc_second_lang_gpa;
		this.ssc_eng_marks = ssc_eng_marks;
		this.ssc_eng_gpa = ssc_eng_gpa;
		this.ssc_math_marks = ssc_math_marks;
		this.ssc_math_gpa = ssc_math_gpa;
		this.ssc_sci_marks = ssc_sci_marks;
		this.ssc_sci_gpa = ssc_sci_gpa;
		this.ssc_social_marks = ssc_social_marks;
		this.ssc_social_gpa = ssc_social_gpa;
		this.ssc_tot_marks = ssc_tot_marks;
		this.ssc_tot_gpa = ssc_tot_gpa;
		this.temp = temp;
		this.trno = trno;
		this.groupname = groupname;
		this.year = year;
		this.entry_date = entry_date;
	}


	public String getRegid() {
		return regid;
	}


	public void setRegid(String regid) {
		this.regid = regid;
	}


	public Integer getSsc_first_lang_marks() {
		return ssc_first_lang_marks;
	}


	public void setSsc_first_lang_marks(Integer ssc_first_lang_marks) {
		this.ssc_first_lang_marks = ssc_first_lang_marks;
	}


	public BigDecimal getSsc_first_lang_gpa() {
		return ssc_first_lang_gpa;
	}


	public void setSsc_first_lang_gpa(BigDecimal ssc_first_lang_gpa) {
		this.ssc_first_lang_gpa = ssc_first_lang_gpa;
	}


	public Integer getSsc_second_lang_marks() {
		return ssc_second_lang_marks;
	}


	public void setSsc_second_lang_marks(Integer ssc_second_lang_marks) {
		this.ssc_second_lang_marks = ssc_second_lang_marks;
	}


	public BigDecimal getSsc_second_lang_gpa() {
		return ssc_second_lang_gpa;
	}


	public void setSsc_second_lang_gpa(BigDecimal ssc_second_lang_gpa) {
		this.ssc_second_lang_gpa = ssc_second_lang_gpa;
	}


	public Integer getSsc_eng_marks() {
		return ssc_eng_marks;
	}


	public void setSsc_eng_marks(Integer ssc_eng_marks) {
		this.ssc_eng_marks = ssc_eng_marks;
	}


	public BigDecimal getSsc_eng_gpa() {
		return ssc_eng_gpa;
	}


	public void setSsc_eng_gpa(BigDecimal ssc_eng_gpa) {
		this.ssc_eng_gpa = ssc_eng_gpa;
	}


	public Integer getSsc_math_marks() {
		return ssc_math_marks;
	}


	public void setSsc_math_marks(Integer ssc_math_marks) {
		this.ssc_math_marks = ssc_math_marks;
	}


	public BigDecimal getSsc_math_gpa() {
		return ssc_math_gpa;
	}


	public void setSsc_math_gpa(BigDecimal ssc_math_gpa) {
		this.ssc_math_gpa = ssc_math_gpa;
	}


	public Integer getSsc_sci_marks() {
		return ssc_sci_marks;
	}


	public void setSsc_sci_marks(Integer ssc_sci_marks) {
		this.ssc_sci_marks = ssc_sci_marks;
	}


	public BigDecimal getSsc_sci_gpa() {
		return ssc_sci_gpa;
	}


	public void setSsc_sci_gpa(BigDecimal ssc_sci_gpa) {
		this.ssc_sci_gpa = ssc_sci_gpa;
	}


	public Integer getSsc_social_marks() {
		return ssc_social_marks;
	}


	public void setSsc_social_marks(Integer ssc_social_marks) {
		this.ssc_social_marks = ssc_social_marks;
	}


	public BigDecimal getSsc_social_gpa() {
		return ssc_social_gpa;
	}


	public void setSsc_social_gpa(BigDecimal ssc_social_gpa) {
		this.ssc_social_gpa = ssc_social_gpa;
	}


	public Integer getSsc_tot_marks() {
		return ssc_tot_marks;
	}


	public void setSsc_tot_marks(Integer ssc_tot_marks) {
		this.ssc_tot_marks = ssc_tot_marks;
	}


	public BigDecimal getSsc_tot_gpa() {
		return ssc_tot_gpa;
	}


	public void setSsc_tot_gpa(BigDecimal ssc_tot_gpa) {
		this.ssc_tot_gpa = ssc_tot_gpa;
	}


	public Integer getTemp() {
		return temp;
	}


	public void setTemp(Integer temp) {
		this.temp = temp;
	}


	public Integer getTrno() {
		return trno;
	}


	public void setTrno(Integer trno) {
		this.trno = trno;
	}


	public String getGroupname() {
		return groupname;
	}


	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public LocalDateTime getEntry_date() {
		return entry_date;
	}


	public void setEntry_date(LocalDateTime entry_date) {
		this.entry_date = entry_date;
	}


	@Override
	public String toString() {
		return "StudentCandMarksEntity [regid=" + regid + ", ssc_first_lang_marks=" + ssc_first_lang_marks
				+ ", ssc_first_lang_gpa=" + ssc_first_lang_gpa + ", ssc_second_lang_marks=" + ssc_second_lang_marks
				+ ", ssc_second_lang_gpa=" + ssc_second_lang_gpa + ", ssc_eng_marks=" + ssc_eng_marks + ", ssc_eng_gpa="
				+ ssc_eng_gpa + ", ssc_math_marks=" + ssc_math_marks + ", ssc_math_gpa=" + ssc_math_gpa
				+ ", ssc_sci_marks=" + ssc_sci_marks + ", ssc_sci_gpa=" + ssc_sci_gpa + ", ssc_social_marks="
				+ ssc_social_marks + ", ssc_social_gpa=" + ssc_social_gpa + ", ssc_tot_marks=" + ssc_tot_marks
				+ ", ssc_tot_gpa=" + ssc_tot_gpa + ", temp=" + temp + ", trno=" + trno + ", groupname=" + groupname
				+ ", year=" + year + ", entry_date=" + entry_date + "]";
	}


	 
	 

}
