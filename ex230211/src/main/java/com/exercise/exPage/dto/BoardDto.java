package com.exercise.exPage.dto;
import java.sql.Date;
import java.text.SimpleDateFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class BoardDto {

	private int boardNo;
	private String boardCategory;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Date boardDate;
	private int boardLike;
	private int boardComment;
	private int boardView;
	private int boardReport;
	private int boardGroup;
	private Integer boardParent;
	private int boardDepth;
	
	// 날짜 형식 반환하는 가상의 getter
	public String getboardDateAuto() {
		// 현재시각
		java.util.Date thisDate = new java.util.Date();
		// 작성시각
		java.util.Date wirteDate = new java.util.Date(boardDate.getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String thisDateStr = format.format(thisDate);
		String writeDateStr = format.format(wirteDate);
		// 현재 날짜 == 작성날짜인 경우 시간만 표시
		if(thisDateStr.substring(0, 10).equals(writeDateStr.substring(0, 10))) {
			return writeDateStr.substring(11);
		}
		// 현재 날짜와 작성날짜가 다른 경우 날짜만 표시
		else {
			return writeDateStr.substring(0, 10);
		}
	}
	
	// 새글인지 판단
	public boolean isNew() {
		return boardParent == null;
	}
	
	// 답글인지 판단
	public boolean isAnswer() {
		return !isNew();
	}
	
}
