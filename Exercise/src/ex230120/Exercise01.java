package ex230120;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Exercise01 {
	public static void main(String[] args) throws IOException {
		
		File file = new File("temp", "nums.txt");
		FileOutputStream oStream = new FileOutputStream(file);
		BufferedOutputStream bStream = new BufferedOutputStream(oStream);
		DataOutputStream dStream = new DataOutputStream(bStream);
		
		Random ran = new Random();
		
		List<Integer> nums = new ArrayList<>();
		
		while(nums.size() < 10) {
			int num = ran.nextInt(50) + 1;
			if(!nums.contains(num)) {				
				nums.add(num);
				dStream.writeInt(num);
			}
		}
		
		dStream.close();
		Collections.sort(nums);		
		System.out.println(nums);
		
	}
}