package day15;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Exercise02 {
	public static void main(String[] args) {
		
		Set<Integer> nums = new HashSet<>();
		Random ran = new Random();
		
		while(nums.size() < 10) {
			int num = ran.nextInt(50) + 1;
			nums.add(num);			
		}
		
		for(int n : nums) {
			System.out.print(n);
			System.out.print("  ");
		}
		
	}
}
