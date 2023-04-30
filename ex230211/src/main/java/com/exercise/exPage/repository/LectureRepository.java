package com.exercise.exPage.repository;
import java.util.List;
import java.util.Map;
import com.exercise.exPage.dto.LecturesDto;

public interface LectureRepository {

	void insert(LecturesDto lecturesDto);
	List<LecturesDto> selectList(int page);
	List<LecturesDto> searchList(int page, Map<Object, Object> param);
	
}
