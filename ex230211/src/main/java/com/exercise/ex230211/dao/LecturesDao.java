package com.exercise.ex230211.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.ex230211.dto.LecturesDto;

@Repository
public class LecturesDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// row mapper
	public RowMapper<LecturesDto> mapper = new RowMapper<LecturesDto>() {
		@Override
		public LecturesDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			LecturesDto lecturesDto = new LecturesDto();
			lecturesDto.setLecturesNo(rs.getInt("no"));
			lecturesDto.setLecturesLecture(rs.getString("lecture"));
			lecturesDto.setLecturesLecturer(rs.getString("lecturer"));
			lecturesDto.setLecturesHours(rs.getInt("hours"));
			lecturesDto.setLecturesFee(rs.getInt("fee"));
			return lecturesDto;
		}
	};
	
	// 강의 등록
	public void add(LecturesDto lecturesDto) {
		String sql = "insert into lectures(no, lecture, lecturer, hours, fee) values(lectures_seq.nextval, ?, ?, ?, ?)";
		Object[] param = {lecturesDto.getLecturesLecture(), lecturesDto.getLecturesLecturer(), 
							lecturesDto.getLecturesHours(), lecturesDto.getLecturesFee()};
		jdbcTemplate.update(sql, param);
	}
	
}
