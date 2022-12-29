package day02;
import java.lang.*;

public class Exercise01 {
	public static void main(String[] args) {

		// 개당 1300원인 샌드위치가 2+1 행사 중. 8개 사면 얼마일까?

		// input
		int price = 1300;					// 개당 가격
		int quantity = 8;					// 구매 개수
		
		// process
		int free = quantity / 3;			// 8개 중 무료로 가져갈 수 있는 샌드위치 개수
		int charged = quantity - free;		// 8개 중 값을 지불해야 하는 샌드위치 개수
		int totalPrice = price * charged;	// 지불해야 하는 금액
				
		// output
		System.out.println(totalPrice);

	}
}
