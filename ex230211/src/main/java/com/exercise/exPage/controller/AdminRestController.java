package com.exercise.exPage.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.exPage.dao.BoardStatDao;
import com.exercise.exPage.dao.MemberStatDao;
import com.exercise.exPage.dto.BoardStatDto;
import com.exercise.exPage.dto.MemberStatDto;

@RestController
@RequestMapping("/rest/admin")
public class AdminRestController {

	@Autowired
	private MemberStatDao memberStatDao;
	@Autowired
	private BoardStatDao boardStatDao;
	
	// 회원 등급별 인원, 포인트 평균/최소값/최대값
	@GetMapping("/memberStat")
	public Map<String, List<Object>> memberStat() {
		List<MemberStatDto> list = memberStatDao.list();
		List<Object> levels = new ArrayList<>();
		List<Object> cnts = new ArrayList<>();
		List<Object> avgs = new ArrayList<>();
		List<Object> maxs = new ArrayList<>();
		List<Object> mins = new ArrayList<>();
		for(MemberStatDto dto : list) {
			levels.add(dto.getMemberLevel());
			cnts.add(dto.getCnt());
			avgs.add(dto.getAvgPoint());
			maxs.add(dto.getMaxPoint());
			mins.add(dto.getMinPoint());
		}
		Map<String, List<Object>> map = Map.of(
					"label", levels, "cnts", cnts, "avgs", avgs, 
					"maxs", maxs, "mins", mins
				);
		return map;
				
	}
	
	// 게시판 카테고리별 글 개수
	@GetMapping("/boardStat")
	public Map<String, List<Object>> boardStat() {
		List<BoardStatDto> list = boardStatDao.list();
		List<Object> categories = new ArrayList<>();
		List<Object> cnts = new ArrayList<>();
		for(BoardStatDto dto : list) {
			categories.add(dto.getBoardCategory());
			cnts.add(dto.getCnt());
		}
		Map<String, List<Object>> map = Map.of(
					"label", categories, "cnts", cnts
				);
		return map;
	}
	
}
