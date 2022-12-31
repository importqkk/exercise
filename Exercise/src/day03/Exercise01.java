package day03;
import java.lang.*;

public class Exercise01 {
	public static void main(String[] args) {

		// 입장 요금이 15000원인 행사장에서 미취학 아동(한국 나이 7세 이하)는 45% 할인
		// 손님의 나이를 임의로 설정하여 입장료 계산
		
		// input
		int price = 15000;
		int rate = 45;
		
		int age = 7;
		int charge;
		
		// process
		boolean ageTest = age <= 7;
		
		
		if (ageTest) {
			charge = price * (100 - rate) / 100;
		}
		
		else {
			charge = price;
		}
		
		// output
		System.out.println(charge);
	}

}
