package day12;
import java.util.Scanner;

public class Exercise02 {
	public static void main(String[] args) {
		
		String start = "기차표";
		System.out.println("쿵쿵따 시작!");
		System.out.println(start + " 쿵쿵따");
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			String s = start.substring(2);
			System.out.print(">> ");
			
			String answer = scan.next();
			String a = answer.substring(0, 1);
			
			if(answer.length() == 3 && a.equals(s)) {
				System.out.println("쿵쿵따");
				start = answer;
			}
			else {
				System.out.println("GAME OVER!");
				break;
			}
		}
		scan.close();
	}
}