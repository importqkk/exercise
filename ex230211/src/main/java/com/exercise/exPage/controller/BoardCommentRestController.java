package com.exercise.exPage.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.exPage.dao.BoardDao;
import com.exercise.exPage.dto.BoardCommentDto;
import com.exercise.exPage.repository.BoardCommentRepository;

@RestController
@RequestMapping("/rest/comment")
public class BoardCommentRestController {

	@Autowired
	private BoardCommentRepository commentRepo;
	@Autowired
	private BoardDao boardDao;
	
	// 목록
	@GetMapping("/{boardNo}")
	public List<BoardCommentDto> list(@PathVariable int boardNo) {
		return commentRepo.selectList(boardNo);
	}
	
	// 등록
	@PostMapping("/")
	public void insert(@ModelAttribute BoardCommentDto boardCommentDto) {
		commentRepo.insert(boardCommentDto);
		boardDao.updateCommentCount(boardCommentDto.getBoardNo());
	}
	
	// 수정
	@PatchMapping("/")
	public void edit(@ModelAttribute BoardCommentDto boardCommentDto) {
		commentRepo.update(boardCommentDto);
	}
	
	// 삭제
	@DeleteMapping("/{commentNo}")
	public void delete(@PathVariable int commentNo) {
		BoardCommentDto boardCommentDto = commentRepo.selectOne(commentNo);
		commentRepo.delete(commentNo);
		boardDao.updateCommentCount(boardCommentDto.getBoardNo());
	}
	
}
