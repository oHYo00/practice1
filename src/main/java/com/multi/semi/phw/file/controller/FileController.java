package com.multi.semi.phw.file.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.multi.spring.file.service.FileService;
import com.multi.spring.movie.model.dto.MovieDTO;
import com.multi.spring.reviewBoard.model.dto.ReviewDTO;


@Controller
@RequestMapping("/file")
public class FileController {
	
	//생성자로
	@Autowired
	FileService fileService;
	
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	

	
	@GetMapping("/filemain")
	public void fileMain() {
	
	}
	
	
	@PostMapping("/insert")
	public void insertMovie(
			MovieDTO movieDTO,
					HttpServletRequest request, 
					MultipartFile singleFile, 
					Model model) throws Exception {
		
		        
//		System.out.println(singleFile.getOriginalFilename());
//		String savedName =  singleFile.getOriginalFilename();
//		String uploadPath 
//			= request.getSession().getServletContext().getRealPath("resources/upload");
//		File target = new File(uploadPath + "/" + savedName);
//		singleFile.transferTo(target);
//		
//		model.addAttribute("savedName", savedName);
//		System.out.println("img넣기 전>> " + movieVO);
//		movieVO.setImg(savedName);
//		System.out.println("img넣은 후>> " + movieVO);
//		
//		fileService.insertMovie(movieVO);
//		//컨트롤로의 vo변수명을 맨앞글자만 소문자로 바꾸어서 변수를 만들면,
//		//자동으로 모델의 속성으로 등록시켜줌.
//		//model.addAttribute("movieVO", movieVO);
		
		
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
			
			
			System.out.println("img넣기 전>> " + movieDTO);
			movieDTO.setImg(savedName);
			System.out.println("img넣은 후>> " + movieDTO);
			fileService.insertMovie(movieDTO);
			model.addAttribute("movieDTO", movieDTO);
			System.out.println("insertMovie 후>> " + movieDTO);
		}catch (Exception e) {
			e.printStackTrace();
			/* 실패시 파일 삭제 */
			new File(filePath + "\\" + savedName).delete();
			model.addAttribute("message", "파일 업로드 실패!!");
		}
		
	}
	
	
	@PostMapping("multi-file")
	public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles, 
			HttpServletRequest request, Model model) {
		String multiFileDescription = request.getParameter("multiFileDescription");
		
		System.out.println("multiFiles : " + multiFiles);
		System.out.println("multiFileDescription : " + multiFileDescription);
		
		/* 파일을 저장할 경로 설정 */
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		System.out.println("root : " + root);
		
		String filePath = root + "\\uploadFiles";
		
		File mkdir = new File(filePath);
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
		List<Map<String, String>> files = new ArrayList<>();
		for(int i = 0; i < multiFiles.size(); i++) {
			
			/* 파일명 변경 처리 */
			String originFileName = multiFiles.get(i).getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

			/* 파일에 관한 정보 추출 후 보관 */
			Map<String, String> file = new HashMap<>();
			file.put("originFileName", originFileName);
			file.put("savedName", savedName);
			file.put("filePath", filePath);
			
			files.add(file);
			
		}
			
			/* 파일을 저장한다. */
			try {
				for(int i = 0; i < multiFiles.size(); i++) {
					Map<String, String> file = files.get(i);
					
					multiFiles.get(i).transferTo(new File(filePath + "\\" + file.get("savedName")));
				}
				
				model.addAttribute("message", "파일 업로드 성공!");
				
			}catch (Exception e) {
				e.printStackTrace();
				/* 실패시 파일 삭제 */
				for(int i = 0; i < multiFiles.size(); i++) {
					Map<String, String> file = files.get(i);
					
					new File(filePath + "\\" + file.get("savedName")).delete();
				}
				
				model.addAttribute("message", "파일 업로드 실패!!");
				
			}
			return "file/result";
			
		}
	
	
	
	
	
	
//	@PostMapping("/insertReview")
//	public void insertReview(
//			ReviewDTO reviewDTO,
//					HttpServletRequest request, 
//					MultipartFile singleFile, 
//					Model model) throws Exception {
//		
//		        
////		System.out.println(singleFile.getOriginalFilename());
////		String savedName =  singleFile.getOriginalFilename();
////		String uploadPath 
////			= request.getSession().getServletContext().getRealPath("resources/upload");
////		File target = new File(uploadPath + "/" + savedName);
////		singleFile.transferTo(target);
////		
////		model.addAttribute("savedName", savedName);
////		System.out.println("img넣기 전>> " + movieVO);
////		movieVO.setImg(savedName);
////		System.out.println("img넣은 후>> " + movieVO);
////		
////		fileService.insertMovie(movieVO);
////		//컨트롤로의 vo변수명을 맨앞글자만 소문자로 바꾸어서 변수를 만들면,
////		//자동으로 모델의 속성으로 등록시켜줌.
////		//model.addAttribute("movieVO", movieVO);
//		
//		
//		System.out.println("singleFile : " + singleFile);
//		
//		/* 파일을 저장할 경로 설정 */
//		String root = request.getSession().getServletContext().getRealPath("resources");
//		
//		System.out.println("root : " + root);
//		
//		String filePath = root + "\\uploadFile";
//		
//		File mkdir = new File(filePath);
//		if(!mkdir.exists()) {
//			mkdir.mkdirs();
//		}
//		
//		/* 파일명 변경 처리 */
//		String originFileName = singleFile.getOriginalFilename();
//		String ext = originFileName.substring(originFileName.lastIndexOf("."));
//		String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
//
//
//		/* 파일을 저장한다. */
//		try {
//			singleFile.transferTo(new File(filePath + "\\" + savedName));
//			
//			model.addAttribute("savedName", savedName);
//			
//			
//			System.out.println("img넣기 전>> " + reviewDTO);
//			reviewDTO.setImg(savedName);
//			System.out.println("img넣은 후>> " + reviewDTO);
//			fileService.insertReview(reviewDTO);
//			model.addAttribute("reviewDTO", reviewDTO);
//			System.out.println("insertReview 후>> " + reviewDTO);
//		}catch (Exception e) {
//			e.printStackTrace();
//			/* 실패시 파일 삭제 */
//			new File(filePath + "\\" + savedName).delete();
//			model.addAttribute("message", "파일 업로드 실패!!");
//		}
//		
//	}
	
	
	
	}
	
	

