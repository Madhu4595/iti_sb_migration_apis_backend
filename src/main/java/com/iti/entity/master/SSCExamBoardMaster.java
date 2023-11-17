package com.iti.entity.master;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ssc_examboard_mst",schema = "admissions")
public class SSCExamBoardMaster {
	@Id
	private String boardCode;
	private String boardName;
	private Long trno;
	private Integer displayOrder;
	public SSCExamBoardMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SSCExamBoardMaster(String boardCode, String boardName, Long trno, Integer displayOrder) {
		super();
		this.boardCode = boardCode;
		this.boardName = boardName;
		this.trno = trno;
		this.displayOrder = displayOrder;
	}
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public Long getTrno() {
		return trno;
	}
	public void setTrno(Long trno) {
		this.trno = trno;
	}
	public Integer getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	@Override
	public String toString() {
		return "SSCExamBoardMaster [boardCode=" + boardCode + ", boardName=" + boardName + ", trno=" + trno
				+ ", displayOrder=" + displayOrder + "]";
	}
	
	

}
