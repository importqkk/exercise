package ex230121;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Exercise02 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File file = new File("temp", "book.txt");
		FileInputStream iStream = new FileInputStream(file);
		BufferedInputStream bStream = new BufferedInputStream(iStream);
		ObjectInputStream obStream = new ObjectInputStream(bStream);
		
		Book book = (Book)obStream.readObject();
		
		obStream.close();
		
		System.out.println(book);
		
	}
}
