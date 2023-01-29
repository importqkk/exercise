package ex230129;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Exercise01 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("카테고리: ");
		String column = scan.next();
		scan.nextLine();
		System.out.print("검색어: ");
		String keyword = scan.nextLine();
		scan.close();
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		
		String sql = "select * from lectures where instr(" + column + ", ?) > 0 order by " + column + " asc";
		Object[] param = {keyword};
		
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
		
		List<LecturesDto> list = jdbcTemplate.query(sql, mapper, param);
		if(list.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		}
		else {
			System.out.println("검색 결과: " + list.size() + "건");
			for(LecturesDto dto : list) {
				System.out.println(dto);
			}
		}
		
		
	}
}
