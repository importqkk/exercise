package com.exercise.exPage.vo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 좋아요 눌렀는지 안 눌렀는지
@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class BoardLikeVO {

	private boolean result;
	private int count;
	
}
