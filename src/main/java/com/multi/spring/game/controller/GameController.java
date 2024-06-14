package com.multi.spring.game.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.multi.spring.bbs.model.dto.BbsDTO;
import com.multi.spring.game.model.dto.GameDTO;
import com.multi.spring.game.service.GameService;
import com.multi.spring.page.model.dto.PageDTO;





@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private final GameService GameService;
//	//--------------------------------------------------------- //@Autowired
	 public GameController(GameService GameService) {
		 this.GameService =GameService; 
		 }
	 
	@RequestMapping("main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/gameAll")
	public void gaemLank(PageDTO pageDTO,Model model) {
		
		if(pageDTO.getPage()==0) {
			pageDTO.setPage(1);
		}
		
		ArrayList<GameDTO> list;
		pageDTO.setStartEnd(pageDTO.getPage());
		
		
		System.out.println(pageDTO);
		
		
		try {
			list = GameService.gaemLank(pageDTO);
			System.out.println(list);
			
			int count=GameService.selectCount();
			System.out.println(count);
			int pages=count/10+1;
			model.addAttribute("list",list);
			model.addAttribute("count",count);
			model.addAttribute("page",pages);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	@PostMapping("/insert")
	public String insertGame(GameDTO GameDTO,
					HttpServletRequest request, 
					MultipartFile singleFile, 
					Model model) throws Exception {
		

		System.out.println("singleFile : " + singleFile);
		
		/* 파일을 저장할 경로 설정 */
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		System.out.println("root : " + root);
		
		String filePath = root + "\\uploadFiles";
		
		File mkdir = new File(filePath);
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
		
		/* 파일명 변경 처리 */
		String originFileName = singleFile.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
		/* 파일을 저장한다. */
		try {
			singleFile.transferTo(new File(filePath + "\\" + savedName));
			
			model.addAttribute("savedName", savedName);
			
			
			System.out.println("img넣기 전>> " + GameDTO);
			GameDTO.setImg(savedName);
			System.out.println("img넣은 후>> " + GameDTO);
			int result= GameService.insertGame(GameDTO);
			model.addAttribute("GameDTO", GameDTO);
			System.out.println("insertgame 후>> " + GameDTO);
		}catch (Exception e) {
			e.printStackTrace();
			/* 실패시 파일 삭제 */
			new File(filePath + "\\" + savedName).delete();
			model.addAttribute("message", "파일 업로드 실패!!");
		}
		return "redirect:/game/gameAll";
	}
	
	
	@RequestMapping("/game_insert_form")
	public void gaem_insert_form() {
	
		}
	@RequestMapping("/delete_form")
	public void gaem_delete_form() {
	
		}
	@RequestMapping("/update_form")
	public void gaem_update_form() {
	
		}
	
	@RequestMapping("/One")
	public void gaemSelectOne(GameDTO gameDTO,Model model) throws Exception{
		
			GameDTO dto= GameService.gaemSelectOne(gameDTO);
			model.addAttribute("gameDTO",dto);
		
		}
	
	@PostMapping("/update")
	public String gaemUpdate(GameDTO gameDTO,HttpSession session) throws Exception{
		int result=0;
		
		result=GameService.gaemUpdate(gameDTO);
	if(result>0) {
	session.setAttribute("msg", "게임수정성공");}
	else {
		session.setAttribute("msg", "게임수정실패");
	}
		return "redirect:/game/gameAll";
		}
	
	
	@RequestMapping("/delete")
	public String gaemDelete(GameDTO gameDTO,HttpSession session) throws Exception{
		int result=0;
		result=GameService.gaemDelete(gameDTO);
	if(result>0) {
	session.setAttribute("msg", "게임삭제성공");}
	else {
		session.setAttribute("msg", "게임삭제실패");
	}
		return "redirect:/game/gameAll";
		}
		
	}
	
	

