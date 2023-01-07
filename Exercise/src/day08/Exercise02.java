package day08;

import java.util.Random;
import java.util.Scanner;

public class Exercise02 {
	public static void main(String[] args) {
		
		// 사용자에게 배열 크기를 지정받고, 각 칸에 겹치는 숫자 없이 랜덤으로 숫자 할당 후 출력
		// ex. 사용자가 3*3 배열을 생성하면 1부터 9까지의 숫자를 겹치지 않게 랜덤으로 할당
		
		// 배열 크기 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("가로: ");
		int row = scan.nextInt();
		System.out.print("세로: ");
		int col = scan.nextInt();
		scan.close();
		
		// 입력받은 크기대로 배열 생성
		int[][] arr = new int[col][row];
		System.out.println();
		
		// 숫자 랜덤으로 할당
		Random ran = new Random();
		
		for(int i = 1; i <= col*row; i++) {			
			int ranRow = ran.nextInt(row);
			int ranCol = ran.nextInt(col);

			if(arr[ranCol][ranRow] == 0) {
				arr[ranCol][ranRow] = i;
			}
			else {
				i--;
			}
		}
		
		// 출력
		for(int i = 0; i < arr.length; i++) {
			for(int k = 0; k < arr[i].length; k++) {
				System.out.print(arr[i][k]);
				System.out.print("\t");
			}
			System.out.println();
		}
		
		
	}
}
