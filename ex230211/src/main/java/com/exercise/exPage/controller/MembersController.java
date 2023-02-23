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
	
	// 아이디 찾기
	@GetMapping("/findID")
	public String findID() {
		return "/WEB-INF/views/members/findID.jsp";
	}
	@PostMapping("/findID")
	public String findID(@ModelAttribute MembersDto membersDto,
			Model model, RedirectAttributes attr) {
		try {
			String memberID = membersDao.findID(membersDto);
			model.addAttribute("findID", memberID);
			return "/WEB-INF/views/members/findIDComplete.jsp";
		}
		catch(Exception e) {
			attr.addAttribute("mode", "error");
			return "redirect:findID";
		}
	}
	
	// 비밀번호 변경
	@GetMapping("/changePW")
	public String changePW() {
		return "/WEB-INF/views/members/changePW.jsp";
	}
	@PostMapping("/changePW")
	public String changePW(HttpSession session,
			RedirectAttributes attr,
			@RequestParam String currentPW, 
			@RequestParam String newPW) {
		// 아이디검사
		String memberID = (String)session.getAttribute("memberID");
		MembersDto membersDto = membersDao.selectOne(memberID);
		// 비밀번호 검사
		// 비밀번호가 일치하지 않는다면
		if(!currentPW.equals(membersDto.getMemberPW())) {
			attr.addAttribute("mode", "error");
			return "redirect:changePW";
		}
		// 비밀번호가 일치한다면 비밀번호 변경
		
		membersDao.changePW(memberID, newPW);
		return "redirect:changePWComplete";
		
	}
	@GetMapping("/changePWComplete")
	public String changePWComplete() {
		return "/WEB-INF/views/members/changePWComplete.jsp";
	}
	
	// 개인정보 변경
	@GetMapping("/changeInfo")
	public String changeInfo(Model model,
			HttpSession session) {
		// 세션 아이디와 일치하는 회원의 개인정보 불러오기
		String memberID = (String)session.getAttribute("memberID");
		MembersDto membersDto = membersDao.selectOne(memberID);
		model.addAttribute("memberDto", membersDto);
		return "/WEB-INF/views/members/changeInfo.jsp";
	}
	@PostMapping("/changeInfo")
	public String changeInfo(HttpSession session,
			RedirectAttributes attr,
			@ModelAttribute MembersDto membersDto) {
		// 비밀번호 검사를 위해 세션 아이디 불러오기
		String memberID = (String)session.getAttribute("memberID");
		MembersDto findDto = membersDao.selectOne(memberID);
		// 비밀번호 검사
		// 비밀번호가 일치하지 않는다면
		if(!findDto.getMemberPW().equals(membersDto.getMemberPW())) {
			attr.addAttribute("mode", "error");
			return "redirect:changeInfo";
		}
		// 비밀번호가 일치한다면 개인정보 변경
		membersDto.setMemberID(memberID);
		membersDao.changeInfo(membersDto);
		return "redirect:changeInfoComplete";
	}
	@GetMapping("/changeInfoComplete")
	public String changeInfoComplete() {
		return "/WEB-INF/views/members/changeInfoComplete.jsp";
	}
	
}
