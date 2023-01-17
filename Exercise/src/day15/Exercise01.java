package day15;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise01 {
	public static void main(String[] args) {
				
		List<String> nameList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("인원 > ");
		int count = scan.nextInt();
		scan.nextLine();
		System.out.println();
		
		for(int i = 0; i < count; i++) {
			System.out.print("이름 > ");
			String name = scan.nextLine();
			nameList.add(name);
		}
		
		Collections.shuffle(nameList);
		
		System.out.println();
		System.out.println("----- 랜덤 순서 결과 -----");
		for(int i = 0; i < count; i++) {
			System.out.println(i+1 + "번 → " + nameList.get(i));
		}
		
		scan.close();
		
	}
}
