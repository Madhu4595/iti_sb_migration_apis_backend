package com.iti.entity.studentarea;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="img_cand_photos")
public class ImageCandPhotosEntity {

	@Id
	private String regid;
	
	@Column(length = 1000)
	private byte[] pic;
	
	@Column(length = 1000)
	private byte[] physicallyCertificate;
	
	@Column(length = 1000)
	private byte[] exserviceCertificate;
	
	@Column(length = 1000)
	private byte[] casteCertificate;
	
	@Column(length = 1000)
	private byte[] sscCertificate;
	
	private Integer result;

	public ImageCandPhotosEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageCandPhotosEntity(String regid, byte[] pic, byte[] physicallyCertificate, byte[] exserviceCertificate,
			byte[] casteCertificate, byte[] sscCertificate, Integer result) {
		super();
		this.regid = regid;
		this.pic = pic;
		this.physicallyCertificate = physicallyCertificate;
		this.exserviceCertificate = exserviceCertificate;
		this.casteCertificate = casteCertificate;
		this.sscCertificate = sscCertificate;
		this.result = result;
	}

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public byte[] getPhysicallyCertificate() {
		return physicallyCertificate;
	}

	public void setPhysicallyCertificate(byte[] physicallyCertificate) {
		this.physicallyCertificate = physicallyCertificate;
	}

	public byte[] getExserviceCertificate() {
		return exserviceCertificate;
	}

	public void setExserviceCertificate(byte[] exserviceCertificate) {
		this.exserviceCertificate = exserviceCertificate;
	}

	public byte[] getCasteCertificate() {
		return casteCertificate;
	}

	public void setCasteCertificate(byte[] casteCertificate) {
		this.casteCertificate = casteCertificate;
	}

	public byte[] getSscCertificate() {
		return sscCertificate;
	}

	public void setSscCertificate(byte[] sscCertificate) {
		this.sscCertificate = sscCertificate;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ImageCandPhotosEntity [regid=" + regid + ", pic=" + Arrays.toString(pic) + ", physicallyCertificate="
				+ Arrays.toString(physicallyCertificate) + ", exserviceCertificate="
				+ Arrays.toString(exserviceCertificate) + ", casteCertificate=" + Arrays.toString(casteCertificate)
				+ ", sscCertificate=" + Arrays.toString(sscCertificate) + ", result=" + result + "]";
	}
	
	
	
}
