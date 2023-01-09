package day09;

public class Main {
	public static void main(String[] args) {
		
		Book b1 = new Book("스카이 버스", "분당강쌤", "다산에듀", 16200, 2023, 1, true);
		Book b2 = new Book("아버지의 해방일지", "정지아", "창비", 13500, 2022, 9, true);
		Book b3 = new Book("도쿄 에일리언즈 5", "NAON", "서울미디어코믹스(서울출판사)", 5400, 2023, 1, false);
		Book b4 = new Book("만일 내가 인생을 다시 산다면", "김혜남", "메이븐", 15480, 2022, 11, true);
		Book b5 = new Book("도쿄 에일리언즈 5", "NAON", "서울미디어코믹스(서울출판사)", 10800, 2023, 1, false);
		
		b1.print();
		b2.print();
		b3.print();
		b4.print();
		b5.print();
		
	}
}
