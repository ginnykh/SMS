package org.khj.domain;

public class smsReplyDTO {

	//댓글번호
	private int rno; 
	//게시판번호
	private int bno;
	//댓글내용
	private String reply;
	//댓글 작성자
	private String replyer;
	//댓글 작성일
	private String replydate;
//	// 현재 로그인한 사용자
//	private String userName;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReplydate() {
		return replydate;
	}
	public void setReplydate(String replydate) {
		this.replydate = replydate;
	}

//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
	
//	@Override
//	public String toString() {
//		return "smsReplyDTO [rno=" + rno + ", bno=" + bno + ", reply=" + reply + ", replyer=" + replyer + ", replydate="
//				+ replydate + ", userName=" + userName + "]";
//	}
	
	@Override
	public String toString() {
		return "smsReplyDTO [rno=" + rno + ", bno=" + bno + ", reply=" + reply + ", replyer=" + replyer + ", replydate="
				+ replydate + "]";
	}	
	
}
