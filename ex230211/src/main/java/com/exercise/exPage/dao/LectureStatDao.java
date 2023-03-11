package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.LectureStatDto;

@Repository
public class LectureStatDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<LectureStatDto> mapper = new RowMapper<LectureStatDto>() {
		@Override
		public LectureStatDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return LectureStatDto.builder()
						.cnt(rs.getInt("cnt"))
						.avgFee(rs.getFloat("avg_fee"))
						.maxFee(rs.getInt("max_fee"))
						.minFee(rs.getInt("min_fee"))
						.avgHours(rs.getFloat("avg_hours"))
						.maxHours(rs.getInt("max_hours"))
						.minHours(rs.getInt("min_hours"))
					.build();
		}
	};
	
	public List<LectureStatDto> list() {
		String sql = "select * from lecture_stat";
		return jdbcTemplate.query(sql, mapper);
	}
	
}
