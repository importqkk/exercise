package ex230131.exercise;
import ex230131.dao.LecturesDao;
import ex230131.dto.LecturesDto;

public class Exercise01 {
	public static void main(String[] args) {
		
		// C: 등록
		String lecture = "테스트 수업";
		String lecturer = "테스트강사";
		int hours = 300;
		int fee = 999999;
		
		LecturesDto dto = new LecturesDto();
		dto.setLecture(lecture);
		dto.setLecturer(lecturer);
		dto.setHours(hours);;
		dto.setFee(fee);
		
		LecturesDao dao = new LecturesDao();
		dao.insert(dto);
		
		System.out.println("등록 완료");
		
	}
}
