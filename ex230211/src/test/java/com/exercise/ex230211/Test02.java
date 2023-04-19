package com.exercise.ex230211;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.exercise.exPage.Ex230211Application;
import com.exercise.exPage.dto.MembersDto;
import com.exercise.exPage.vo.PageVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class) 
@SpringBootTest
@ContextConfiguration(classes = Ex230211Application.class)
public class Test02 {

	@Autowired
	private SqlSession sql;
	
	@Test
	public void test1() {
		
		PageVO vo = new PageVO();
		Map<String, Object> param = new HashMap<>();
		
		param.put("memberID", "test");
		/*param.put("memberNick", "유저");
		param.put("memberBirthMonth", 04);*/
		
		int count = sql.selectOne("member.listCount", param);
		vo.setCountTotalData(count);
		
		param.put("countTotalData", count);
		
		int first = vo.getFirst();
		int last = vo.getLast();
		
		param.put("first", first);
		param.put("last", last);
		
		List<MembersDto> list = sql.selectList("member.detailSearch", param);
		
		log.debug("count = {}", count);
		log.debug("first = {}", first);
		log.debug("last = {}", last);
		
		for(MembersDto dto : list) {			
			log.debug("dto = {}", dto);
		}
		
	}
	
}
