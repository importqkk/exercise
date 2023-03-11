package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.BoardStatDto;

@Repository
public class BoardStatDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<BoardStatDto> mapper = new RowMapper<BoardStatDto>() {

		@Override
		public BoardStatDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return BoardStatDto.builder()
						.boardCategory(rs.getString("board_category"))
						.cnt(rs.getInt("cnt"))
					.build();
		}
	};
	
	public List<BoardStatDto> list() {
		String sql = "select * from board_stat";
		return jdbcTemplate.query(sql, mapper);
	}
	
}
