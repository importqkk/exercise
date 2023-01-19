package day17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exercise03 {
	public static void main(String[] args) throws IOException {
		
		File file = new File("temp", "memo.txt");
		FileReader read = new FileReader(file);
		BufferedReader buffer = new BufferedReader(read);
		
		
		while(true) {
			String memo = buffer.readLine();
			if(memo == null) break;
			System.out.println(memo);
		}
		
		buffer.close();
		
	}
}
