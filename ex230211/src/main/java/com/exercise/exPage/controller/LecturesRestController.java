package com.exercise.exPage.controller;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
