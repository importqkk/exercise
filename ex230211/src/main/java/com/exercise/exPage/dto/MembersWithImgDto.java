package com.exercise.exPage.dto;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class MembersWithImgDto {

	private String memberID;
	private String memberNick;
	private String memberEmail;
	private String memberFirstName;
	private String memberLastName;
	private String memberTel;
	private String memberBirth;
	private int memberPoint;
	private String memberLevel;
	private Date memberJoin;
	private Date memberLogin;
	private Integer attachmentNo;
	
	public String getImgURL() {
		if(attachmentNo == null) return "https://via.placeholder.com/150x150";
		else return "/download?attachmentNo="+attachmentNo;
		
	}
	
}
