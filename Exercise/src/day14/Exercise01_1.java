package day14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exercise01_1 {
	public static void main(String[] args) {

		try(Scanner scan = new Scanner(System.in);) {
			
			System.out.print("며칠부터? (yyyy-mm-dd) > ");
			String date1 = scan.next();
			System.out.print("며칠까지? (yyyy-mm-dd) > ");
			String date2 = scan.next();
			
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			Date start = parser.parse(date1);
			Date finish = parser.parse(date2);
			
			long dDay = (finish.getTime() - start.getTime()) / 1000 / 60 / 60 / 24;
			
			System.out.println();
			System.out.print(date1 + " 부터 " + date2 + " 까지는 ");
			System.out.println("d-" + dDay);
			
		}
		catch(Exception e) {
			System.out.println();
			System.out.println("오류가 발생했습니다.");
			System.out.println("날짜는 yyyy-mm-dd 형식으로 입력해주세요.");
		}
		
	}
}
