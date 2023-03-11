package com.exercise.exPage.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class LectureStatDto {

	private int cnt, maxFee, minFee, maxHours, minHours;
	private float avgFee, avgHours;
	
}
