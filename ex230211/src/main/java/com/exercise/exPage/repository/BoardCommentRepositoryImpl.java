package com.exercise.exPage.repository;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.exercise.exPage.dto.BoardCommentDto;

public class BoardCommentRepositoryImpl implements BoardCommentRepository {

	@Autowired
	private SqlSession sql;
	
	@Override
	public void insert(BoardCommentDto boardCommentDto) {
		sql.insert("comment.post", boardCommentDto);
	}

	@Override
	public List<BoardCommentDto> selectList() {
		return sql.selectList("comment.list");
	}
	
}
