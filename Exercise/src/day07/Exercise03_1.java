package day07;

public class Exercise03_1 {
	public static void main(String[] args) {
		
		// 삽입정렬
		
		// 데이터: 3, 1, 5, 4, 7, 2, 6
		
		// 데이터 생성
		int[] data = new int[] {3, 5, 1, 4, 7, 2, 6};
		
		
		// 처리
		
		for(int k = 0; k < data.length; k++) {
			int index = k;
			int backup = data[index];
			for(int i = index - 1; i >= 0; i--) {
				if(backup < data[i]) {
					data[i+1] = data[i];
					index--;
				}
			}
			data[index] = backup;
		}
		
		
		
		
		// 출력
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}
		
	}
}
