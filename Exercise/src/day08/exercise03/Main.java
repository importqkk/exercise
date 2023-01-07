package day08.exercise03;

public class Main {
	public static void main(String[] args) {
		
		Chart c1 = new Chart();
		Chart c2 = new Chart();
		Chart c3 = new Chart();
		Chart c4 = new Chart();
		Chart c5 = new Chart();
		Chart c6 = new Chart();
		Chart c7 = new Chart();
		Chart c8 = new Chart();
		Chart c9 = new Chart();
		Chart c10 = new Chart();
		
		c1.setting(1, "Ditto", "NewJeans", "-");
		c2.setting(2, "사건의 지평선", "윤하", "-");
		c3.setting(3, "Hype Boy", "NewJeans", "-");
		c4.setting(4, "ANTIFRAGILE", "LE SSERAFIM", "up");
		c5.setting(5, "Attention", "NewJeans", "up");
		c6.setting(6, "Candy", "NCT DREAM", "down");
		c7.setting(7, "After LIKE", "IVE", "-");
		c8.setting(8, "Nxde", "(G)I-DLE", "up");
		c9.setting(9, "KICK BACK", "Kenshi Yonezu", "down");
		c10.setting(10, "LOVE DIVE", "IVE", "-");
		
		System.out.println("<<2023.01.08 유튜브 뮤직 차트>>");
		System.out.println();
		c1.print();
		c2.print();
		c3.print();
		c4.print();
		c5.print();
		c6.print();
		c7.print();
		c8.print();
		c9.print();
		c10.print();
		
	}
}
