package day13;
import java.util.Scanner;

public class Exercise01_1 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("채팅 > ");
		String chat = scan.nextLine();
		scan.close();
		
		
		String[] filter = new String[] {
				"사과", "딸기", "오렌지", "수박", "망고", "감"
		};
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("(.*?)(");
		for(int i = 0; i < filter.length; i++) {
			buffer.append(filter[i]);
			if(i < filter.length - 1) {
				buffer.append("|");
			}
		}
		buffer.append(")(.*?)");
		String regex = buffer.toString();
		
		if(chat.matches(regex)) {			
			for(int i = 0; i < filter.length; i++) {
				int leng = filter[i].length();
				String star = "*".repeat(leng);
				chat = chat.replace(filter[i], star);
			}
		}
		System.out.println(chat);
		
	}
}
