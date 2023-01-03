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
		
		switch(score) {
		case 9, 10: System.out.println("A"); break;
		case 8: System.out.println("B"); break;
		case 7: System.out.println("C"); break;
		case 6: System.out.println("D"); break;
		default: System.out.println("F"); break;
		}
		
	}
}
