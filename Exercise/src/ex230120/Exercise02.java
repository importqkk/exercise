package ex230120;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Exercise02 {
	public static void main(String[] args) throws IOException {
		
		File file = new File("temp", "nums.txt");
		FileInputStream iStream = new FileInputStream(file);
		BufferedInputStream bStream = new BufferedInputStream(iStream);
		DataInputStream dSteam = new DataInputStream(bStream);
		
		Set<Integer> nums = new TreeSet<>();
		
		try {
			while(true) {
				int num = dSteam.readInt();
				nums.add(num);
			}
		}
		catch(Exception e) {
			
		}
		
		dSteam.close();
		
		System.out.println(nums);
		
	}
}