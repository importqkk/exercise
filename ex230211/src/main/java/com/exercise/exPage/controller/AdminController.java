package com.exercise.exPage.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.exercise.exPage.dao.MembersDao;
import com.exercise.exPage.dao.MembersImgDao;
import com.exercise.exPage.dto.MembersDto;
import com.exercise.exPage.vo.PageVO;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MembersDao membersDao;
	@Autowired
	private MembersImgDao membersImgDao;
	
	// 관리 메인
	@GetMapping
	public String main() {
		return "/WEB-INF/views/admin/main.jsp";
	}
	
	// 회원 목록
	@GetMapping("/members/list")
	public String membersList(Model model, @ModelAttribute("vo") PageVO vo) {
		int totalMembers = membersDao.listCount(vo);
		vo.setCountTotalData(totalMembers);
		List<MembersDto> list = membersDao.list(vo);
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/members/list.jsp";
	}
	
	// 회원 강제 탈퇴
	@GetMapping("/members/leave")
	public String membersLeave(@RequestParam String memberID,
			@RequestParam int page, RedirectAttributes attr) {
		MembersDto membersDto = membersDao.selectOne(memberID);
		membersDao.leave(memberID);
		membersDao.waiting(membersDto);
		attr.addAttribute("page", page);
		return "redirect:list";
		
	}
	
	// 회원 상세정보
	@GetMapping("/members/detail")
	public String membersDetail(Model model, @RequestParam String memberID) {
		MembersDto membersDto = membersDao.selectOne(memberID);
		model.addAttribute("membersDto", membersDto);
		model.addAttribute("profile", membersImgDao.selectOne(membersDto.getMemberID()));
		return "/WEB-INF/views/admin/members/detail.jsp";
	}
	
	// 회원 정보 수정
	@GetMapping("/members/changeInfo")
	public String membersChangeInfo(Model model,
			@RequestParam String memberID) {
		MembersDto membersDto = membersDao.selectOne(memberID);
		model.addAttribute("membersDto", membersDto);
		return "/WEB-INF/views/admin/members/changeInfo.jsp";
	}
	@PostMapping("/members/changeInfo")
	public String membersChangeInfo(RedirectAttributes attr,
			@ModelAttribute MembersDto membersDto) {
		membersDao.adminChangeInfo(membersDto);
		attr.addAttribute("memberID", membersDto.getMemberID());
		return "redirect:detail";
	}
	
}
