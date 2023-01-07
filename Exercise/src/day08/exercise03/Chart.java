package day08.exercise03;

public class Chart {

	int rank;
	String title;
	String artist;
	String status;
	
	void setting (int rank, String title, String artist, String status) {
		this.rank = rank;
		this.title = title;
		this.artist = artist;
		this.status = status;
	}
	
	void print () {
		if(status == "up") {
			System.out.print(rank + "위 ↑\t");
		}
		else if(status == "down") {
			System.out.print(rank + "위 ↓\t");
		}
		else {
			System.out.print(rank + "위 -\t");
		}
		System.out.print(title);
		System.out.println(" - " + artist);
	}
	
}
