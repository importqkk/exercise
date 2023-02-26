package com.exercise.exPage.controller;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.exercise.exPage.dto.BoardDto;
import com.exercise.exPage.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// 게시글 등록
	@GetMapping("/post")
	public String post(Model model, 
			@RequestParam(required = false) Integer boardParent) {
		model.addAttribute("boardParent", boardParent);
		return "/WEB-INF/views/board/post.jsp";
	}
	@PostMapping("/post")
	public String post(HttpSession session, RedirectAttributes attr,
			@ModelAttribute BoardDto boardDto,
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		String memberID = (String)session.getAttribute("memberID");
		boardDto.setBoardWriter(memberID);
		int boardNo = boardService.post(boardDto, attach);
		attr.addAttribute("boardNo", boardNo);
		return "redirect:postComplete";
	}
	@GetMapping("/postComplete")
	public String postComplete() {
		return "/WEB-INF/views/board/postComplete.jsp";
	}
	
}
