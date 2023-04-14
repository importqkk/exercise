package com.exercise.ex230211;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.exercise.exPage.Ex230211Application;
import com.exercise.exPage.dto.BoardCommentDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class) 
@SpringBootTest
@ContextConfiguration(classes = Ex230211Application.class)
public class Test01 {

	@Autowired
	private SqlSession sql;
	
//	@Test
	public void test1() {
		BoardCommentDto dto = new BoardCommentDto();
		dto.setCommentWriter("testuser02");
		dto.setBoardNo(103);
		dto.setCommentContent("댓글 등록 테스트");
		sql.insert("comment.post", dto);
	}

//	@Test
	public void test2() {
		int boardNo = 103;
		List<BoardCommentDto> list = sql.selectList("comment.list", boardNo);
		for(BoardCommentDto dto : list) {
			log.debug("list = {}", dto);
		}
	}
	
//	@Test
	public void test3() {
		int commentNo = 1;
		BoardCommentDto dto = sql.selectOne("comment.selectOne", commentNo);
		log.debug("dto = {}", dto);
	}
	
//	@Test
	public void test4() {
		BoardCommentDto boardCommentDto = new BoardCommentDto();
		boardCommentDto.setCommentNo(1);
		boardCommentDto.setCommentContent("댓글 수정 테스트");
		sql.update("comment.edit", boardCommentDto);
	}
	
	@Test
	public void test5() {
		int commentNo = 1;
		sql.delete("comment.delete", commentNo);
	}
	
}
