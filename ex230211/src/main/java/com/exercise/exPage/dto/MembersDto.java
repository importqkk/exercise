package com.exercise.exPage.dto;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class MembersDto {

	private String memberID;
	private String memberPW;
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
	
}
