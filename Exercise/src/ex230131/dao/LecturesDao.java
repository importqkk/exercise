package ex230131.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ex230131.dto.LecturesDto;
import ex230131.utils.JdbcUtils;

public class LecturesDao {
	
	// mapper
	private RowMapper<LecturesDto> mapper = new RowMapper<LecturesDto>() {
		@Override
		public LecturesDto mapRow(ResultSet rs, int arg1) throws SQLException {
			LecturesDto dto = new LecturesDto();
			dto.setNo(rs.getInt("no"));
			dto.setLecture(rs.getString("lecture"));
			dto.setLecturer(rs.getString("lecturer"));
			dto.setHours(rs.getInt("hours"));
			dto.setFee(rs.getInt("fee"));
			return dto;
		}
	};
	
	// C: 등록
	public void insert(LecturesDto dto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		String sql = "insert into lectures(no, lecture, lecturer, hours, fee) "
					+ "values(lectures_seq.nextval, ?, ?, ?, ?)";
		Object[] param = {
				dto.getLecture(), dto.getLecturer(), dto.getHours(), dto.getFee()
		};
		jdbcTemplate.update(sql, param);
	}
	
	// R
	// 목록
	public List<LecturesDto> selectList() {
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		String sql = "select * from lectures order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}
	// 검색
	public List<LecturesDto> selectList(String column, String keyword) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		String sql = "select * from lectures where instr(" + column + ", ?) > 0 "
					+ "order by " + column + " asc";
		Object[] param = {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	// auto
	public List<LecturesDto> selectAuto(String column, String keyword) {
		if(column != null && !column.equals("") && keyword != null && !keyword.equals("")) {
			return selectList(column, keyword);
		}
		else {
			return selectList();
		}
	}
	// 단일
	public LecturesDto selectOne(int no) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		String sql = "select * from lectures where no = ?";
		Object[] param = {no};
		List<LecturesDto> list = jdbcTemplate.query(sql, mapper, param);
		return list.isEmpty() ? null: list.get(0);
	}
	
	// U: 수정
	public boolean update(LecturesDto dto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		String sql = "update lectures set "
					+ "lecture=?, lecturer=?, hours=?, fee=? where no=?";
		Object[] param = {
				dto.getLecture(), dto.getLecturer(), dto.getHours(), dto.getFee(), dto.getNo()
		};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	// D: 삭제
	public boolean delete(int no) {
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		String sql = "delete lectures where no = ?";
		Object[] param = {no};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
}
