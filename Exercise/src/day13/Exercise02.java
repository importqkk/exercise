package day13;
import java.util.Scanner;

public class Exercise02 {
	public static void main(String[] args) {
		
		String[] arr = new String[] {
				"휘낭시에", "브라우니", "쿠키", "에그타르트", "스콘", "까눌레"
		};
		
		try(Scanner scan = new Scanner(System.in);) {
			
			System.out.println("(1: 휘낭시에, 2: 브라우니, 3: 쿠키, 4: 에그타르트, 5: 스콘, 6: 까눌레, 7: 나가기)");
			
			while(true) {
				System.out.print("숫자를 입력해 디저트를 선택해주세요 >> ");
				int choice = scan.nextInt();
				
				if(choice < 7) {					
					System.out.println(arr[choice - 1]);
				}
				else if(choice == 7) {
					System.out.println("카페에서 나갑니다.");
					break;
				}
				else {
					throw new Exception();
				}
			}
			
		}
		catch(Exception e) {
			System.out.println("1에서 7까지의 숫자 중 하나만 입력해주세요.");
//			e.printStackTrace();
		}
	
	}
}
