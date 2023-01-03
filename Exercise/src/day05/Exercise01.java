package day05;

import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
		
		// 사용자에게 1차 시험, 2차 시험, 3차 시험 점수를 입력받아 총점과 평균을 구하고, 합불 판단
		// 합격 기준: 각 40점 이상, 평균 60점 이상
		// 단, 소수점은 둘째자리까지 표시
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1차 시험 점수를 입력해 주세요. >> ");
		int test1 = sc.nextInt();
		System.out.print("2차 시험 점수를 입력해 주세요. >> ");
		int test2 = sc.nextInt();
		System.err.print("3차 시험 점수를 입력해 주세요. >> ");
		int test3 = sc.nextInt();
		sc.close();
		
		System.out.println();
		
		int sum = test1 + test2 + test3;
		double avg = (double)sum / 3;
		
		double avg1 = avg * 100;
		int avg2 = (int)avg1;
		double avg3 = (double)avg2 / 100;
		
		boolean pass = test1 >= 40 && test2 >= 40 && test3 >= 40 && avg >= 60;
		
		System.out.println("총점: " + sum + "점, 평균: " + avg3 + "점");
		
		if (pass) {
			System.out.println("합격입니다.");
		}
		else {
			System.out.println("불합격입니다.");
		}
	}
}
