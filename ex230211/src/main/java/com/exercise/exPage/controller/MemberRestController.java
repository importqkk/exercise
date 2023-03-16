package com.exercise.exPage.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.exPage.dao.MembersDao;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/rest/members")
public class MemberRestController {

	@Autowired
	private MembersDao membersDao;
	
	// 아이디 사용 가능 여부(가능: Y)
	@GetMapping("/memberID/{memberID}")
	public String IDCheck(@PathVariable String memberID) {
		return membersDao.selectOne(memberID) == null ? "Y" : "N";
	}
	
	// 닉네임 사용 가능 여부 (가능: Y)
	@GetMapping("/memberNick/{memberNick}")
	public String nickCheck(@PathVariable String memberNick) {
		return membersDao.selectByNick(memberNick) == null ? "Y" : "N";
	}
	
}
