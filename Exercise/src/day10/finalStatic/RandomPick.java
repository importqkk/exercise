package day10.finalStatic;
import java.util.Random;

public class RandomPick {
	public static void main(String[] args) {
		
		Random r = new Random();
		int lunch = r.nextInt(10);
		
		System.out.println("~~~ 오늘의 점심 메뉴 추천 ~~~");
		switch (lunch) {
		case Menu.GUKBOB: System.out.println("국밥!"); break;
		case Menu.JJAJANG: System.out.println("짜장면!"); break;
		case Menu.BURGER: System.out.println("햄버거!"); break;
		case Menu.DDUCKBOKKI: System.out.println("떡볶이!"); break;
		case Menu.KALGUKSU: System.out.println("칼국수!"); break;
		case Menu.MALATANG: System.out.println("마라탕!"); break;
		case Menu.PASTA: System.out.println("파스타!"); break;
		case Menu.PIZZA: System.out.println("피자!"); break;
		case Menu.POKE: System.out.println("포케!"); break;
		case Menu.SUSHI: System.out.println("초밥!"); break;
		}
		
	}
}
