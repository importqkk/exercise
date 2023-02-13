package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.LecturesDto;

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
		String sql = "insert into lectures(no, lecture, lecturer, hours, fee) "
					+ "values(lectures_seq.nextval, ?, ?, ?, ?)";
		Object[] param = {lecturesDto.getLecturesLecture(), lecturesDto.getLecturesLecturer(), 
							lecturesDto.getLecturesHours(), lecturesDto.getLecturesFee()};
		jdbcTemplate.update(sql, param);
	}
	
	// 강의 목록, 검색
	public List<LecturesDto> list(int page, int size) {
		int end = page * size;
		int begin = end - (size - 1);
		String sql = "select * from ("
							+ "select TMP.*, rownum RN from ("
								+ "select * from lectures order by no asc"
							+ ")TMP"
					+ ") where RN between ? and ?";
		Object[] param = {begin, end};
		return jdbcTemplate.query(sql, mapper, param);
	}
	public List<LecturesDto> list(int page, int size, String column, String keyword) {
		int end = page * size;
		int begin = end - (size - 1);
		String sql = "select * from ("
							+ "select TMP.*, rownum RN from ("
								+ "select * from lectures where instr(#1, ?) > 0 order by #1 asc"
							+ ")TMP"
					+ ") where RN between ? and ?";
		sql = sql.replace("#1", column);
		Object[] param = {keyword, begin, end};
		return jdbcTemplate.query(sql, mapper, param);
	}
	public int listCount() {
		String sql = "select count(*) from lectures";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public int listCount(String column, String keyword) {
		String sql = "select count(*) from lectures where instr(#1, ?) > 0";
		sql = sql.replace("#1", column);
		Object[] param = {keyword};
		return jdbcTemplate.queryForObject(sql, int.class, param);
	}
	
	// 강의 상세보기
	public LecturesDto detail(int lecturesNo) {
		String sql = "select * from lectures where no = ?";
		Object[] param = {lecturesNo};
		List<LecturesDto> list = jdbcTemplate.query(sql, mapper, param);
		return list.isEmpty() ? null : list.get(0);
	}
	
}
