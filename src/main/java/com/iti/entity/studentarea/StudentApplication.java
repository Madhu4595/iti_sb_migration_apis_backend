package com.iti.entity.studentarea;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="student_application")
public class StudentApplication {
	
	@Id
	private String sscRegno;
	
	
	@Column(name = "regid")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_registration_id_seq")
    @SequenceGenerator(name = "application_registration_id_seq", sequenceName = "application_registration_id_seq", allocationSize = 1)
	private String regid;
	
	private String adarno;
	
	private String addr;
	private String age_21;
	private String appStatus;
	private String caste;
	private String casteCertificate;
	private String dataFlag;
	private Date dob;
	private boolean economicWeakerSection;
	private String email;
	private LocalDateTime entryDate;
	private String est;
	private String ewsv;
	//private String exService;
	private String experience;
	private boolean exservice;
	private String fname;
	private String gender;
	private Integer interMarks;
	private boolean interPassed;
	private String ip;
	private boolean isTraineeDualMode;
	private String local;
	private String mname;
	private String name;
	private String nativityCertificate;
	private String phChallenge;
	private Integer phase; 
	private boolean phc;
	private Long phno;
	private Integer pincode;
	private String pwdCategory;
	private String reason;
	private String sscBoard;
	private String sscEqMarks;
	private String sscMonth;
	private boolean sscPassed;
	private String sscType;
	private String sscYear;
	private String studyCertificate;
	private String tc;
	private Long trno;
	private String ts;
	private String uid;
	private String uidv;
	private String universityArea;
	private String userId;
	private LocalDateTime verifiedDate;
	private String verifiedIp;
	private String year;
	
	public StudentApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentApplication(String sscRegno, String regid, String adarno, String addr, String age_21,
			String appStatus, String caste, String casteCertificate, String dataFlag, Date dob,
			boolean economicWeakerSection, String email, LocalDateTime entryDate, String est, String ewsv,
			String experience, boolean exservice, String fname, String gender, Integer interMarks, boolean interPassed,
			String ip, boolean isTraineeDualMode, String local, String mname, String name, String nativityCertificate,
			String phChallenge, Integer phase, boolean phc, Long phno, Integer pincode, String pwdCategory,
			String reason, String sscBoard, String sscEqMarks, String sscMonth, boolean sscPassed, String sscType,
			String sscYear, String studyCertificate, String tc, Long trno, String ts, String uid, String uidv,
			String universityArea, String userId, LocalDateTime verifiedDate, String verifiedIp, String year) {
		super();
		this.sscRegno = sscRegno;
		this.regid = regid;
		this.adarno = adarno;
		this.addr = addr;
		this.age_21 = age_21;
		this.appStatus = appStatus;
		this.caste = caste;
		this.casteCertificate = casteCertificate;
		this.dataFlag = dataFlag;
		this.dob = dob;
		this.economicWeakerSection = economicWeakerSection;
		this.email = email;
		this.entryDate = entryDate;
		this.est = est;
		this.ewsv = ewsv;
		this.experience = experience;
		this.exservice = exservice;
		this.fname = fname;
		this.gender = gender;
		this.interMarks = interMarks;
		this.interPassed = interPassed;
		this.ip = ip;
		this.isTraineeDualMode = isTraineeDualMode;
		this.local = local;
		this.mname = mname;
		this.name = name;
		this.nativityCertificate = nativityCertificate;
		this.phChallenge = phChallenge;
		this.phase = phase;
		this.phc = phc;
		this.phno = phno;
		this.pincode = pincode;
		this.pwdCategory = pwdCategory;
		this.reason = reason;
		this.sscBoard = sscBoard;
		this.sscEqMarks = sscEqMarks;
		this.sscMonth = sscMonth;
		this.sscPassed = sscPassed;
		this.sscType = sscType;
		this.sscYear = sscYear;
		this.studyCertificate = studyCertificate;
		this.tc = tc;
		this.trno = trno;
		this.ts = ts;
		this.uid = uid;
		this.uidv = uidv;
		this.universityArea = universityArea;
		this.userId = userId;
		this.verifiedDate = verifiedDate;
		this.verifiedIp = verifiedIp;
		this.year = year;
	}

	public String getSscRegno() {
		return sscRegno;
	}

	public void setSscRegno(String sscRegno) {
		this.sscRegno = sscRegno;
	}

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	public String getAdarno() {
		return adarno;
	}

	public void setAdarno(String adarno) {
		this.adarno = adarno;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAge_21() {
		return age_21;
	}

	public void setAge_21(String age_21) {
		this.age_21 = age_21;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getCasteCertificate() {
		return casteCertificate;
	}

	public void setCasteCertificate(String casteCertificate) {
		this.casteCertificate = casteCertificate;
	}

	public String getDataFlag() {
		return dataFlag;
	}

	public void setDataFlag(String dataFlag) {
		this.dataFlag = dataFlag;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isEconomicWeakerSection() {
		return economicWeakerSection;
	}

	public void setEconomicWeakerSection(boolean economicWeakerSection) {
		this.economicWeakerSection = economicWeakerSection;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public String getEst() {
		return est;
	}

	public void setEst(String est) {
		this.est = est;
	}

	public String getEwsv() {
		return ewsv;
	}

	public void setEwsv(String ewsv) {
		this.ewsv = ewsv;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public boolean isExservice() {
		return exservice;
	}

	public void setExservice(boolean exservice) {
		this.exservice = exservice;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getInterMarks() {
		return interMarks;
	}

	public void setInterMarks(Integer interMarks) {
		this.interMarks = interMarks;
	}

	public boolean isInterPassed() {
		return interPassed;
	}

	public void setInterPassed(boolean interPassed) {
		this.interPassed = interPassed;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public boolean isTraineeDualMode() {
		return isTraineeDualMode;
	}

	public void setTraineeDualMode(boolean isTraineeDualMode) {
		this.isTraineeDualMode = isTraineeDualMode;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNativityCertificate() {
		return nativityCertificate;
	}

	public void setNativityCertificate(String nativityCertificate) {
		this.nativityCertificate = nativityCertificate;
	}

	public String getPhChallenge() {
		return phChallenge;
	}

	public void setPhChallenge(String phChallenge) {
		this.phChallenge = phChallenge;
	}

	public Integer getPhase() {
		return phase;
	}

	public void setPhase(Integer phase) {
		this.phase = phase;
	}

	public boolean isPhc() {
		return phc;
	}

	public void setPhc(boolean phc) {
		this.phc = phc;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getPwdCategory() {
		return pwdCategory;
	}

	public void setPwdCategory(String pwdCategory) {
		this.pwdCategory = pwdCategory;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSscBoard() {
		return sscBoard;
	}

	public void setSscBoard(String sscBoard) {
		this.sscBoard = sscBoard;
	}

	public String getSscEqMarks() {
		return sscEqMarks;
	}

	public void setSscEqMarks(String sscEqMarks) {
		this.sscEqMarks = sscEqMarks;
	}

	public String getSscMonth() {
		return sscMonth;
	}

	public void setSscMonth(String sscMonth) {
		this.sscMonth = sscMonth;
	}

	public boolean isSscPassed() {
		return sscPassed;
	}

	public void setSscPassed(boolean sscPassed) {
		this.sscPassed = sscPassed;
	}

	public String getSscType() {
		return sscType;
	}

	public void setSscType(String sscType) {
		this.sscType = sscType;
	}

	public String getSscYear() {
		return sscYear;
	}

	public void setSscYear(String sscYear) {
		this.sscYear = sscYear;
	}

	public String getStudyCertificate() {
		return studyCertificate;
	}

	public void setStudyCertificate(String studyCertificate) {
		this.studyCertificate = studyCertificate;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public Long getTrno() {
		return trno;
	}

	public void setTrno(Long trno) {
		this.trno = trno;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUidv() {
		return uidv;
	}

	public void setUidv(String uidv) {
		this.uidv = uidv;
	}

	public String getUniversityArea() {
		return universityArea;
	}

	public void setUniversityArea(String universityArea) {
		this.universityArea = universityArea;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDateTime getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate(LocalDateTime verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	public String getVerifiedIp() {
		return verifiedIp;
	}

	public void setVerifiedIp(String verifiedIp) {
		this.verifiedIp = verifiedIp;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "StudentApplication [sscRegno=" + sscRegno + ", regid=" + regid + ", adarno=" + adarno + ", addr=" + addr
				+ ", age_21=" + age_21 + ", appStatus=" + appStatus + ", caste=" + caste + ", casteCertificate="
				+ casteCertificate + ", dataFlag=" + dataFlag + ", dob=" + dob + ", economicWeakerSection="
				+ economicWeakerSection + ", email=" + email + ", entryDate=" + entryDate + ", est=" + est + ", ewsv="
				+ ewsv + ", experience=" + experience + ", exservice=" + exservice + ", fname=" + fname + ", gender="
				+ gender + ", interMarks=" + interMarks + ", interPassed=" + interPassed + ", ip=" + ip
				+ ", isTraineeDualMode=" + isTraineeDualMode + ", local=" + local + ", mname=" + mname + ", name="
				+ name + ", nativityCertificate=" + nativityCertificate + ", phChallenge=" + phChallenge + ", phase="
				+ phase + ", phc=" + phc + ", phno=" + phno + ", pincode=" + pincode + ", pwdCategory=" + pwdCategory
				+ ", reason=" + reason + ", sscBoard=" + sscBoard + ", sscEqMarks=" + sscEqMarks + ", sscMonth="
				+ sscMonth + ", sscPassed=" + sscPassed + ", sscType=" + sscType + ", sscYear=" + sscYear
				+ ", studyCertificate=" + studyCertificate + ", tc=" + tc + ", trno=" + trno + ", ts=" + ts + ", uid="
				+ uid + ", uidv=" + uidv + ", universityArea=" + universityArea + ", userId=" + userId
				+ ", verifiedDate=" + verifiedDate + ", verifiedIp=" + verifiedIp + ", year=" + year + "]";
	}

	
	
}
