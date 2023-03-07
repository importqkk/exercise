package com.exercise.exPage.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.exercise.exPage.dao.MembersDao;
import com.exercise.exPage.dto.MembersDto;
import com.exercise.exPage.vo.PageVO;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MembersDao membersDao;
	
	@GetMapping
	public String main() {
		return "/WEB-INF/views/admin/main.jsp";
	}
	
	@GetMapping("/members/list")
	public String membersList(Model model, @ModelAttribute("vo") PageVO vo) {
		int totalMembers = membersDao.listCount(vo);
		vo.setCountTotalData(totalMembers);
		List<MembersDto> list = membersDao.list(vo);
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/members/list.jsp";
	}
	
}
