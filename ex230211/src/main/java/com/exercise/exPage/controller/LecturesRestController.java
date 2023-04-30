package com.exercise.exPage.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/page/{page}")
	public List<LecturesDto> selectList(Model model,
			@PathVariable int page) {
		return lectureRepository.selectList(page);
	}
	
	@PostMapping("/page/{page}")
	public List<LecturesDto> searchList(Model model, 
			@RequestParam("column") String column,
			@RequestParam("keyword") String keyword,
			@PathVariable int page) {
		Map<Object, Object> param = new HashMap<>();
		param.put("column", column);
		param.put("keyword", keyword);
		return lectureRepository.searchList(page, param);
	}
	
}
