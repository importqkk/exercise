package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.MemberStatDto;

@Repository
public class MemberStatDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<MemberStatDto> mapper = new RowMapper<MemberStatDto>() {
		@Override
		public MemberStatDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return MemberStatDto.builder()
						.memberLevel(rs.getString("member_level"))
						.cnt(rs.getInt("cnt"))
						.avgPoint(rs.getFloat("avg_point"))
						.maxPoint(rs.getInt("max_point"))
						.minPoint(rs.getInt("min_point"))
					.build();
		}
	};
	
	public List<MemberStatDto> list() {
		String sql = "select * from member_stat";
		return jdbcTemplate.query(sql, mapper);
	}
	
}
