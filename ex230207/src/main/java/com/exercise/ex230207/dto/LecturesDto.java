package com.exercise.ex230207.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class LecturesDto {

	private int no;
	private String lecture;
	private String lecturer;
	private int hours;
	private int fee;
	
}
