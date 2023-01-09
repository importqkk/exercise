package day09;

public class Book {

	private String name;
	private String author;
	private String company;
	private int price;
	private int year;
	private int month;
	private boolean early;
	private int rate = 10;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		if(getNew()) {
			return price * (100 - rate) / 100;
		}
		else {			
			return price;
		}
	}
	public void setPrice(int price) {
		if(price >= 0) {			
			this.price = price;
		}
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month < 0 || month > 12) return;
		this.month = month;
	}
	public boolean getEarly() {
		return early;
	}
	public void setEarly(boolean early) {
		this.early = early;
	}
	public boolean getNew() {
		return getYear() == 2023 && getMonth() == 1;
	}
	
	
	public Book(String name, String author, String company, int price, int year, int month, boolean early) {
		this.setName(name);
		this.setAuthor(author);
		this.setCompany(company);
		this.setPrice(price);
		this.setYear(year);
		this.setMonth(month);
		this.setEarly(early);
	}
	
	
	public void print() {
		if(getNew()) {
			System.out.println("제목: " + getName() + " (신간)");
		}
		else {
			System.out.println("제목: " + getName());
		}
		System.out.println("지은이: " + getAuthor());
		System.out.println("출판사: " + getCompany());
		if (getNew()) {
			System.out.print("신간 할인가: " + getPrice() + "원");
			System.out.println(" (원가: " + getPrice() / (100 - rate) * 100 + "원)");
		}
		else {			
			System.out.println("가격: " + getPrice() + "원");
		}
		System.out.println("출간일: " + getYear() + "년 " + getMonth() + "월");
		if(early) {			
			System.out.println(" * 양탄자배송: 내일 아침 7시 출근전 배송");
		}
		System.out.println();
	}
}
