package day11;

public class Whale extends Animal implements Water, Mammal {

	public Whale(String name) {
		super(name);
	}

	@Override
	public void bear() {
		System.out.println("고래는 새끼를 낳을 수 있다.");
	}

	@Override
	public void swim() {
		System.out.println("고래는 수영한다.");
	}

	@Override
	public void sleep() {
		System.out.println("고래는 잔다.");
	}

	@Override
	public void eat() {
		System.out.println("고래는 물고기를 먹는다.");
	}
	
	public void spray() {
		System.out.println("고래는 등에서 물을 뿜는다.");
	}

}
