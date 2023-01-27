package ex230127;
import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test01 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 데이테 번호 > ");
		int no = scan.nextInt();
		scan.close();
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getjdJdbcTemplate();
		
		String sql = "delete lectures where no=?";
		Object[] param = {no};
		
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			System.out.println("삭제되었습니다.");
		}
		else {
			System.out.println("존재하지 않는 수업입니다.");
		}
		
	}
}
