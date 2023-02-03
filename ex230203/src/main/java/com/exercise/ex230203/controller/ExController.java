package com.exercise.ex230203.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.exercise.ex230203.dao.LecturesDao;
import com.exercise.ex230203.dto.LecturesDto;

@Controller
public class ExController {

	@Autowired
	public LecturesDao lecturesDao;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute LecturesDto lecturesDto) {
		lecturesDao.insert(lecturesDto);
		return "등록 완료";
	}
	
}
