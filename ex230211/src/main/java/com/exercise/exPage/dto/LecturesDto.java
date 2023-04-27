package com.exercise.exPage.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class LecturesDto {

	private int no;
	private String lecture;
	private String lecturer;
	private int hours;
	private int fee;
	
}
