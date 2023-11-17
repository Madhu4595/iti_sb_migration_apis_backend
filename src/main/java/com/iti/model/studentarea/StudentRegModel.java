package com.iti.model.studentarea;


import com.iti.customAnnotations.IndianPhoneNumber;
import com.iti.customAnnotations.ValidYear;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class StudentRegModel {
	
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]{8,15}$", message = "SSC Reg Number length should be 8-15 with Alpha Numeric values")
	private String ssc_regno;
	
	@NotNull
	@Min(value = 1, message = "Value must be at least 1")
    @Max(value = 60, message = "Value must be at most 60")
	private String ssc_board;
	
	@NotNull
	@ValidYear
	private Integer ssc_year;
	
	@NotNull
	@Pattern(regexp = "^(3|4)$", message = "SSC Pass month is Invalid,Value should either 3 or 4 Only")
	private String ssc_month;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Name should contain Characters only")
	private String name;
	
	@NotNull
	@NotEmpty
	@NotBlank
    @IndianPhoneNumber
	private String phno;
	
	@NotNull
	@Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-(\\d{4})$", message = "Invalid String of Birth,It should be in the format dd-MM-yyyy") 
	private String  dob;
	
	@NotNull
	@Pattern(regexp = "^[0-9]{12}$", message = "Invalid Aadhaar Number, It length should be 12 digits Only")
	private String adarno;

	@NotNull
	@Pattern(regexp = "^(male|female|Trans)$", message = "Gender Should be Male,Female and Transgender only")
	private String gen;
	
	@NotNull
	@Pattern(regexp = "^[A-Z-]{2,6}$", message = "Invalid category")
	private String caste;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Name should contain Characters only")
	private String fname;
	
	@NotNull
	@Pattern(regexp = "^(yes|no)$", message = "Physically Challegend is Invalid, It should be YES or NO Only")
	private String phc;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Name should contain Characters only")
	private String mname;
	
	@NotNull
	@Pattern(regexp = "^[1-4]{1}$", message = "Invalid PWD category")
	private String pwd_category;
	
	@NotNull
	@Pattern(regexp = "^(yes|no)$", message = "Ex-Servicemen is Invalid, It should be YES or NO Only")
	private String exs;
	
	@NotNull
	@Pattern(regexp = "^(yes|no)$", message = "Qualification is Invalid, It should be YES or NO Only")
	private String ssc;
	
	@NotNull
	@Pattern(regexp = "^(Local|NonLocal)$", message = "Local / Non Local is required, It should be Local or NonLocal Only")
	private String loconoc;
	
	@NotNull
	@Pattern(regexp = "^[0-9]{6}$", message = "Invalid Pincode, It's Length should be SIX Digits Only")
	private String pincode;
	
	@NotNull
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Please Provide valid email")
	private String email;
	
	@NotNull
	@Pattern(regexp = "^(yes|no)$", message = "Economic Weaker Section is Invalid, It should be YES or NO Only")
	private String ews;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String addr;
	
	@NotNull
	@Pattern(regexp = "^(sscm|sscg)$", message = "SSC Type is Invalid")
	private String ssc_type;
	
	@NotNull
	@Pattern(regexp = "^(yes|no)$", message = "No of Languages is Invalid")
	private String noOfLangs;
	
	@NotNull
	@Min(value = 1, message = "Value must be at least 1")
    @Max(value = 100, message = "Value must be at most 100")
	private String first_lang;
	
	@NotNull
	@Min(value = 1, message = "Value must be at least 1")
    @Max(value = 100, message = "Value must be at most 100")
	private String second_lang;
	
	@NotNull
	@Min(value = 1, message = "Value must be at least 1")
    @Max(value = 100, message = "Value must be at most 100")
	private String third_lang;
	
	@NotNull
	@Min(value = 1, message = "Value must be at least 1")
    @Max(value = 100, message = "Value must be at most 100")
	private String maths;
	
	@NotNull
	@Min(value = 1, message = "Value must be at least 1")
    @Max(value = 100, message = "Value must be at most 100")
	private String science;
	
	@NotNull
	@Min(value = 1, message = "Value must be at least 1")
    @Max(value = 100, message = "Value must be at most 100")
	private String social;
	
	@NotNull
	@NotEmpty
    private String photo;

    
	public StudentRegModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StudentRegModel(
			@NotEmpty @NotBlank @Pattern(regexp = "^[A-Za-z0-9]{8,15}$", message = "SSC Reg Number length should be 8-15 with Alpha Numeric values") String ssc_regno,
			@NotNull @Min(value = 1, message = "Value must be at least 1") @Max(value = 60, message = "Value must be at most 60") String ssc_board,
			@NotNull Integer ssc_year,
			@NotNull @Pattern(regexp = "^(3|4)$", message = "SSC Pass month is Invalid,Value should either 3 or 4 Only") String ssc_month,
			@NotNull @NotEmpty @NotBlank @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name should contain Characters only") String name,
			@NotNull @NotEmpty @NotBlank String phno,
			@NotNull @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-(\\d{4})$", message = "Invalid String of Birth,It should be in the format dd-MM-yyyy") String dob,
			@NotNull @Pattern(regexp = "^[0-9]{12}$", message = "Invalid Aadhaar Number, It length should be 12 digits Only") String adarno,
			@NotNull @Pattern(regexp = "^(male|female|Trans)$", message = "Gender Should be Male,Female and Transgender only") String gen,
			@NotNull @Pattern(regexp = "^[A-Z-]{2,6}$", message = "Invalid category") String caste,
			@NotNull @NotEmpty @NotBlank @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name should contain Characters only") String fname,
			@NotNull @Pattern(regexp = "^(yes|no)$", message = "Physically Challegend is Invalid, It should be YES or NO Only") String phc,
			@NotNull @NotEmpty @NotBlank @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name should contain Characters only") String mname,
			@NotNull @Pattern(regexp = "^[1-4]{1}$", message = "Invalid PWD category") String pwd_category,
			@NotNull @Pattern(regexp = "^(yes|no)$", message = "Ex-Servicemen is Invalid, It should be YES or NO Only") String exs,
			@NotNull @Pattern(regexp = "^(yes|no)$", message = "Qualification is Invalid, It should be YES or NO Only") String ssc,
			@NotNull @Pattern(regexp = "^(Local|NonLocal)$", message = "Local / Non Local is required, It should be Local or NonLocal Only") String loconoc,
			@NotNull @Pattern(regexp = "^[0-9]{6}$", message = "Invalid Pincode, It's Length should be SIX Digits Only") String pincode,
			@NotNull @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Please Provide valid email") String email,
			@NotNull @Pattern(regexp = "^(yes|no)$", message = "Economic Weaker Section is Invalid, It should be YES or NO Only") String ews,
			@NotNull @NotEmpty @NotBlank String addr,
			@NotNull @Pattern(regexp = "^(sscm|sscg)$", message = "SSC Type is Invalid") String ssc_type,
			@NotNull @Pattern(regexp = "^(yes|no)$", message = "No of Languages is Invalid") String noOfLangs,
			@NotNull @Min(value = 1, message = "Value must be at least 1") @Max(value = 100, message = "Value must be at most 100") String first_lang,
			@NotNull @Min(value = 1, message = "Value must be at least 1") @Max(value = 100, message = "Value must be at most 100") String second_lang,
			@NotNull @Min(value = 1, message = "Value must be at least 1") @Max(value = 100, message = "Value must be at most 100") String third_lang,
			@NotNull @Min(value = 1, message = "Value must be at least 1") @Max(value = 100, message = "Value must be at most 100") String maths,
			@NotNull @Min(value = 1, message = "Value must be at least 1") @Max(value = 100, message = "Value must be at most 100") String science,
			@NotNull @Min(value = 1, message = "Value must be at least 1") @Max(value = 100, message = "Value must be at most 100") String social,
			@NotNull @NotEmpty String photo) {
		super();
		this.ssc_regno = ssc_regno;
		this.ssc_board = ssc_board;
		this.ssc_year = ssc_year;
		this.ssc_month = ssc_month;
		this.name = name;
		this.phno = phno;
		this.dob = dob;
		this.adarno = adarno;
		this.gen = gen;
		this.caste = caste;
		this.fname = fname;
		this.phc = phc;
		this.mname = mname;
		this.pwd_category = pwd_category;
		this.exs = exs;
		this.ssc = ssc;
		this.loconoc = loconoc;
		this.pincode = pincode;
		this.email = email;
		this.ews = ews;
		this.addr = addr;
		this.ssc_type = ssc_type;
		this.noOfLangs = noOfLangs;
		this.first_lang = first_lang;
		this.second_lang = second_lang;
		this.third_lang = third_lang;
		this.maths = maths;
		this.science = science;
		this.social = social;
		this.photo = photo;
	}


	public String getSsc_regno() {
		return ssc_regno;
	}


	public void setSsc_regno(String ssc_regno) {
		this.ssc_regno = ssc_regno;
	}


	public String getSsc_board() {
		return ssc_board;
	}


	public void setSsc_board(String ssc_board) {
		this.ssc_board = ssc_board;
	}


	public Integer getSsc_year() {
		return ssc_year;
	}


	public void setSsc_year(Integer ssc_year) {
		this.ssc_year = ssc_year;
	}


	public String getSsc_month() {
		return ssc_month;
	}


	public void setSsc_month(String ssc_month) {
		this.ssc_month = ssc_month;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhno() {
		return phno;
	}


	public void setPhno(String phno) {
		this.phno = phno;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getAdarno() {
		return adarno;
	}


	public void setAdarno(String adarno) {
		this.adarno = adarno;
	}


	public String getGen() {
		return gen;
	}


	public void setGen(String gen) {
		this.gen = gen;
	}


	public String getCaste() {
		return caste;
	}


	public void setCaste(String caste) {
		this.caste = caste;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getPhc() {
		return phc;
	}


	public void setPhc(String phc) {
		this.phc = phc;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getPwd_category() {
		return pwd_category;
	}


	public void setPwd_category(String pwd_category) {
		this.pwd_category = pwd_category;
	}


	public String getExs() {
		return exs;
	}


	public void setExs(String exs) {
		this.exs = exs;
	}


	public String getSsc() {
		return ssc;
	}


	public void setSsc(String ssc) {
		this.ssc = ssc;
	}


	public String getLoconoc() {
		return loconoc;
	}


	public void setLoconoc(String loconoc) {
		this.loconoc = loconoc;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEws() {
		return ews;
	}


	public void setEws(String ews) {
		this.ews = ews;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getSsc_type() {
		return ssc_type;
	}


	public void setSsc_type(String ssc_type) {
		this.ssc_type = ssc_type;
	}


	public String getNoOfLangs() {
		return noOfLangs;
	}


	public void setNoOfLangs(String noOfLangs) {
		this.noOfLangs = noOfLangs;
	}


	public String getFirst_lang() {
		return first_lang;
	}


	public void setFirst_lang(String first_lang) {
		this.first_lang = first_lang;
	}


	public String getSecond_lang() {
		return second_lang;
	}


	public void setSecond_lang(String second_lang) {
		this.second_lang = second_lang;
	}


	public String getThird_lang() {
		return third_lang;
	}


	public void setThird_lang(String third_lang) {
		this.third_lang = third_lang;
	}


	public String getMaths() {
		return maths;
	}


	public void setMaths(String maths) {
		this.maths = maths;
	}


	public String getScience() {
		return science;
	}


	public void setScience(String science) {
		this.science = science;
	}


	public String getSocial() {
		return social;
	}


	public void setSocial(String social) {
		this.social = social;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	@Override
	public String toString() {
		return "StudentRegModel [ssc_regno=" + ssc_regno + ", ssc_board=" + ssc_board + ", ssc_year=" + ssc_year
				+ ", ssc_month=" + ssc_month + ", name=" + name + ", phno=" + phno + ", dob=" + dob + ", adarno="
				+ adarno + ", gen=" + gen + ", caste=" + caste + ", fname=" + fname + ", phc=" + phc + ", mname="
				+ mname + ", pwd_category=" + pwd_category + ", exs=" + exs + ", ssc=" + ssc + ", loconoc=" + loconoc
				+ ", pincode=" + pincode + ", email=" + email + ", ews=" + ews + ", addr=" + addr + ", ssc_type="
				+ ssc_type + ", noOfLangs=" + noOfLangs + ", first_lang=" + first_lang + ", second_lang=" + second_lang
				+ ", third_lang=" + third_lang + ", maths=" + maths + ", science=" + science + ", social=" + social
				+ ", photo=" + photo + "]";
	}




}













































































































	
	


