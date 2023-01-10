package day10.inherit;

public class Fight {
	public static void main(String[] args) {

		System.out.println("레벨 1 몬스터");
		MonsterLvl1 m1 = new MonsterLvl1();
		m1.hit();
		m1.duck();
		
		System.out.println();
		System.out.println("레벨 2 몬스터");
		MonsterLvl2 m2 = new MonsterLvl2();
		m2.hit();
		m2.water();
		m2.duck();
		m2.heal();
		
		System.out.println();
		System.out.println("레벨 3 몬스터");
		MonsterLvl3 m3 = new MonsterLvl3();
		m3.hit();
		m3.water();
		m3.fire();
		m3.duck();
		m3.heal();
		m3.reflect();
		
	}
}
