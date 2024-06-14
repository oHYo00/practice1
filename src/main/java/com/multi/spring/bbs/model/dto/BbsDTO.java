package com.multi.spring.bbs.model.dto;

public class BbsDTO {
	private int bbsid;
	private String title;
	private String  content;
	private String  writer;
	private String  fileName;
	private int rownum;
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getBbsid() {
		return bbsid;
	}
	public void setBbsid(int bbsid) {
		this.bbsid = bbsid;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "BbsDTO [bbsid=" + bbsid + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", fileName=" + fileName + "]";
	}
	
	
}
