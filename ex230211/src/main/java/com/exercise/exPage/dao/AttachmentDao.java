package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.AttachmentDto;

@Repository
public class AttachmentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<AttachmentDto> mapper = new RowMapper<AttachmentDto>() {
		@Override
		public AttachmentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return AttachmentDto.builder()
						.attachmentNo(rs.getInt("attachment_no"))
						.attachmentName(rs.getString("attachmentName"))
						.attachmentType(rs.getString("attachmentType"))
						.attachmentSize(rs.getLong("attachment_size"))
					.build();
		}
	};
	
	// 파일 업로드
	public int sequence() {
		String sql = "select attachment_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(AttachmentDto attachmentDto) {
		String sql = "insert into attachment values(?, ?, ?, ?)";
		Object[] param = {attachmentDto.getAttachmentNo(), attachmentDto.getAttachmentName(),
							attachmentDto.getAttachmentType(), attachmentDto.getAttachmentSize()};
		jdbcTemplate.update(sql, param);
	}
	
}
