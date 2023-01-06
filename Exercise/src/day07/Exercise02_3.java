package day07;

public class Exercise02_3 {
	public static void main(String[] args) {
		
		// 버블정렬
		
		// 데이터: 3, 1, 5, 4, 7, 2, 6
		
		// 데이터 생성
		int[] data = new int[] {3, 5, 1, 4, 7, 2, 6};
		
		
		// 처리
		for(int k = data.length - 1; k >= 0; k--) {
			for(int i = k; i < data.length - 1; i++) {
				if(data[i] > data[i+1]) {
					int backup = data[i+1];
					data[i+1] = data[i];
					data[i] = backup;
				}
			}
		}
		
		
		
		// 출력
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
	}
}
