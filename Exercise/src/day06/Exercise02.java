package day06;

import java.util.Random;

public class Exercise02 {
	public static void main(String[] args) {
		
		// 이벤트 상품 추첨 프로그램
		// 1% - 해외여행 상품권, 5% - 맥북, 10% - 에어팟, 20% - 백화점 상품권, 30% - 카페 기프티콘
		
		Random r = new Random();
		int num = r.nextInt(100);
		String gift;
		
		if (num == 0) {
			gift = "해외여행 상품권";
		}
		else if (num <= 5) {
			gift = "맥북";
		}
		else if (num <= 10) {
			gift = "에어팟";
		}
		else if (num <= 20) {
			gift = "백화점 상품권";
		}
		else if (num <= 30) {
			gift = "카페 기프티콘";
		}
		else {
			gift = "꽝입니다!";
		}
		
		System.out.println("당첨 결과 -> " + gift);
		
	}
}
