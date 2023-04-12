package com.exercise.exPage.dto;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class BoardCommentDto {

	private int commentNo, boardNo;
	private String commentWriter, commentContent;
	private Date commentTime;
	
}
