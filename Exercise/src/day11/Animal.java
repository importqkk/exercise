package day11;

public abstract class Animal {

	protected String name;
	
	public abstract void sleep();
	public abstract void eat();
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println("이름: " + name);
	}
	
}
