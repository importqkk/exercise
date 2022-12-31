package day03;
import java.lang.*;

public class Exercise02 {
	public static void main(String[] args) {

		// 손님의 키에 따라 서핑 보드 크기를 다르게 대여해주려고 할 때, 손님의 키를 입력 값으로 받아 대여해줘야 하는 보드의 크기를 출력
		// 150 미만: 1 / 150 이상 ~ 180 미만: 2 / 180 이상: 3
		
		// input
		int size1 = 1;
		int size2 = 2;
		int size3 = 3;
		double height1 = 150;
		double height2 = 180;
		
		double height = 165.5;
		int size;
		
		
		// process
		boolean sizeTest1 = height < height1;
		boolean sizeTest2 = height >= height1 && height < height2;
		
		if (sizeTest1) {
			size = size1;
		}
		else {
			if (sizeTest2) {
				size = size2;
			}
			else {
				size = size3;
			}
		}
		
		
		// output
		System.out.println(size);
		
	}
}
