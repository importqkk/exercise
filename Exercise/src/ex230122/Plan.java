package ex230122;

public class Plan {
	
	private String type;
	private int month;
	private int price;
	private boolean recommend;
	private int rate = 16;


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month == 1 || month == 12) {			
			this.month = month;
		}
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	public boolean isRecommend() {
		return recommend;
	}
	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}
	
	
//	public void setting(String type, int month, int price) {
//		this.setting(type, month, price, false);
//	}
	
	
	public Plan(String type, int month, int price, boolean recommend) {
		this.type = type;
		this.month = month;
		this.price = price;
		this.recommend = recommend;
	}
	
	
	public void print() {
		System.out.print(type + "\t\t");
		if(month == 12) {	
			System.out.print(month + "개월 (" + rate + "%)\t\t");
			System.out.println(price + " (월 \\" + price / 12 + ")");
		}
		else {
			System.out.print(month + "개월\t\t");
			System.out.println("\\" + price);
		}
		
	}
	
}
