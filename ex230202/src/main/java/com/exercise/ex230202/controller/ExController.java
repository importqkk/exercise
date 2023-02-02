package com.exercise.ex230202.controller;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExController {
	
	@RequestMapping("/plus")
	@ResponseBody String plus(
			@RequestParam int a,
			@RequestParam int b) {
		int result = a+b;
		return a + " + " + b + "=" + result;
	}
	
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
	
	@RequestMapping("/phone")
	@ResponseBody String phone(@ModelAttribute Phone phone) {
		return "연락처: " + phone;
	}
	
}
