package ex230130;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ex230129.LecturesDto;

public class Exercise01 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("데이터 번호 > ");
		int no = scan.nextInt();
		scan.close();
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		
		String sql = "select * from lectures where no = ? ";
		Object[] param = {no};
		
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
			System.out.println("없는 데이터입니다.");
		}
		else {
			LecturesDto dto = list.get(0);
			System.out.println(dto);
		}
		
	}
}
