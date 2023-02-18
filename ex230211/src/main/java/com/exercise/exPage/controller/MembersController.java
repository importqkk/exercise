package com.exercise.exPage.controller;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.exercise.exPage.dao.MembersDao;
import com.exercise.exPage.dto.MembersDto;
import com.exercise.exPage.service.MembersService;

@Controller
@RequestMapping("/members")
public class MembersController {

	@Autowired
	private MembersDao membersDao;
	@Autowired
	private MembersService membersService;
	
	// 회원가입
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/members/join.jsp";		
	}
	@PostMapping("/join")
	public String join(@ModelAttribute MembersDto membersDto, 
			MultipartFile attach) throws IllegalStateException, IOException {
		membersService.join(membersDto, attach);
		return "redirect:joinComplete";
	}
	@GetMapping("/joinComplete") 
	public String joinComplete() {
		return "/WEB-INF/views/members/joinComplete.jsp";
	}
	
}
