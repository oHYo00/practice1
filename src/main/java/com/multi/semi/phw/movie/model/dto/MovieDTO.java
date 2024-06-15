package com.multi.spring.movie.model.dto;

public class MovieDTO {
	private int movieId;
	private String title;
	private String img;
	private String genre;
	private String runningTime;
	private String link;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", title=" + title + ", img=" + img + ", genre=" + genre
				+ ", runningTime=" + runningTime + ", link=" + link + "]";
	}
	

}
