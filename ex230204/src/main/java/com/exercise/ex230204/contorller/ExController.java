package com.exercise.ex230204.contorller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.exercise.ex230204.dao.LecturesDao;
import com.exercise.ex230204.dto.LecturesDto;

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
	
}
