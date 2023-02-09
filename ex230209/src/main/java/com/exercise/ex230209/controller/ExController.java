package com.exercise.ex230209.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExController {
	
	@RequestMapping("/img")
	public String img() {
		return "/WEB-INF/views/img.jsp";
	}
	
	@RequestMapping("/aTag")
	public String aTag() {
		return "/WEB-INF/views/aTag.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
}
