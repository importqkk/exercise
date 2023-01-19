package day17;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise02 {
	public static void main(String[] args) throws IOException {
		
		File file = new File("temp", "memo.txt");
		FileWriter write = new FileWriter(file);
		BufferedWriter buffer = new BufferedWriter(write);
		PrintWriter print = new PrintWriter(buffer);
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("입력 > ");
			String input = scan.nextLine();
			if(input.equals("나가기")) break;
			print.println(input);
			print.flush();
		}
		
		scan.close();
		print.close();
		
		System.out.println("저장 완료");
		
	}
}
