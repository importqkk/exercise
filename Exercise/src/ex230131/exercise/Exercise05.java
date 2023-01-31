package ex230131.exercise;
import ex230131.dao.LecturesDao;

public class Exercise05 {
	public static void main(String[] args) {
		
		// D: 삭제
		int no = 21;
		
		LecturesDao dao = new LecturesDao();
		
		boolean result = dao.delete(no);
		
		if(result) {
			System.out.println("삭제 완료");
		}
		else {
			System.out.println("없는 데이터");
		}
		
	}
}
