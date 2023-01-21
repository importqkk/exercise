package ex230121;
import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String title;
	private String author;
	private String company;
	private int price;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		return price;
	}
	public void setPrice(int price) {
		if(price >= 0) {			
			this.price = price;
		}
	}
	
	public Book(String title, String author, String company, int price) {
		this.title = title;
		this.author = author;
		this.company = company;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [title = " + title + ", author = " + author + ", company = " + company + ", price = " + price + "]";
	}
	
}