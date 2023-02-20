package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.MembersDto;

@Repository
public class MembersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<MembersDto> mapper = new RowMapper<MembersDto>() {
		@Override
		public MembersDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return MembersDto.builder()
						.memberID(rs.getString("member_id"))
						.memberPW(rs.getString("member_pw"))
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
					.build();
		}
	};
	
	// 회원가입
	public void join(MembersDto membersDto) {
		String sql = "insert into members("
						+ "member_id, member_pw, member_nick, member_email, "
						+ "member_first_name, member_last_name, member_tel, member_birth) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = {membersDto.getMemberID(), membersDto.getMemberPW(), 
						membersDto.getMemberNick(), membersDto.getMemberEmail(), 
						membersDto.getMemberFirstName(), membersDto.getMemberLastName(),
						membersDto.getMemberTel(), membersDto.getMemberBirth()};
		jdbcTemplate.update(sql, param);
	}
	
	// 단일조회
	public MembersDto selectOne(String memberID) {
		String sql = "select * from members where member_id = ?";
		Object[] param = {memberID};
		List<MembersDto> list = jdbcTemplate.query(sql, mapper, param);
		return list.isEmpty() ? null : list.get(0);
	}
	// 최종 로그인 시각 업데이트
	public boolean updateLoginDate(String memberID) {
		String sql = "update members set member_login = sysdate where member_id = ?";
		Object[] param = {memberID};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
}