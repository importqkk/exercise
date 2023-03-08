package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.MembersDto;
import com.exercise.exPage.vo.PageVO;

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
	
	// 아이디 찾기
	public String findID(MembersDto membersDto) {
		String sql = "select member_id from members where member_nick=? and member_email=?";
		Object[] param = {membersDto.getMemberNick(), membersDto.getMemberEmail()};
		return jdbcTemplate.queryForObject(sql, String.class, param);
	}
	
	// 비밀번호 변경
	public boolean changePW(String memberID, String memberPW) {
		String sql = "update members set member_pw = ? where member_id = ?";
		Object[] param = {memberPW, memberID};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	// 개인정보 변경
	public boolean changeInfo(MembersDto membersDto) {
		String sql = "update members set member_nick=?, member_email=?, member_first_name=?, "
					+ "member_last_name=?, member_tel=?, member_birth=? where member_id=?";
		Object[] param = {membersDto.getMemberNick(), membersDto.getMemberEmail(),
						membersDto.getMemberFirstName(), membersDto.getMemberLastName(),
						membersDto.getMemberTel(), membersDto.getMemberBirth(),
						membersDto.getMemberID()};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	// 회원 탈퇴
	public boolean leave(String memberID) {
		String sql = "delete members where member_id = ?";
		Object[] param = {memberID};
		return jdbcTemplate.update(sql, param) > 0;
	}
	// 탈퇴한 회원 탈퇴 대기 명단으로 옮기기
	public void waiting(MembersDto membersDto) {
		String sql = "insert into waiting("
						+ "member_id, member_pw, member_nick, member_email, "
						+ "member_first_name, member_last_name, member_tel, member_birth, "
						+ "member_point, member_level, member_join, member_login) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = {membersDto.getMemberID(), membersDto.getMemberPW(), 
						membersDto.getMemberNick(), membersDto.getMemberEmail(), 
						membersDto.getMemberFirstName(), membersDto.getMemberLastName(),
						membersDto.getMemberTel(), membersDto.getMemberBirth(),
						membersDto.getMemberPoint(), membersDto.getMemberLevel(),
						membersDto.getMemberJoin(), membersDto.getMemberLogin()};
		jdbcTemplate.update(sql, param);
	}
	
	// 관리자 페이지용 회원 목록
	public List<MembersDto> list(PageVO vo) {
		// 검색
		if(vo.isSearch()) {
			String sql = "select * from ("
							+ "select TMP.*, rownum RN from ("
								+ "select * from members where instr(#1, ?) > 0 "
								+ "order by member_join desc"
							+ ")TMP"
						+ ") where RN between ? and ?";
			sql = sql.replace("#1", vo.getColumn());
			Object[] param = {vo.getKeyword(), vo.getFirst(), vo.getLast()};
			return jdbcTemplate.query(sql, mapper, param);
		}
		// 전체목록
		else {
			String sql = "select * from ("
							+ "select TMP.*, rownum RN from ("
								+ "select * from members order by member_join desc"
							+ ")TMP"
						+ ") where RN between ? and ?";
			Object[] param = {vo.getFirst(), vo.getLast()};
			return jdbcTemplate.query(sql, mapper, param);
		}
	}
	// 데이터 개수
	public int listCount(PageVO vo) {
		// 검색
		if(vo.isSearch()) {
			String sql = "select count(*) from members where instr(#1, ?) > 0";
			sql = sql.replace("#1", vo.getColumn());
			Object[] param = {vo.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, param);
		}
		// 전체
		else {
			String sql = "select count(*) from members";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
		
	}
	
	// 관리자용 회원정보 변경
	public boolean adminChangeInfo(MembersDto membersDto) {
		String sql = "update members set member_nick=?, member_email=?, member_first_name=?, "
					+ "member_last_name=?, member_tel=?, member_birth=?, member_point=?, "
					+ "member_level=? where member_id=?";
		Object[] param = {membersDto.getMemberNick(), membersDto.getMemberEmail(), 
						membersDto.getMemberFirstName(), membersDto.getMemberLastName(),
						membersDto.getMemberTel(), membersDto.getMemberBirth(),
						membersDto.getMemberPoint(), membersDto.getMemberLevel(),
						membersDto.getMemberID()};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
}
