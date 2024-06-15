package com.multi.spring.reviewBoard.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.multi.spring.board.model.dto.Board2DTO;
import com.multi.spring.reviewBoard.model.dto.Page2DTO;
import com.multi.spring.reviewBoard.model.dto.ReviewDTO;
import com.multi.spring.reviewBoard.service.ReviewService;



@Controller
@RequestMapping("/reviewBoard")
public class ReviewController {
	
	//생성자로
	@Autowired
	ReviewService reviewService;
	
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/reviewInsert")
	public void reviewInsert() {
	
	}
	
	
	@RequestMapping("/reviewDelete")
	public void reviewDelete() {
	
	}
	
	@RequestMapping("/reviewUpdate")
	public void reviewUpdate() {
	
	}

	
	@GetMapping("/reviewMain")
	public void reviewMain(Page2DTO pageDto, Model model) {
	
		pageDto.setStartEnd(pageDto.getPage());
		
		List<ReviewDTO> list = reviewService.reviewMain(pageDto);
		int count = reviewService.selectCount();
		
//		System.out.println(list);
		int pages = count / 10 + 1; //전체 페이지 개수 구하기
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pages", pages);
	}
	
	
	
	@GetMapping("reviewList2")
	public void selectbbsList2(Page2DTO pageDto, Model model) {
	
		pageDto.setStartEnd(pageDto.getPage());
		
		List<ReviewDTO> list = reviewService.reviewMain(pageDto);
		
		model.addAttribute("list", list);
	}
	

	
	@GetMapping("/reviewOne")
    public String selectTitle(Integer id, Model model) {
	
        ReviewDTO dto = reviewService.selectTitle(id);
        model.addAttribute("bag", dto);
        
        
        System.out.println(id);
        return "reviewBoard/reviewOne";
    }

	
	 

	
	
//	@PostMapping("/insertReview")
//	public void insertReview(
//			ReviewDTO reviewDTO,
//					HttpServletRequest request, 
//					MultipartFile singleFile, 
//					Model model) throws Exception {
//		
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
//			reviewService.insertReview(reviewDTO);
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
	
	@PostMapping("/insert")
	public String reviewInsert(ReviewDTO reviewDTO, HttpSession session) throws Exception{
		System.out.println("insertReview ==>" + reviewDTO);
		reviewService.reviewInsert(reviewDTO);
		
//		session.setAttribute("msg", "게시글 작성 성공");
		return "redirect:/reviewBoard/reviewMain?page=1";

		
		
	}
	
	

	
	
	@PostMapping("/update")
	public String reviewUpdate(ReviewDTO reviewDTO, HttpSession session) throws Exception{
		System.out.println("insert ==> " + reviewDTO);
		
		System.out.println(reviewDTO);
		reviewService.reviewUpdate(reviewDTO);
		
//		session.setAttribute("msg", "게시글 수정 성공");
		return "redirect:/reviewBoard/reviewMain?page=1";
	}
	
	@GetMapping("/update")
	public String reviewUpdate(Integer id, HttpSession session) throws Exception{

		
		session.setAttribute("id", id);
		return "reviewBoard/reviewUpdate";
	}
	
	

	
	@GetMapping("/delete")
	public String reviewDelete(Integer id, HttpSession session) throws Exception{
		reviewService.reviewDelete(id);
				
		session.setAttribute("msg", "게시글 삭제 성공");
		return "reviewBoard/reviewDelete";
	}
	
	
}
	
	

