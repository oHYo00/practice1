package com.multi.spring.game.model.dto;

public class GameDTO {
	private int rownum;

private int	id ;
private String img;
 private String name;
 private String developer ;
 private double grade ;
public int getId() {
	return id;
} 

public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
	
	
public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDeveloper() {
	return developer;
}
public void setDeveloper(String developer) {
	this.developer = developer;
}
public double getGrade() {
	return grade;
}
public void setGrade(double grade) {
	this.grade = grade;
}

@Override
public String toString() {
	return "GameDTO [rownum=" + rownum + ", id=" + id + ", name=" + name + ", developer=" + developer + ", grade="
			+ grade + "]";
}

 
}
