package ex230131.exercise;
import java.util.List;
import ex230131.dao.LecturesDao;
import ex230131.dto.LecturesDto;

public class Exercise02 {
	public static void main(String[] args) {
		
		// R: 목록, 검색
		String column = "lecture";
		String keyword = "신문";
		
		LecturesDao dao = new LecturesDao();
		
		List<LecturesDto> list = dao.selectAuto(column, keyword);
		
		if(list.isEmpty()) {
			System.out.println("결과 없음");
		}
		else {
			System.out.println("검색 결과: " + list.size());
			for(LecturesDto dto : list) {
				System.out.println(dto);
			}
		}
		
	}
}
