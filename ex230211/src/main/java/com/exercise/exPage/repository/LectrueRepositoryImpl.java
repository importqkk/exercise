package com.exercise.exPage.repository;
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

}
