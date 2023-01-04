package day06;

public class Exercise03 {
	public static void main(String[] args) {
		
		// 데이터: 10, 37, 55, 58, 61, 72, 73, 84, 96, 98
		
		// 1. 데이터 모두 출력
		System.out.println("모든 데이터");
		int[] data = new int[] {10, 37, 55, 58, 61, 72, 73, 84, 96, 98};
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);			
		}
		System.out.println();
		
		// 2. 홀수 데이터만 출력
		System.out.println("홀수");
		for (int i = 0; i < data.length; i++) {
			if(data[i] % 2 != 0) {
				System.out.println(data[i]);
			}
		}
		System.out.println();
		
		// 3. 50 이하인 데이터의 개수
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if(data[i] <= 50) {
				count++;
			}
		}
		System.out.println("50 이하 개수: " + count +"개");
		
		// 4. 모든 데이터의 평균
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		double avg = (double) sum / data.length;
		System.out.println("평균: " + avg);
		
	}
}
