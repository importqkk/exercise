package day11;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("---- 인간 ----");
		Human h = new Human("알렉스");
		h.print();
		h.sleep();
		h.eat();
		h.bear();
		h.read();
		h.drive();
		System.out.println();
		
		System.out.println("---- 고래 ----");
		Whale w = new Whale("베스");
		w.print();
		w.sleep();
		w.eat();
		w.swim();
		w.bear();
		w.spray();
		System.out.println();
		
		System.out.println("---- 갈매기 ----");
		Seagull s = new Seagull("신디");
		s.print();
		s.sleep();
		s.eat();
		s.eat();
		s.fly();
		s.winter();
		
	}
}
