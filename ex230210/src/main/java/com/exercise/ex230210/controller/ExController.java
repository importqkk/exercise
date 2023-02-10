package com.exercise.ex230210.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExController {

	@RequestMapping("/table")
	public String table() {
		return "/WEB-INF/views/table.jsp";
	}
	
	@RequestMapping("/el")
	public String el(Model model,
			@RequestParam int num, @RequestParam int square) {
		int result = (int) Math.pow(num, square);
		model.addAttribute("num", num);
		model.addAttribute("square", square);
		model.addAttribute("result", result);
		return "/WEB-INF/views/el.jsp";
	}
	
	@RequestMapping("/jstl01")
	public String jstl01(Model model, @RequestParam int num) {
		model.addAttribute("num", num);
		return "/WEB-INF/views/jstl01.jsp";
	}
	
	@RequestMapping("/jstl02")
	public String jstl02() {
		return "/WEB-INF/views/jstl02.jsp";
	}
	
}
