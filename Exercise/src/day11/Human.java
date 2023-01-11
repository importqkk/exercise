package day11;

public class Human extends Animal implements Land, Mammal {

	public Human(String name) {
		super(name);
	}

	@Override
	public void bear() {
		System.out.println("인간은 아기를 낳을 수 있다.");
	}

	@Override
	public void walk() {
		System.out.println("인간은 걸을 수 있다.");
	}

	@Override
	public void sleep() {
		System.out.println("인간은 잔다.");
	}

	@Override
	public void eat() {
		System.out.println("인간은 음식을 먹는다.");
	}
	
	public void read() {
		System.out.println("인간은 책을 읽을 수 있다.");
	}
	
	public void drive() {
		System.out.println("인간은 운전할 수 있다.");
	}
	
}
