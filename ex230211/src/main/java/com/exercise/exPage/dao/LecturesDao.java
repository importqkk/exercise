/*
 * package com.exercise.exPage.dao; import java.sql.ResultSet; import
 * java.sql.SQLException; import java.util.List; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.jdbc.core.JdbcTemplate; import
 * org.springframework.jdbc.core.RowMapper; import
 * org.springframework.stereotype.Repository; import
 * com.exercise.exPage.dto.LecturesDto; import com.exercise.exPage.vo.PageVO;
 * 
 * @Repository public class LecturesDao {
 * 
 * @Autowired JdbcTemplate jdbcTemplate;
 * 
 * // row mapper public RowMapper<LecturesDto> mapper = new
 * RowMapper<LecturesDto>() {
 * 
 * @Override public LecturesDto mapRow(ResultSet rs, int rowNum) throws
 * SQLException { LecturesDto lecturesDto = new LecturesDto();
 * lecturesDto.setLecturesNo(rs.getInt("no"));
 * lecturesDto.setLecturesLecture(rs.getString("lecture"));
 * lecturesDto.setLecturesLecturer(rs.getString("lecturer"));
 * lecturesDto.setLecturesHours(rs.getInt("hours"));
 * lecturesDto.setLecturesFee(rs.getInt("fee")); return lecturesDto; } };
 * 
 * // 강의 등록 public int sequence() { String sql =
 * "select lectures_seq.nextval from dual"; return
 * jdbcTemplate.queryForObject(sql, int.class); } public void add(LecturesDto
 * lecturesDto) { String sql =
 * "insert into lectures(no, lecture, lecturer, hours, fee) " +
 * "values(?, ?, ?, ?, ?)"; Object[] param = {lecturesDto.getLecturesNo(),
 * lecturesDto.getLecturesLecture(), lecturesDto.getLecturesLecturer(),
 * lecturesDto.getLecturesHours(), lecturesDto.getLecturesFee()};
 * jdbcTemplate.update(sql, param); }
 * 
 * // 강의 목록, 검색 public List<LecturesDto> list(PageVO vo) { if(vo.isSearch()) {
 * String sql = "select * from (" + "select TMP.*, rownum RN from (" +
 * "select * from lectures where instr(#1, ?) > 0 order by #1 asc" + ")TMP" +
 * ") where RN between ? and ?"; sql = sql.replace("#1", vo.getColumn());
 * Object[] param = {vo.getKeyword(), vo.getFirst(), vo.getLast()}; return
 * jdbcTemplate.query(sql, mapper, param); } else { String sql =
 * "select * from (" + "select TMP.*, rownum RN from (" +
 * "select * from lectures order by no desc" + ")TMP" +
 * ") where RN between ? and ?"; Object[] param = {vo.getFirst(), vo.getLast()};
 * return jdbcTemplate.query(sql, mapper, param); } } public int
 * listCount(PageVO vo) { if(vo.isSearch()) { String sql =
 * "select count(*) from lectures where instr(#1, ?) > 0"; sql =
 * sql.replace("#1", vo.getColumn()); Object[] param = {vo.getKeyword()}; return
 * jdbcTemplate.queryForObject(sql, int.class, param); } else { String sql =
 * "select count(*) from lectures"; return jdbcTemplate.queryForObject(sql,
 * int.class); }
 * 
 * }
 * 
 * // 강의 상세보기 public LecturesDto detail(int lecturesNo) { String sql =
 * "select * from lectures where no = ?"; Object[] param = {lecturesNo};
 * List<LecturesDto> list = jdbcTemplate.query(sql, mapper, param); return
 * list.isEmpty() ? null : list.get(0); }
 * 
 * // 강의 정보 수정 public boolean edit(LecturesDto lecturesDto) { String sql =
 * "update lectures set lecture = ?, lecturer = ?, hours = ?, fee = ? where no = ?"
 * ; Object[] param = {lecturesDto.getLecturesLecture(),
 * lecturesDto.getLecturesLecturer(), lecturesDto.getLecturesHours(),
 * lecturesDto.getLecturesFee(), lecturesDto.getLecturesNo()}; return
 * jdbcTemplate.update(sql, param) > 0; }
 * 
 * // 강의 삭제 public boolean delete(int no) { String sql =
 * "delete lectures where no = ?"; Object[] param = {no}; return
 * jdbcTemplate.update(sql, param) > 0; }
 * 
 * }
 */