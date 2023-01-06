package day07;

public class Exercise01_3 {
	public static void main(String[] args) {
		
		// 선택정렬
		
		// 데이터: 3, 1, 5, 4, 7, 2, 6
		
		// 데이터 생성
		int[] data = new int[] {3, 5, 1, 4, 7, 2, 6};
		
		
		// 처리
		for(int k = 0; k < data.length - 1; k++) {
			int index = k;
			for(int i = k + 1; i < data.length; i++) {
				if(data[index] > data[i]) {
					index = i;
				}
			}
			int backup = data[k];
			data[k] = data[index];
			data[index] = backup;
		}
		
		
		
		// 출력
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print(" ");
		}

	}
}
