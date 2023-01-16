package day14;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise02 {
	public static void main(String[] args) {
		
		String[] students = new String[] {"Bailey", "Danielle", "Alex", "Sam", "Hailey"};
		
		// 오름차 정렬
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));
		
		// 내림차 정렬
		Arrays.sort(students, Comparator.reverseOrder());
		System.out.println(Arrays.toString(students));
		
	}
}
