package ex230126;
import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;

public class Exercise01 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("변경할 수업 번호 > ");
		int no = scan.nextInt();
		scan.nextLine();
		System.out.print("변경할 강의명 > ");
		String lecture = scan.nextLine();
		System.out.print("변경할 강사명 > ");
		String lecturer = scan.nextLine();
		System.out.print("변경할 강의시간 > ");
		int hours = scan.nextInt();
		System.out.print("변경할 수업료 > ");
		int fee = scan.nextInt();
		scan.close();
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		
		String sql = "update lectures set lecture=?, lecturer=?, hours=?, fee=? where no=?";
		Object[] param = {lecture, lecturer, hours, fee, no};
		
		int result = jdbcTemplate.update(sql, param);
		
		if(result > 0) {
			System.out.println("변경이 완료되었습니다.");
		}
		else {			
			System.out.println("존재하지 않는 수업입니다.");
		}
		
	}
}
