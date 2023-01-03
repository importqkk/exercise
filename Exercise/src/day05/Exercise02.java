package day05;

import java.util.Scanner;

public class Exercise02 {
	public static void main(String[] args) {
		
		// 사용자에게 점수를 입력받아 성적 출력
		// 90점 이상: A, 80점 이상: B, 70점 이상: C, 60점 이상: D, 60점 미만: F
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해 주세요 >> ");
		int myScore = sc.nextInt();
		sc.close();
		
		int score = myScore / 10;
//		char grade;
//		
//		switch(score) {
//		case 9, 10: grade = 'A'; break;
//		case 8: grade = 'B'; break;
//		case 7: grade = 'C'; break;
//		case 6: grade = 'D'; break;
//		default: grade = 'F'; break;
//		}
		
		char grade = switch(score) {
		case 9, 10 -> 'A';
		case 8 -> 'B';
		case 7 -> 'C';
		case 6 -> 'D';
		default -> 'F';
		};
		
		System.out.println(grade);
		
	}
}
