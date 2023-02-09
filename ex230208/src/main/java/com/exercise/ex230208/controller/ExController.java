package com.exercise.ex230208.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExController {

	@RequestMapping("/basic")
	public String basic() {
		return "/WEB-INF/views/basic.jsp";
	}
	
}
