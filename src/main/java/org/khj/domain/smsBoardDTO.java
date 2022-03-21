package org.khj.domain;

import java.util.ArrayList;

public class smsBoardDTO {
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private int cnt;
	private int good;
	
	private ArrayList<smsAttachFileDTO> attachList;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	
	public ArrayList<smsAttachFileDTO> getAttachList() {
		return attachList;
	}
	public void setAttachList(ArrayList<smsAttachFileDTO> attachList) {
		this.attachList = attachList;
	}
	
	@Override
	public String toString() {
		return "smsBoardDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regdate=" + regdate + ", cnt=" + cnt + ", good=" + good + ", attachList=" + attachList + "]";
	}

}
