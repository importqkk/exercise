package day12;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise01 {
	public static void main(String[] args) {
		
//		민번
//		년도: 00~99
//		월:01~12
//		일:01~31
//		-
//		1~8
		
		Scanner scan = new Scanner(System.in);
		System.out.print("주민등록번호를 입력하세요 >> ");
		String num = scan.next();
		scan.close();
		
		String regex = "^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])[-]*[1-8]\\d{6}$";
		
		if(Pattern.matches(regex, num)) {
			System.out.println("올바른 주민등록번호 입니다.");
		}
		else {
			System.out.println("잘못된 주민등록번호 입니다.");
		}
		
		
	}
}
