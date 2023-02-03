package com.exercise.ex230203.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExController {

	@RequestMapping("/hungry")
	@ResponseBody
	public String hungry() {
		return "배고파";
	}
	
}
