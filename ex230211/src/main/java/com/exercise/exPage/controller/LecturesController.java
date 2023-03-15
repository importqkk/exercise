package com.exercise.exPage.controller;
import java.io.IOException;
import java.util.List;
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

import com.exercise.exPage.dao.LectureImgDao;
import com.exercise.exPage.dao.LecturesDao;
import com.exercise.exPage.dto.LecturesDto;
import com.exercise.exPage.service.LecturesService;
import com.exercise.exPage.vo.PageVO;

@Controller
@RequestMapping("/lectures")
public class LecturesController {

	@Autowired
	private LecturesDao lecturesDao;
	@Autowired
	private LecturesService lecturesService;
	@Autowired
	private LectureImgDao lectureImgDao;
	
	// 강의 등록
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/lectures/add.jsp";
	}
	@PostMapping("/add")
	public String add(@ModelAttribute LecturesDto lecturesDto,
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		lecturesService.add(lecturesDto, attach);
		return "redirect:addCompleted";
	}
	@GetMapping("/addCompleted")
	public String addCompleted(@ModelAttribute LecturesDto lecturesDto) {
		return "redirect:list";
	}
	
	// 강의 목록, 검색
	@GetMapping("/list")
	public String list(Model model,
			@ModelAttribute("vo") PageVO vo) {
		int countTotalData = lecturesDao.listCount(vo);
		vo.setCountTotalData(countTotalData);
		List<LecturesDto> list = lecturesDao.list(vo);
		model.addAttribute("list", list);
		return "/WEB-INF/views/lectures/list.jsp";
	}
	
	// 강의 상세보기
	@GetMapping("/detail")
	public String detail(Model model,
			@RequestParam int lecturesNo) {
		model.addAttribute("lecturesDto", lecturesDao.detail(lecturesNo));
		model.addAttribute("image", lectureImgDao.selectOne(lecturesNo));
		return "/WEB-INF/views/lectures/detail.jsp";
	}
	
	// 강의 정보 수정
	@GetMapping("/edit")
	public String edit(Model model, int no) {
		model.addAttribute("lecturesDto", lecturesDao.detail(no));
		return "/WEB-INF/views/lectures/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(RedirectAttributes attr,
			@ModelAttribute LecturesDto lecturesDto) {
		lecturesDao.edit(lecturesDto);
		attr.addAttribute("lecturesNo", lecturesDto.getLecturesNo());
		return "redirect:detail";
	}
	
	// 강의 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int no) {
		lecturesDao.delete(no);
		return "redirect:list";
	}
	
}
