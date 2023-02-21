package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.LectureImgDto;

@Repository
public class LectureImgDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<LectureImgDto> mapper = new RowMapper<LectureImgDto>() {
		@Override
		public LectureImgDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return LectureImgDto.builder()
						.lectureNo(rs.getInt("lecture_no"))
						.attachmentNo(rs.getInt("attachment_no"))
					.build();
		}
	};
	
	// 등록
	public void insert(LectureImgDto lectureImgDto) {
		String sql = "insert into lecture_img(lecture_no, attachment_no) values(?, ?)";
		Object[] param = {lectureImgDto.getLectureNo(), lectureImgDto.getAttachmentNo()};
		jdbcTemplate.update(sql, param);
	}
	
	// 이미지 조회
	public LectureImgDto selectOne(int lectureNo) {
		String sql = "select * from lecture_img where lecture_no = ?";
		Object[] param = {lectureNo};
		List<LectureImgDto> list = jdbcTemplate.query(sql, mapper, param);
		return list.isEmpty() ? null : list.get(0);
	}
	
}
