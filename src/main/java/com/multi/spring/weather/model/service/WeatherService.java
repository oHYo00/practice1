package com.multi.spring.weather.model.service;

import com.multi.spring.weather.model.dto.WeatherDTO;

public interface WeatherService {

	int insertWeather(WeatherDTO weatherDTO)throws Exception;

}
