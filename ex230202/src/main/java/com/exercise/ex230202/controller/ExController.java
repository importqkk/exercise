package com.exercise.ex230202.controller;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExController {

// 1. 정수 a와 b를 입력받아 두 값을 더하는 컨트롤러
	@RequestMapping("/plus")
	@ResponseBody String plus(
			@RequestParam int a,
			@RequestParam int b) {
		int result = a+b;
		return a + " + " + b + "=" + result;
	}
	
// 2. 태어난 해를 입력받아 나이 계산하고 입장료를 판단하는 컨트롤러
	@RequestMapping("/museum")
	@ResponseBody String museum(
			@RequestParam int year) {
		int age = LocalDate.now().getYear() - year + 1;
		int price;
		if(age <= 7 || age >= 65) {
			price = 0;
		}
		else if(age >= 8 && age <= 19) {
			price = 5000;
		}
		else {
			price = 8000;
		}
		return "나이: " + age + "세, 입장료: " + price + "원";
	}
	
// 3. phone 클래스의 변수들을 입력받아 출력하는 컨트롤러
	@RequestMapping("/phone")
	@ResponseBody String phone(@ModelAttribute Phone phone) {
		return "연락처: " + phone;
	}
	
}
