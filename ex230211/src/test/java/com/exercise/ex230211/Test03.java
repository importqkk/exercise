//package com.exercise.ex230211;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import com.exercise.exPage.Ex230211Application;
//import com.exercise.exPage.dto.LecturesDto;
//import com.exercise.exPage.repository.LectureRepository;
//import com.exercise.exPage.vo.LecturesListVO;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RunWith(SpringRunner.class) 
//@SpringBootTest
//@ContextConfiguration(classes = Ex230211Application.class)
//public class Test03 {
//
//	@Autowired
//	private LectureRepository lectureRepository;
//	
////	@Test
//	public void test() {
//		
//		List<LecturesDto> list = lectureRepository.selectList();
//		
//		/*log.debug("dto = {}", list.size());*/
//		
//		for(LecturesDto dto : list) {			
//			log.debug("dto = {}", dto);
//		}
//		
//	}
//	
//	@Test
//	public void test2() {
//		
//		Map<String, String> param = new HashMap<>();
//		param.put("column", "lecturer");
//		param.put("keyword", "테스트");
//		
////		LecturesListVO vo = new LecturesListVO();
////		
////		vo.setColumn("lecturer");
////		vo.setKeyword("테스트");
//		
//		List<LecturesDto> list = lectureRepository.searchList(param);
//		
//		/*log.debug("dto = {}", list.size());*/
//		
//		for(LecturesDto dto : list) {			
//			log.debug("dto = {}", dto);
//		}
//		
//	}
//	
//}
