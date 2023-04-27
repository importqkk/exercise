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
	public List<LecturesDto> selectList() {
		return sql.selectList("lecture.selectList");
	}

}
