package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.BoardImgDto;

@Repository
public class BoardImgDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<BoardImgDto> mapper = new RowMapper<BoardImgDto>() {
		@Override
		public BoardImgDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return BoardImgDto.builder()
						.boardNo(rs.getInt("board_no"))
						.attachmentNo(rs.getInt("attachment_no"))
					.build();
		}
	};
	
	public void post(BoardImgDto boardImgDto) {
		String sql = "insert into board_img values(?, ?)";
		Object[] param = {boardImgDto.getBoardNo(), boardImgDto.getAttachmentNo()};
		jdbcTemplate.update(sql, param);
	}
	
}
