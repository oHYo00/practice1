package com.multi.spring.page.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.multi.spring.bbs.model.dto.BbsDTO;
import com.multi.spring.bbs.service.BbsService;
import com.multi.spring.page.model.dto.PageDTO;


@Controller
@RequestMapping("/page")
public class PageController {
	@Autowired
	private BbsService bbsService;
	//--------------------------------------------------------- //@Autowired
	
//	@Autowired
//	private final MemberService memberService;
//	//--------------------------------------------------------- //@Autowired
//	 public MemberController(MemberService memberService) {
//		 this.memberService =memberService; 
//		 }
	 
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/bbsMain")
	public void pageMain() {}
	
	@RequestMapping("/bbsAll")
	public void selectAll(PageDTO pageDTO,Model model) {
		pageDTO.setStartEnd(pageDTO.getPage());
		
		System.out.println(pageDTO);
		try {
			List<BbsDTO>list=bbsService.selectAll(pageDTO);
			
			int count=bbsService.selectCount();
			
			int pages=count/10+1;
			model.addAttribute("list",list);
			model.addAttribute("count",count);
			model.addAttribute("pages",pages);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
