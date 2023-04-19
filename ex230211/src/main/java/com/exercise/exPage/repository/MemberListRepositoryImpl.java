package com.exercise.exPage.repository;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.exercise.exPage.dto.MembersDto;
import com.exercise.exPage.vo.MemberDetailSearchVo;

@Repository
public class MemberListRepositoryImpl implements MemberListRepository {

	@Autowired
	private SqlSession sql;
	
	@Override
	public int selectOne(MemberDetailSearchVo searchVo) {
		return sql.selectOne("member.listCount", searchVo);
	}
	@Override
	public List<MembersDto> selectList(MemberDetailSearchVo searchVo) {
		return sql.selectList("member.detailSearch", searchVo);
	}
	
}
