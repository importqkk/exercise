package com.exercise.exPage.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.exPage.dao.BoardDao;
import com.exercise.exPage.dao.BoardLikeDao;
import com.exercise.exPage.dto.BoardLikeDto;
import com.exercise.exPage.vo.BoardLikeVO;

@RestController
@RequestMapping("/rest/board")
public class BoardRestController {

	@Autowired
	private BoardLikeDao boardLikeDao;
	@Autowired
	private BoardDao boardDao;
	
	// 좋아요/좋아요 취소
	@PostMapping("/like")
	public BoardLikeVO like(HttpSession session,
			@ModelAttribute BoardLikeDto boardLikeDto) {
		String memberID = (String)session.getAttribute("memberID");
		boardLikeDto.setMemberID(memberID);
		boolean didLike = boardLikeDao.checkLike(boardLikeDto);
		if(didLike) {
			boardLikeDao.cancelLike(boardLikeDto);
		}
		else {
			boardLikeDao.like(boardLikeDto);
		}
		// 게시글의 좋아요 개수
		int count = boardLikeDao.countLike(boardLikeDto.getBoardNo());
		// 좋아요 개수 업데이트
		boardDao.updateLike(boardLikeDto.getBoardNo(), count);
		return BoardLikeVO.builder()
					.result(!didLike)
					.count(count)
				.build();
	}
	
	// 좋아요 눌렀는지 확인
	@PostMapping("/check")
	public boolean check(HttpSession session,
			@ModelAttribute BoardLikeDto boardLikeDto) {
		String memberID = (String)session.getAttribute("memberID");
		boardLikeDto.setMemberID(memberID);
		return boardLikeDao.checkLike(boardLikeDto);
	}
	
}
