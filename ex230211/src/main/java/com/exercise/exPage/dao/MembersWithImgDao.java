package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.MembersWithImgDto;

@Repository
public class MembersWithImgDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<MembersWithImgDto> mapper = new RowMapper<MembersWithImgDto>() {
		@Override
		public MembersWithImgDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return MembersWithImgDto.builder()
						.memberID(rs.getString("member_id"))
						.memberNick(rs.getString("member_nick"))
						.memberEmail(rs.getString("member_email"))
						.memberFirstName(rs.getString("member_first_name"))
						.memberLastName(rs.getString("member_last_name"))
						.memberTel(rs.getString("member_tel"))
						.memberBirth(rs.getString("member_birth"))
						.memberPoint(rs.getInt("member_point"))
						.memberLevel(rs.getString("member_level"))
						.memberJoin(rs.getDate("member_join"))
						.memberLogin(rs.getDate("member_login"))
						.attachmentNo(rs.getInt("attachment_no"))
					.build();
		}
	};
	
	
	
}
