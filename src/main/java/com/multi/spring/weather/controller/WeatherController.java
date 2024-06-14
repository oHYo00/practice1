package com.multi.spring.weather.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.spring.weather.model.dto.WeatherDTO;
import com.multi.spring.weather.model.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	WeatherService weatherService;
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("weather")
	public void weatherMain() {
	
	}
	@RequestMapping("weatherAPI")
	public void ajax4() {
	
	}
	@RequestMapping("weatherSet")
	public void weatherSet() {
	
	}
	@RequestMapping("weatherList")
	public void weatherSetList(WeatherDTO vo, Model model) {
	//computer?com=맥&price=2000&mouse=로지텍&price2=1000
	//public void computer(String com, int pirce, String mouse, int price2)
		System.out.println(vo);
		String w="";
		
		
		
		if(vo.getWeather().equals("구름")) {
			w="구름.png";
		}
		else if(vo.getWeather().equals("비")) {
			w="비.png";
		}
		else if(vo.getWeather().equals("overcast clouds")) {
			w="구름.png";
		}
		else {
			w="해.png";
		}
		model.addAttribute("w", w);
		//total = 3000
	}
	@PostMapping("/insert")
	public String insertWeather(WeatherDTO WeatherDTO,HttpSession session) {
		System.out.println("insert ==> "+WeatherDTO);
		int result=0;
		
		try {
			result=weatherService.insertWeather(WeatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0) {
		session.setAttribute("msg", "추가성공");}
	return "/weather/weather";
	}
	
	
}
