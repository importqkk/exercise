package day16;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Exercise01 {
	public static void main(String[] args) {
		
		Map<String, String> contactList = new TreeMap<>();
		
		contactList.put("장폰주", "010-1234-5678");
		contactList.put("망난이", "010-5678-1234");
		contactList.put("강초당", "010-1357-2468");
		contactList.put("송몽숙", "010-2468-1357");
		contactList.put("구라베", "010-9876-5432");
		
		System.out.println("--------- 연락처 ---------");
		Set<String> contacts = contactList.keySet();
		for(String name : contacts) {
			String num = contactList.get(name);
			System.out.println(name + ", " + num);
		}
		System.out.println("------------------------");
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("연락처 검색: ");
			String search = scan.nextLine();
			
			if(search.equals("나가기")) { 
				scan.close();
				System.out.println("연락처 검색을 종료합니다.");
				break;
			}
			
			if(contactList.containsKey(search)) {
				System.out.println(search + ", " + contactList.get(search));
			}
			else if(contactList.containsValue(search)) {
				for(String name : contactList.keySet()) {
					if(contactList.get(name).equals(search)) {
						String num = name;
						System.out.println(num + ", " + search);
						break;
					}
				}
			}
			else {
				System.out.println("검색 결과가 없습니다.");
			}
		}
		
	}
}
