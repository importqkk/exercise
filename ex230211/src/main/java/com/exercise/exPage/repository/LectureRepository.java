package com.exercise.exPage.repository;
import java.util.List;
import com.exercise.exPage.dto.LecturesDto;

public interface LectureRepository {

	void insert(LecturesDto lecturesDto);
	List<LecturesDto> selectList();
	
}
