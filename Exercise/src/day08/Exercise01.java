package day08;
public class Exercise01 {
	public static void main(String[] args) {
		
		// 2차원 배열을 생성하고 출력하고, 데이터의 총합과 평균 구하기
		int sum = 0;
		int count = 0;
		int[][] data = new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		for(int i = 0; i < data.length; i++) {			
			for(int j = 0; j < data[i].length; j++) {
				count++;
				sum += data[i][j];
				System.out.print(data[i][j]);
				System.out.print("  ");
			}
			System.out.println();
		}
		double avg = (double) sum / count;
		
		System.out.println();
		System.out.println("합계: " + sum);
		System.out.println("평균: " + avg);
	}
}
