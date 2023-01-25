package ex230125;

import java.util.Scanner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Excercise01 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("수업명: ");
		String lecture = scan.nextLine();
		System.out.print("강사명: ");
		String lecturer = scan.nextLine();
		System.out.print("총 수업시간: ");
		int hours = scan.nextInt();
		System.out.print("수업료: ");
		int fee = scan.nextInt();
		scan.close();
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("kh11");
		dataSource.setPassword("kh11");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		JdbcTemplate jdbcTemplalet = new JdbcTemplate();
		jdbcTemplalet.setDataSource(dataSource);
		
		String sql = "insert into lectures(no, lecture, lecturer, hours, fee) values(lectures_seq.nextval, ?, ?, ?, ?)";
		Object[] param = {lecture, lecturer, hours, fee};
		
		jdbcTemplalet.update(sql, param);
		System.out.println("추가 완료");
		
	}
}
