package com.exercise.exPage.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String main() {
		return "/WEB-INF/views/main.jsp";
	}
	
}
