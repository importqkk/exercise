package day04;

import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
		
		// 사용자에게 금액을 입력받고, 주문 가능한 음료 중 가장 비싼 음료 출력 후 거스름돈 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("금액을 입력해주세요.");
		int money = sc.nextInt();
		
		int change = 0;
		
		int orgJuice = 2500;
		int coffee = 1800;
		int water = 1200;
		
		
		if (money >= orgJuice) {
			System.out.println("오렌지 주스를 구매할 수 있습니다.");
			change = money - orgJuice;
		}
		else if (money >= coffee) {
			System.out.println("커피를 구매할 수 있습니다.");
			change = money - coffee;
		}
		else if (money >= water) {
			System.out.println("물을 구매할 수 있습니다.");
			change = money - water;
		}
		else {
			System.out.println("구매할 수 있는 음료가 없습니다.");
		}
		
		if (change != 0) {
			System.out.println("거스름돈: " + change);			
		}
		sc.close();
	}
}
