package com.exercise.exPage.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class LecturesDto {

	private int lecturesNo;
	private String lecturesLecture;
	private String lecturesLecturer;
	private int lecturesHours;
	private int lecturesFee;
	
}
