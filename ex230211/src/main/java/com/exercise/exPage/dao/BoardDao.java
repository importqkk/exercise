package com.exercise.exPage.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.BoardDto;
import com.exercise.exPage.vo.PageVO;

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
	// 조회수 카운트
	public boolean updateView(int boardNo) {
		String sql = "update board set board_view = board_view + 1 where board_no = ?";
		Object[] param = {boardNo};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	// 게시판 목록
	public List<BoardDto> list(PageVO vo) {
		// 검색
		if(vo.isSearch()) {
			String sql = "select * from ("
					+ "select TMP.*, rownum RN from ("
						+ "select * from board where instr(#1, ?) > 0 "
						+ "connect by prior board_no = board_parent "
						+ "start with board_parent is null "
						+ "order siblings by board_group desc, board_no asc"
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
						+ "select * from board "
						+ "connect by prior board_no = board_parent "
						+ "start with board_parent is null "
						+ "order siblings by board_group desc, board_no asc"
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
			String sql = "select count(*) from board where instr(#1, ?) > 0";
			sql = sql.replace("#1", vo.getColumn());
			Object[] param = {vo.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, param);
		}
		// 전체
		else {
			String sql = "select count(*) from board";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
		
	}
	// 공지사항 상단 표시
	public List<BoardDto> noticeList(int start, int end) {
		String sql = "select * from ("
				+ "select TMP.*, rownum RN from ("
					+ "select * from board where board_category = '공지' "
					+ "order by board_no desc"
				+ ")TMP"
			+ ") where RN between ? and ?";
		Object[] param = {start, end};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	// 게시글 수정
	public boolean edit(BoardDto boardDto) {
		String sql = "update board set board_category = ?, board_title = ?, "
						+ "board_content = ?"
					+ " where board_no = ?";
		Object[] param = {boardDto.getBoardCategory(), boardDto.getBoardTitle(), 
						boardDto.getBoardContent(), boardDto.getBoardNo()};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
}
