package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.BoardDto;

@Repository
public class BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// RowMapper
	private RowMapper<BoardDto> mapper = new RowMapper<BoardDto>() {
		@Override
		public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return BoardDto.builder()
						.boardNo(rs.getInt("board_no"))
						.boardCategory(rs.getString("board_category"))
						.boardTitle(rs.getString("board_title"))
						.boardContent(rs.getString("board_content"))
						.boardWriter(rs.getString("board_writer"))
						.boardDate(rs.getDate("board_date"))
						.boardLike(rs.getInt("board_like"))
						.boardComment(rs.getInt("board_comment"))
						.boardView(rs.getInt("board_view"))
						.boardReport(rs.getInt("board_report"))
						.boardGroup(rs.getInt("board_group"))
						.boardParent(rs.getInt("board_parent"))
						.boardDepth(rs.getInt("board_depth"))
					.build();
		}
	};
	
	// 게시글 등록
	public int sequence() {
		String sql = "select board_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void post(BoardDto boardDto) {
		String sql = "insert into board(board_no, board_category, board_title, board_content, board_writer, "
						+ "board_group, board_parent, board_depth) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = {boardDto.getBoardNo(), boardDto.getBoardCategory(), boardDto.getBoardTitle(),
						boardDto.getBoardContent(), boardDto.getBoardWriter(),
						boardDto.getBoardGroup(), boardDto.getBoardParent(), boardDto.getBoardDepth()};
		jdbcTemplate.update(sql, param);
	}
	
	// 게시글 상세
	public BoardDto detail(int boardNo) {
		String sql = "select * from board where board_no = ?";
		Object[] param = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, mapper, param);
		return list.isEmpty() ? null : list.get(0);
	}
	
}
