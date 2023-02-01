package com.exercise.ex230201.controller;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExController {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/randomNums")
	@ResponseBody
	public String randomNums() {
		Random ran = new Random();
		Set<Integer> nums = new TreeSet<>();
		while(nums.size() < 10) {
			int num = ran.nextInt(50)+1;
			nums.add(num);
		}
		return "랜덤 번호 뽑기 결과: " + nums;
	}
	
}
