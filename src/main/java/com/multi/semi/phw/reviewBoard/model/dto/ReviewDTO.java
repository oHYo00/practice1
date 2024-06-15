package com.multi.semi.phw.reviewBoard.model.dto;

public class ReviewDTO {
	private int rownum;
	private int no;
	private String title;
	private String content;
	private String writer;
	private String img;
	
	
	
	
	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	
//	@Override
//	public String toString() {
//		return "BbsVO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + "]";
//	}



	public int getRownum() {
		return rownum;
	}



	@Override
	public String toString() {
		return "ReviewDTO [rownum=" + rownum + ", no=" + no + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", img=" + img + "]";
	}



	public void setRownum(int rownum) {
		this.rownum = rownum;
	}



	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
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
}
