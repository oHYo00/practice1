package com.multi.spring.weather.model.service;

import java.io.IOException;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.weather.model.dao.WeatherDAO;
import com.multi.spring.weather.model.dto.WeatherDTO;

@Service
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	 WeatherDAO dao;
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	@Override
	public int insertWeather(WeatherDTO weatherDTO) throws Exception {
		int result=dao.insertWeather(weatherDTO,sessionTemplate);
		return result;
	}

	

}
