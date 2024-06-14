package com.multi.semi.phw;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.spring.board.model.dto.Board2DTO;
import com.multi.spring.board.service.Board2Service;


@Controller
@RequestMapping("/board")
public class Board2Controller {
	
	//생성자 주입
	private final Board2Service boardService;
	//--------------------------------------------------------- //@Autowired
	public Board2Controller(Board2Service boardService) {
		this.boardService = boardService;
	}
	
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	

	
	@RequestMapping("/bbs")
	public void bbs() {
	
	}
	
	@RequestMapping("/bbs_insert_form")
	public void bbsInsertForm() {
	
	}
	
	@RequestMapping("/bbs_delete_form")
	public void bbsDeleteForm() {
	
	}
	
	@RequestMapping("/bbs_update_form")
	public void bbsUpdateForm() {
	
	}
	
	@RequestMapping("/bbs_one_form")
	public void bbsOneForm() {
	
	}

	
	
	@PostMapping("/insert")
	public String insertBoard(Board2DTO board2DTO, HttpSession session) throws Exception{
		System.out.println("insertBoard ==>" + board2DTO);
		boardService.insertBoard(board2DTO);
		
		session.setAttribute("msg", "게시글 작성 성공");
		return "redirect:/board/bbs_list";
	}
	
	
	
	@GetMapping("/bbs_list")
	public void selectList(Model model) throws Exception{
		List<Board2DTO> list = boardService.selectList();
				
		model.addAttribute("list", list);
	}
	
	@GetMapping("/delete")
	public String deleteBoard(int no, HttpSession session) throws Exception{
		boardService.deleteBoard(no);
				
		session.setAttribute("msg", "게시글 삭제 성공");
		return "redirect:/board/bbs";
	}
	
	@PostMapping("/update")
	public String updateBoard(Board2DTO board2DTO, HttpSession session) throws Exception{
		System.out.println("insert ==> " + board2DTO);
		
		boardService.updateBoard(board2DTO);
		
		session.setAttribute("msg", "게시글 수정 성공");
		return "redirect:/board/bbs";
	}
	
	@GetMapping("/one")
	public String selectBoard(@RequestParam("no") int no, Model model) throws Exception{
		Board2DTO dto = boardService.selectBoard(no);
        model.addAttribute("bag", dto);

        return "board/bbs_one";
	}

}
