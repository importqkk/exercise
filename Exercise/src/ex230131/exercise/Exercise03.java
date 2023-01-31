package ex230131.exercise;
import ex230131.dao.LecturesDao;
import ex230131.dto.LecturesDto;

public class Exercise03 {
	public static void main(String[] args) {
		
		// R: 상세
		int no = 1;
		
		LecturesDao dao = new LecturesDao();
		LecturesDto dto = dao.selectOne(no);
		
		if(dto == null) {
			System.out.println("없는 데이터");
		}
		else {
			System.out.println(dto);
		}
		
	}
}
