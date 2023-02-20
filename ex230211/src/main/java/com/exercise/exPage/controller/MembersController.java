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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.exercise.exPage.dao.MembersDao;
import com.exercise.exPage.dao.MembersImgDao;
import com.exercise.exPage.dto.MembersDto;
import com.exercise.exPage.service.MembersService;

@Controller
@RequestMapping("/members")
public class MembersController {

	@Autowired
	private MembersDao membersDao;
	@Autowired
	private MembersService membersService;
	@Autowired
	private MembersImgDao membersImgDao;
	
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
	
	// 로그인
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/members/login.jsp";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute MembersDto inDto,
			HttpSession session, RedirectAttributes attr) {
		// 로그인 검사
		MembersDto membersDto = membersDao.selectOne(inDto.getMemberID());
		// 없는 아이디라면
		if(membersDto == null) {
			attr.addAttribute("mode", "error");
			return "redirect:login";
		}
		// 비밀번호가 일치하지 않는다면
		if(!inDto.getMemberPW().equals(membersDto.getMemberPW())) {
			attr.addAttribute("mode", "error");
			return "redirect:login";
		}
		// 세션에 아이디, 레벨 정보 추가
		session.setAttribute("memberID", membersDto.getMemberID());
		session.setAttribute("memberLevel", membersDto.getMemberLevel());
		// 최종로그인시각 갱신
		membersDao.updateLoginDate(membersDto.getMemberID());
		// 로그인 성공 -> 메인으로 리다이렉트
		return "redirect:/";		
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("memberID");
		session.removeAttribute("memberLevel");
		return "redirect:/";
	}
	
	// 마이페이지
	@GetMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		String membrerID = (String)session.getAttribute("memberID");
		MembersDto membersDto =	membersDao.selectOne(membrerID);
		model.addAttribute("membersDto", membersDto);
		model.addAttribute("profile", membersImgDao.selectOne(membrerID));
		return "/WEB-INF/views/members/mypage.jsp";
	}
	
}
