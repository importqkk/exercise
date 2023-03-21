package com.exercise.exPage.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class BoardLikeDto {

	private String memberID;
	private int boardNo;
	
}
