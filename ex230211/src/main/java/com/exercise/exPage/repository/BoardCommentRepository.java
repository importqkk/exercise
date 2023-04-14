package com.exercise.exPage.repository;
import java.util.List;
import com.exercise.exPage.dto.BoardCommentDto;

public interface BoardCommentRepository {

	void insert(BoardCommentDto boardCommentDto);
	List<BoardCommentDto> selectList(int boardNo);
	BoardCommentDto selectOne(int commentNo);
	boolean update(BoardCommentDto boardCommentDto);
	boolean delete(int commentNo);
	
}
