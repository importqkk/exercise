package ex230131.exercise;
import ex230131.dao.LecturesDao;
import ex230131.dto.LecturesDto;

public class Exercise04 {
	public static void main(String[] args) {
		
		// U: 수정
		LecturesDto dto = new LecturesDto();
		dto.setNo(21);
		dto.setLecture("수정된 과정");
		dto.setLecturer("강사수정");
		dto.setHours(600);
		dto.setFee(0);
		
		LecturesDao dao = new LecturesDao();
		
		boolean result = dao.update(dto);
		
		if(result) {
			System.out.println("변경 완료");
		}
		else {
			System.out.println("데이터 없음");
		}
		
	}
}
