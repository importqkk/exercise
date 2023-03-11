package com.exercise.exPage.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class MemberStatDto {

	private String memberLevel;
	private int cnt, maxPoint, minPoint;
	private float avgPoint;
	
}
