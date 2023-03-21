package com.exercise.exPage.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.BoardLikeDto;

@Repository
public class BoardLikeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 좋아요
	public void like(BoardLikeDto boardLikeDto) {
		String sql = "insert into board_like values(?, ?)";
		Object[] param = {boardLikeDto.getMemberID(), boardLikeDto.getBoardNo()};
		jdbcTemplate.update(sql, param);
	}
	
	// 좋아요 취소
	public void cancelLike(BoardLikeDto boardLikeDto) {
		String sql = "delete board_like where board_no=? and member_id=?";
		Object[] param = {boardLikeDto.getBoardNo(), boardLikeDto.getMemberID()};
		jdbcTemplate.update(sql, param);
	}
	
	// 좋아요 눌렀는지 확인
	public boolean checkLike(BoardLikeDto boardLikeDto) {
		String sql = "select count(*) from board_like where board_no=? and member_id=?";
		Object[] param = {boardLikeDto.getBoardNo(), boardLikeDto.getMemberID()};
		int count = jdbcTemplate.queryForObject(sql, int.class, param);
		return count == 1; 
	}
	
	// (게시글에) 좋아요 개수 확인
	public int countLike(int boardNo) {
		String sql = "select count(*) board_like where board_no=?";
		Object[] param = {boardNo};
		return jdbcTemplate.queryForObject(sql, int.class, param);
	}
	
}
