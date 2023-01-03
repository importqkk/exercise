package day05;

import java.util.Scanner;

public class Exercise03 {
	public static void main(String[] args) {
		
		// 사용자에게 정수 3개를 입력받아 평균 출력 (단, 소수점 둘째 자리까지 표현)
		
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) {
			System.out.print("정수를 입력하세요 >> ");
			int num = sc.nextInt();
			sum += num;
		}
		
		sc.close();
		
		double avg = (double)sum / 3;
		double avg1 = avg * 100;
		int avg2 = (int) avg1;
		double avg3 = (double)avg2 /100;
		
		System.out.println();
		System.out.println("입력하신 값의 평균은 " + avg3 + "입니다.");
		
	}
}
