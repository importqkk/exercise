package com.exercise.ex230206.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.exercise.ex230206.dao.LecturesDao;
import com.exercise.ex230206.dto.LecturesDto;

@Controller
public class ExController {

	@Autowired
	public LecturesDao lecturesDao;
	
	// 등록
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute LecturesDto lecturesDto) {
		lecturesDao.insert(lecturesDto);
		return "등록 완료";
	}
	
	// 목록, 검색
	@RequestMapping("/list")
	@ResponseBody
	public String list(
			@RequestParam(required = false, defaultValue = "lecture") String column,
			@RequestParam(required = false, defaultValue = "") String keyword) {
		
		List<LecturesDto> list = lecturesDao.selectAuto(column, keyword);
		
		if(list.isEmpty()) {
			return "검색결과가 없습니다";
		}
		else {
			StringBuffer buffer = new StringBuffer();
			for(LecturesDto lecturesDto : list) {
				buffer.append(lecturesDto.toString());
				buffer.append("<br>");
			}
			return buffer.toString();
		}
	}
	
	// 단일조회
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(
			@RequestParam int no) {
		LecturesDto lecturesDto = lecturesDao.selectOne(no);
		if(lecturesDto == null) {
			return "없는 수업입니다.";
		}
		else {			
			return lecturesDto.toString();
		}
	}
	
	// 수정
	@RequestMapping("/update")
	@ResponseBody
	public String update(@ModelAttribute LecturesDto lecturesDto) {
		boolean update = lecturesDao.update(lecturesDto);
		if(update) {
			return "수정이 완료되었습니다.";
		}
		else {
			return "없는 수업입니다.";
		}
	}
	
}
