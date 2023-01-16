package day14;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
		
		
		try(Scanner scan = new Scanner(System.in);) {
			
			System.out.print("기준 날짜를 입력해주세요 > ");
			String stdDate = scan.next();
			System.out.print(stdDate + " 으로부터 며칠 전? > ");
			int dDay = scan.nextInt();
			
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			Date time = parser.parse(stdDate);
			
			Calendar c = Calendar.getInstance();
			Format f = new SimpleDateFormat("yyyy-MM-dd EEEE");

			c.setTime(time);			
			
			c.add(Calendar.DATE, -dDay);
			System.out.println(stdDate + " 으로부터 d-" + dDay + "는 " +f.format(c.getTime()));
			
		}
		catch(Exception e) {
			System.out.println("오류가 발생했습니다");
			System.out.println("기준 날짜는 yyyy-mm-dd 형식으로, D-day는 숫자만 입력해주세요.");
		}
		
	}
}
