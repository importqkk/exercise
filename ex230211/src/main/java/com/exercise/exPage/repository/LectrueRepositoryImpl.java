package com.exercise.exPage.repository;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.LecturesDto;

@Repository
public class LectrueRepositoryImpl implements LectureRepository {

	@Autowired
	private SqlSession sql;

	@Override
	public void insert(LecturesDto lecturesDto) {
		sql.insert("lecture.insert", lecturesDto);		
	}

	@Override
	public List<LecturesDto> selectList(int page) {
		int last = page * 20;
		int first = last - 19;
		Map<String, Object> param = Map.of("first", first, "last", last);
		return sql.selectList("lecture.selectList", param);
	}

	@Override
	public List<LecturesDto> searchList(int page, Map<Object, Object> param) {
		int last = page * 20;
		int first = last - 19;
		param.put("first", first);
		param.put("last", last);
		return sql.selectList("lecture.selectList", param);
	}

	@Override
	public LecturesDto selectOne(int no) {
		return sql.selectOne("lecture.selectOne", no);
	}

}
