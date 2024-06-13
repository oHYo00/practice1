package com.multi.spring.bbs.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.multi.spring.bbs.model.dto.BbsDTO;
import com.multi.spring.bbs.service.BbsService;
import com.multi.spring.page.model.dto.PageDTO;


@Controller
@RequestMapping("/bbs")
public class BbsController {
	
	@Autowired
	private BbsService bbsService;
//	//--------------------------------------------------------- //@Autowired
//	 public BoardController(BoardService boardService) {
//		 this.boardService =boardService; 
//		 }
	 
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/bbs")
	public void bbsMain() {
		
	}
	
	@RequestMapping("/bbs_insert_form")
	public void bbs_insert() {
		
	}
	
	@RequestMapping("/bbs_one_form")
	public void bbs_one_from() {
		
	}
	@PostMapping("/insert")
	public void insertMovie(BbsDTO bbsDTO,
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
			
			
			System.out.println("img넣기 전>> " + bbsDTO);
			bbsDTO.setFileName(savedName);
			System.out.println("img넣은 후>> " + bbsDTO);
			bbsService.insertBbs(bbsDTO);
			model.addAttribute("bbsDTO", bbsDTO);
			System.out.println("insertMovie 후>> " + bbsDTO);
		}catch (Exception e) {
			e.printStackTrace();
			/* 실패시 파일 삭제 */
			new File(filePath + "\\" + savedName).delete();
			model.addAttribute("message", "파일 업로드 실패!!");
		}
	}

	@PostMapping("multi-file")
	public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles, 
			HttpServletRequest request, Model model,BbsDTO bbsDTO) {
		
		
		String multiFileDescription = request.getParameter("multiFileDescription");
		System.out.println(multiFiles);
		System.out.println(multiFileDescription);
		/* 파일을 저장할 경로 설정 */
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		System.out.println("root : " + root);
		
		String filePath = root + "\\uploadFiles";
		
		File mkdir = new File(filePath);
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
		List<Map<String,String>>files=new ArrayList<>();
		/* 파일명 변경 처리 */
		for(int i=0;i<multiFiles.size();i++) {
		String originFileName = multiFiles.get(i).getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
		
		
		
		Map<String, String> file=new HashMap<>();
		file.put("originFileName", originFileName);
		file.put("savedName", savedName);
		file.put("filePath", filePath);
		
		files.add(file);
		}try {
		for(int i=0;i<multiFiles.size();i++) {
			
			bbsDTO.setTitle("미상");
			bbsDTO.setWriter("공백");
			bbsDTO.setContent("공백");
		
		
			Map<String, String>file=files.get(i);
			bbsDTO.setFileName(file.get("savedName"));
			bbsService.insertBbs(bbsDTO);
				multiFiles.get(i).transferTo(new File(filePath + "\\" + file.get("savedName")));
			} 
		model.addAttribute("message","성공");
		}catch (Exception e) {
			
				e.printStackTrace();
				
				for(int i=0;i<multiFiles.size();i++) {
					Map<String, String>file=files.get(i);
					new File(filePath + "\\" + file.get("savedName")).delete();
				}
				model.addAttribute("message","실패");
			}
		
		
		
		return "redirect:/bbs/bbsAll";
	}
	@RequestMapping("/bbsAll")
	public void selectAll(PageDTO pageDTO,Model model) {
		
		if(pageDTO.getPage()==0) {
			pageDTO.setPage(1);
		}
		
		pageDTO.setStartEnd(pageDTO.getPage());
		System.out.println(pageDTO);
		try {
			List<BbsDTO>list=bbsService.selectAll(pageDTO);
			
			int count=bbsService.selectCount();
			
			int pages=count/10+1;
			model.addAttribute("list",list);
			model.addAttribute("count",count);
			model.addAttribute("page",pages);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/bbsOne")
	public String oneBbs(BbsDTO bbsDTO,
					HttpServletRequest request,  
					Model model) throws Exception {
		

		
		
		try {
			
			bbsDTO=bbsService.selectOne(bbsDTO);
			model.addAttribute("bbsDTO", bbsDTO);
			model.addAttribute("savedName", bbsDTO.getFileName());
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		return "/bbs/bbsOne";
	}
	
	
}
