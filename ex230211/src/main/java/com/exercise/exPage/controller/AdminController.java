package com.exercise.exPage.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.exercise.exPage.component.RandomStringComponent;
import com.exercise.exPage.dao.BoardStatDao;
import com.exercise.exPage.dao.LectureStatDao;
import com.exercise.exPage.dao.MemberStatDao;
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
	@Autowired
	private RandomStringComponent ranStringComponent;
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private MemberStatDao memberStatDao;
	@Autowired
	private LectureStatDao lectureStatDao;
	@Autowired
	private BoardStatDao boardStatDao;
	
	// 관리 메인 (회원, 강의, 게시판 통계)
	@GetMapping
	public String main(Model model) {
		model.addAttribute("memberList", memberStatDao.list());
		model.addAttribute("lectureList", lectureStatDao.list());
		model.addAttribute("boardList", boardStatDao.list());
		return "/WEB-INF/views/admin/main.jsp";
	}
	
	// 회원 목록
	@GetMapping("/members/list")
	public String membersList(Model model, @ModelAttribute("vo") PageVO vo) {
		int totalMembers = membersDao.listCount(vo);
		vo.setCountTotalData(totalMembers);
		List<MembersDto> joinDescList = membersDao.joinDescList(vo);
		List<MembersDto> joinAscList = membersDao.joinAscList(vo);
		List<MembersDto> idList = membersDao.idList(vo);
		List<MembersDto> nickList = membersDao.nickList(vo);
		List<MembersDto> levelList = membersDao.levelList(vo);
		model.addAttribute("joinDescList", joinDescList);
		model.addAttribute("joinAscList", joinAscList);
		model.addAttribute("idList", idList);
		model.addAttribute("nickList", nickList);
		model.addAttribute("levelList", levelList);
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
	
	// 회원 임시비밀번호 발급
	@GetMapping("/members/tempPW")
	public String membersTempPW(@ModelAttribute MembersDto membersDto) {
		// 회원정보 조회
		String memberID = membersDto.getMemberID();
		membersDto = membersDao.selectOne(memberID);
		// 임시비밀번호 생성
		String tempPW = ranStringComponent.generateString();
		// 생성된 임시비밀번호로 비번 변경
		membersDao.changePW(memberID, tempPW);
		// 메일 작성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(membersDto.getMemberEmail());
		message.setSubject("[개발하는 쿼카] 임시 비밀번호 발급");
		message.setText("회원님의 임시 비밀번호는 "+tempPW+" 입니다. 로그인 후 비밀번호를 반드시 변경해주시길 바랍니다.");
		// 메일 발송
		sender.send(message);
		return "redirect:tempPWComplete";
	}
	@GetMapping("/members/tempPWComplete")
	public String membersTempPWComplete() {
		return "/WEB-INF/views/admin/members/tempPW.jsp";
	}
	
}
