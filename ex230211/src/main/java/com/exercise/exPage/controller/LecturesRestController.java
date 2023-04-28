package com.exercise.exPage.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.exPage.dto.LecturesDto;
import com.exercise.exPage.repository.LectureRepository;

@RestController
@CrossOrigin
@RequestMapping("/lectures")
public class LecturesRestController {

	@Autowired
	private LectureRepository lectureRepository;
	
	@PostMapping("/")
	public void insert(@ParameterObject @RequestBody LecturesDto lecturesDto) {
		lectureRepository.insert(lecturesDto);
	}
	
	@GetMapping("/")
	public List<LecturesDto> selectList(Model model) {
		return lectureRepository.selectList();
	}
	
	@GetMapping("/{param}")
	public List<LecturesDto> searchList(Model model, 
			@RequestParam("column") String column,
			@RequestParam("keyword") String keyword) {
		
		Map<String, String> param = new HashMap<>();
		param.put("column", column);
		param.put("keyword", keyword);
		
		return lectureRepository.searchList(param);
	}
	
}
