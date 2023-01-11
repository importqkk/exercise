package day11;

public class Seagull extends Animal implements Bird {

	public Seagull(String name) {
		super(name);
	}

	@Override
	public void egg() {
		System.out.println("갈매기는 알을 낳을 수 있다.");
	}

	@Override
	public void fly() {
		System.out.println("갈매기는 하늘을 날 수 있다.");
	}

	@Override
	public void sleep() {
		System.out.println("갈매기는 잔다.");
	}

	@Override
	public void eat() {
		System.out.println("갈매기는 물고기를 먹는다.");
	}
	
	public void winter() {
		System.out.println("갈매기는 겨울에 먼 길을 떠난다.");
	}
	
}
