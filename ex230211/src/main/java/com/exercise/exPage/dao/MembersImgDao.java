package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.MembersImgDto;

@Repository
public class MembersImgDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<MembersImgDto> mapper = new RowMapper<MembersImgDto>() {
		@Override
		public MembersImgDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return MembersImgDto.builder()
						.memberID(rs.getString("member_id"))
						.attachmentNo(rs.getInt("attachment_no"))
					.build();
		}
	};
	
	// 프로필 이미지 등록
	public void insert(MembersImgDto membersImgDto) {
		String sql = "insert into members_img values(?, ?)";
		Object[] param = {membersImgDto.getMemberID(), membersImgDto.getAttachmentNo()};
		jdbcTemplate.update(sql, param);		
	}
	
	// 프로필 이미지 조회
	public MembersImgDto selectOne(String memberID) {
		String sql = "select * from members_img where member_id = ?";
		Object[] param = {memberID};
		List<MembersImgDto> list = jdbcTemplate.query(sql, mapper, param);
		return list.isEmpty() ? null : list.get(0);
	}
	
}
