package com.exercise.ex230211.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
