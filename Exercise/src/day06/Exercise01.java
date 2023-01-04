package day06;
import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
		
		// 입력받은 정수의 총합, 짝수의 합, 홀수의 합 각각 출력 (단, 0 입력시 종료)
		
		Scanner sc = new Scanner(System.in);
		
		int total = 0;
		int even = 0;
		int odd = 0;
		
		while (true) {
			System.out.print("숫자를 입력하세요  >> ");
			int num = sc.nextInt();
			
			total += num;
			
			if (num % 2 == 0) {
				even += num;
			}
			else {
				odd += num;
			}
			
			if (num == 0) {
				break;
			}
		}
		
		sc.close();
		
		System.out.println();
		System.out.println("입력하신 숫자의 합은 " + total + "입니다.");
		System.out.println("입력하신 숫자 중 짝수의 합은 " + even + "입니다.");
		System.out.println("입력하신 숫자 중 홀수의 합은 " + odd + "입니다.");
		
	}
}
