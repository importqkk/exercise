package com.exercise.exPage.repository;
import java.util.List;
import com.exercise.exPage.dto.MembersDto;
import com.exercise.exPage.vo.MemberDetailSearchVo;

public interface MemberListRepository {

	int selectOne(MemberDetailSearchVo searchVo);
	List<MembersDto> selectList(MemberDetailSearchVo searchVo);
	
}
