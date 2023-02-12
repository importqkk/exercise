package com.exercise.ex230211.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.exercise.ex230211.dao.LecturesDao;
import com.exercise.ex230211.dto.LecturesDto;

@Controller
@RequestMapping("/lectures")
public class LecturesController {

	@Autowired
	private LecturesDao lecturesDao;
	
	// 강의 등록
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/lectures/add.jsp";
	}
	@PostMapping("/add")
	public String add(@ModelAttribute LecturesDto lecturesDto) {
		lecturesDao.add(lecturesDto);
		return "redirect:addCompleted";
	}
	@GetMapping("/addCompleted")
	public String addCompleted(@ModelAttribute LecturesDto lecturesDto) {
		return "/WEB-INF/views/lectures/addCompleted.jsp";
	}
	
	// 강의 목록, 검색
	@GetMapping("/list")
	public String list(Model model,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "2") int size,
			@RequestParam(required = false, defaultValue = "lecture") String column,
			@RequestParam(required = false, defaultValue = "") String keyword) {
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		// 목록
		if(keyword.equals("")) {
			// 전체 게시글 개수
			int totalCount = lecturesDao.listCount();
			model.addAttribute("totalCount", totalCount);
			// 전체 페이지수
			int totalPage = (totalCount + size - 1) / size;
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("list", lecturesDao.list(page, size));
		}
		// 검색
		else {
			// 전체 게시글 개수
			int totalCount = lecturesDao.listCount(column, keyword);
			model.addAttribute("totalCount", totalCount);
			// 전체 페이지수
			int totalPage = (totalCount + size - 1) / size;
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("keyword", keyword);
			model.addAttribute("list", lecturesDao.list(page, size, column, keyword));
		}
		return "/WEB-INF/views/lectures/list.jsp";
	}
	
}