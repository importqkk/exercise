package com.exercise.exPage.vo;
import java.util.List;
import lombok.Data;

@Data
public class MemberDetailSearchVo {

	private String memberID, memberNick, memberEmail, memberLastName, 
				memberFirstName, memberTel, memberBirthYear, memberBirthMonth,
				joinStart, joinEnd, memberLogin;
	private Integer minPoint, maxPoint, first, last;
	private List<String> memberLevels;
	
	
	private String column = "memberID";
	private String keyword ="";
	private int page = 1;
	private int size = 10;
	private int countTotalData;
	private int blockSize = 5;
	
	public boolean isSearch() {
		return !keyword.equals("");
	}
	public boolean isList() {
		return !isSearch();
	}
	
	public String getParam() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("&size=");
		buffer.append(size);
		if(isSearch()) {
			buffer.append("&column=");
			buffer.append(column);
			buffer.append("&keyword=");
			buffer.append(keyword);
		}
		return buffer.toString();
	}
	
	// 한 페이지에 표시되는 마지막 데이터 번호
	public int getLast() {
		return Math.min(page * size, countTotalData);
	}
	// 한 페이지에 표시되는 첫번째 데이터 번호
	public int getFirst() {
		return page * size - (size - 1);
	}
	// 전체 페이지수
	public int getCountTotalPage() {
		return (countTotalData + size - 1) / size;
	}
	// 한 화면에 표시되는 첫번째 페이지블록 번호
	public int getFirstBlock() {
		return (page - 1) / blockSize * blockSize + 1;
	}
	// 한 화면에 표시되는 마지막 페이지블록 번호
	public int getLastBlock() {
		int value = (page - 1) / blockSize * blockSize + blockSize;
		return Math.min(value, getCountTotalPage());
	}
	// 첫 페이지인지
	public boolean isFirstPage() {
		return page == 1;
	}
	// 마지막 페이지인지
	public boolean isLastPage() {
		return page == (countTotalData + size - 1) / size;
	}
	// [이전] 버튼이 눌리는 조건: 첫번째 페이지블록이 1보다 크면
	public boolean isPrev() {
		return getFirstBlock() > 1;
	}
	// [다음] 버튼이 눌리는 조건: 마지막 페이지블록이 마지막페이지(countTotalPage)보다 작으면
	public boolean isNext() {
		return getLastBlock() < getCountTotalPage();
	}
	// [이전]을 누르면 나올 페이지번호
	public int getPrevPage() {
		return getFirstBlock() - 1;
	}
	// [다음]을 누르면 나올 페이지번호
	public int getNextPage() {
		return getLastBlock() + 1;
	}
}
