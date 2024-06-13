package com.multi.spring.weather.model.dto;

public class WeatherDTO {
	
	
	
private String weather;
private String wind;
private String temperature;
private String bodytemperature;
private String cloud;

public String getWeather() {
	return weather;
}

public void setWeather(String weather) {
	this.weather = weather;
}

public String getWind() {
	return wind;
}

public void setWind(String wind) {
	this.wind = wind;
}

public String getTemperature() {
	return temperature;
}

public void setTemperature(String temperature) {
	this.temperature = temperature;
}

public String getBodytemperature() {
	return bodytemperature;
}

public void setBodytemperature(String bodytemperature) {
	this.bodytemperature = bodytemperature;
}

public String getCloud() {
	return cloud;
}

public void setCloud(String cloud) {
	this.cloud = cloud;
}

@Override
public String toString() {
	return "WeatherDTO [weather=" + weather + ", wind=" + wind + ", temperature=" + temperature + ", bodytemperature="
			+ bodytemperature + ", cloud=" + cloud + "]";
}




}
