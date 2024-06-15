package com.multi.semi.phw.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class MainController {


	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
		
		
	}
	
	
	@RequestMapping("/myShopChatBot")
	public String memberMain() {
		
		return "/chat/myShopChatBot";
	
	}
	
	
	@RequestMapping("/realChat")
	public String insertForm() {
		
		return "/chat/realChat";
		
	
	}
}