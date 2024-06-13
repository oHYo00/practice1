package com.multi.spring.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.multi.spring.member.model.dto.MemberDTO;
import com.multi.spring.member.service.MemberService;


/* error-page
 * exception-type
 * ExceptionHandler
 * ControllerAdvice + ExceptionHandler
 * */


@SessionAttributes("loginUser")// Model에 Attribute 추가할때 자동으로 설정된 키값을 세션에 등록 시키는 기능
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private final MemberService memberService;
	//--------------------------------------------------------- //@Autowired
	 public MemberController(MemberService memberService) {
		 this.memberService =memberService; 
		 }
	 
//	 @ExceptionHandler(value = BadSqlGrammarException.class)// 쿼리를 붙이고 테스트
//		public ModelAndView controllerExceptionHandler(Exception e) {
//			
//			e.printStackTrace();
//			return new ModelAndView("common/errorPageServer").addObject("msg",e.getMessage());
//		}
		
		
//		@ExceptionHandler(value = Exception.class)
//		public ModelAndView controllerExceptionHandler(Exception e) {
//			
//			e.printStackTrace();
//			return new ModelAndView("common/errorPage").addObject("msg",e.getMessage());
//		}
	 
	 
	 
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/member")
	public void memberMain() {
		
	}
	
	@RequestMapping("/insert_form")
	public void insert() {
		
	}
	
	@RequestMapping("/delete_form")
	public void delete() {
		
	}
	@RequestMapping("/update_form")
	public void update() {
		
	}
	
	@RequestMapping("/one_form")
	public void one() {
		
	}
	
	@RequestMapping("/enrollForm")
	public String enrollForm() {
		return "member/enroll_form";
	}
	
	@RequestMapping("/list")
	public void selectList(Model model) {
		try {
			ArrayList<MemberDTO> list = memberService.selectList();
			System.out.println(list);
			model.addAttribute("list",list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/one")
	public void selectOne(Model model,String id) {
		try {MemberDTO dto=null;
		
			dto = memberService.selectOne(id);
			System.out.println(dto);
			model.addAttribute("dto",dto);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@RequestMapping("/delete")
	public String deleteMember(String id,HttpSession session) {
		System.out.println("delete ==> "+id);
		int result=0;
		
		try {
			result=memberService.deleteMember(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0) {
		session.setAttribute("msg", "회원탈퇴성공");}
		
		return "redirect:/member/member";
	}
	
	@PostMapping("/insert")
	public String insertMember(MemberDTO memberDTO,HttpSession session) {
		System.out.println("insert ==> "+memberDTO);
		int result=0;
		
		try {
			result=memberService.insertMember(memberDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0) {
		session.setAttribute("msg", "회원가입성공");}
		return "redirect:/member/member";
	}
	
	@PostMapping("/update")
	public String updateMember(MemberDTO memberDTO,HttpSession session)throws Exception {
		System.out.println("update ==> "+memberDTO);
		int result=0;
		
		
			result=memberService.updateMember(memberDTO);
		
		if(result>0) {
		session.setAttribute("msg", "회원수정성공");}
		return "redirect:/member/member";
	}
	
//	@PostMapping("/login")
//	public String loginMember(MemberDTO memberDTO,HttpSession session) {
//		System.out.println("insert ==> "+memberDTO);
//		
//		
//		try {
//			MemberDTO dto=memberService.loginMember(memberDTO);
//			session.setAttribute("loginUser", dto);
//			
//			return "redirect:/";
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			return "common/errorPage";
//		}
//		
//	}
//	
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
	
	@PostMapping("/login")
	public String loginMember(MemberDTO memberDTO,Model model) {
		System.out.println("insert ==> "+memberDTO);
		
		
		try {
			MemberDTO dto=memberService.loginMember(memberDTO);
			model.addAttribute("loginUser", dto);
			
			return "redirect:/";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete(); //현재 SessionAttributes 에 의해 저장된 오브젝트를 제거
		return "redirect:/";
	}
	
	
}
