package ex230122;

public class Exercise01 {
	public static void main(String[] args) {
		
		Plan p1 = new Plan("Premium\t", 1, 13900, false);
		Plan p2 = new Plan("Premium\t", 12, 139000, false);
		Plan p3 = new Plan("Standard", 1, 10900, true);
		Plan p4 = new Plan("Standard", 12, 109000, true);
		Plan p5 = new Plan("Basic\t", 1, 7900, false);
		Plan p6 = new Plan("Basic\t", 12, 79000, false); 
		
		p1.print();
		p2.print();
		p3.print();
		p4.print();
		p5.print();
		p6.print();
		
	}
}
