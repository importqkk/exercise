package com.exercise.exPage.vo;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class MemberDetailSearchVo {

	private String memberID="", memberNick="", memberEmail="", memberLastName="", 
				memberFirstName="", memberTel="", memberBirthYear="", memberBirthMonth="",
				joinStart="", joinEnd="";
	private Integer minPoint, maxPoint, memberLogin;
	private List<String> memberLevels, orders;
	
	private int page = 1;
	private int size = 5;
	private int countTotalData;
	private int blockSize = 5;
	
	
	public void refreshOrders() {
		if(this.orders == null) return;
		List<String> list = new ArrayList<>();
		for(String str : orders) {
			if(str.length() > 0) list.add(str);
		}
		this.orders = list;
	}
	
	public boolean isMemberIDSearch() {
		return !memberID.equals("");
	}
	public boolean isMemberNickSearch() {
		return !memberNick.equals("");
	}
	public boolean isMemberEmailSearch() {
		return !memberEmail.equals("");
	}
	public boolean isMemberLastNameSearchSearch() {
		return !memberLastName.equals("");
	}
	public boolean isMemberFirstNameSearch() {
		return !memberFirstName.equals("");
	}
	public boolean isMemberTelSearch() {
		return !memberTel.equals("");
	}
	public boolean isMemberBirthYearSearch() {
		return !memberBirthYear.equals("");
	}
	public boolean isMemberBirthMonthSearch() {
		return !memberBirthMonth.equals("");
	}
	public boolean isJoinStartSearch() {
		return !joinStart.equals("");
	}
	public boolean isJoinEndSearch() {
		return !joinEnd.equals("");
	}
	public boolean isMemberLoginSearch() {
		return !(memberLogin==null);
	}
	public boolean isMemberLevelsSearch() {
		return !(memberLevels==null) && memberLevels.size() > 0;
	}
	public boolean isMinPointSearch() {
		return !(minPoint==null);
	}
	public boolean isMaxPointSearch() {
		return !(maxPoint==null);
	}
	public boolean isOrdersSearch() {
		return !(orders==null) && orders.size() > 0;
	}
	
	public String getParam() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("&size=");
		buffer.append(size);
		if(isMemberIDSearch()) {
			buffer.append("&memberID=");
			buffer.append(memberID);
		}
		if(isMemberNickSearch()) {
			buffer.append("&memberNick=");
			buffer.append(memberNick);
		}
		if(isMemberEmailSearch()) {
			buffer.append("&memberEmail=");
			buffer.append(memberEmail);
		}
		if(isMemberTelSearch()) {
			buffer.append("&memberTel=");
			buffer.append(memberTel);
		}
		if(isMemberLastNameSearchSearch()) {
			buffer.append("&memberLastName=");
			buffer.append(memberLastName);
		}
		if(isMemberFirstNameSearch()) {
			buffer.append("&memberFirstName=");
			buffer.append(memberFirstName);
		}
		if(isMemberBirthYearSearch()) {
			buffer.append("&memberBirthYear=");
			buffer.append(memberBirthYear);
		}
		if(isMemberBirthMonthSearch()) {
			buffer.append("&memberBirthMonth=");
			buffer.append(memberBirthMonth);
		}
		if(isJoinStartSearch()) {
			buffer.append("&joinStart=");
			buffer.append(joinStart);
		}
		if(isJoinEndSearch()) {
			buffer.append("&joinEnd=");
			buffer.append(joinEnd);
		}
		if(isMemberLoginSearch()) {
			buffer.append("&memberLogin=");
			buffer.append(memberLogin);
		}
		if(isMemberLevelsSearch()) {
			buffer.append("&memberLevels=");
			for(String str : memberLevels) {				
				buffer.append(str);
				buffer.append("&memberLevels=");
			}
		}
		if(isMinPointSearch()) {
			buffer.append("&minPoint=");
			buffer.append(minPoint);
		}
		if(isMaxPointSearch()) {
			buffer.append("&maxPoint=");
			buffer.append(maxPoint);
		}
		if(isOrdersSearch()) {
			buffer.append("&orders=");
			for(String str : orders) {				
				buffer.append(str);
				buffer.append("&orders=");
			}
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
