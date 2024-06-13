package com.multi.spring.weather.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.weather.model.dto.WeatherDTO;

@Repository
public class WeatherDAO {

	public int insertWeather(WeatherDTO weatherDTO, SqlSessionTemplate sessionTemplate) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("weathMapper.insert");
	}

}
