package ex230128;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Exercise01 {
	public static void main(String[] args) {
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		
		String sql = "select * from lectures order by no asc";
		
		RowMapper<LecturesDto> mapper = new RowMapper<LecturesDto>() {
			@Override
			public LecturesDto mapRow(ResultSet rs, int idx) throws SQLException {
				LecturesDto dto = new LecturesDto();
				dto.setNo(rs.getInt("no"));
				dto.setLecture(rs.getString("lecture"));
				dto.setLecturer(rs.getString("lecturer"));
				dto.setHours(rs.getInt("hours"));
				dto.setFee(rs.getInt("fee"));
				return dto;
			}
		};
		
		List<LecturesDto> list = jdbcTemplate.query(sql, mapper);
		
		for(LecturesDto dto : list) {
			System.out.println(dto);
		}
		
	}
}
