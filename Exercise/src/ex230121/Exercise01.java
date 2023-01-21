package ex230121;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Exercise01 {
	public static void main(String[] args) throws IOException {
		
		Book book = new Book("어린왕자", "생텍쥐페리", "열린책들", 10620);
		
		File file = new File("temp", "book.txt");
		FileOutputStream oStream = new FileOutputStream(file);
		BufferedOutputStream bStream = new BufferedOutputStream(oStream);
		ObjectOutputStream obStream = new ObjectOutputStream(bStream);
		
		obStream.writeObject(book);
		obStream.close();
		
		System.out.println("저장 완료");
		
	}
}
