package com.exercise.exPage.repository;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exercise.exPage.dto.BoardCommentDto;

@Repository
public class BoardCommentRepositoryImpl implements BoardCommentRepository {

	@Autowired
	private SqlSession sql;
	
	@Override
	public void insert(BoardCommentDto boardCommentDto) {
		sql.insert("comment.post", boardCommentDto);
	}

	@Override
	public List<BoardCommentDto> selectList(int boardNo) {
		return sql.selectList("comment.list", boardNo);
	}

	@Override
	public BoardCommentDto selectOne(int commentNo) {
		return sql.selectOne("comment.selectOne", commentNo);
	}

	@Override
	public boolean update(BoardCommentDto boardCommentDto) {
		return sql.update("comment.edit", boardCommentDto) > 0;
		
	}

	@Override
	public boolean delete(int commentNo) {
		return sql.delete("comment.delete", commentNo) > 0;		
	}
	
}
