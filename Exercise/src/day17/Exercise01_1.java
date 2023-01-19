package day17;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Format;

public class Exercise01_1 {
	public static void main(String[] args) throws IOException {
		
		File original = new File("C:/test.zip");
		File copy = new File("C:/test_copy.zip");
		
		FileInputStream inStream = new FileInputStream(original);
		FileOutputStream outStream = new FileOutputStream(copy);
		
		byte[] buffer = new byte[8192];
		
		long bytes = original.length();
		long count = 0L;
		Format f = new DecimalFormat("#,##0");
		
		while(true) {
			int size = inStream.read(buffer);
			if(size == -1) break;
			outStream.write(buffer, 0, size);
			
			count += size;
			double percent = count * 100.0 / bytes;
			System.out.println(count + "/" + bytes + ", " + f.format(percent) + "%");
		}
		
		inStream.close();
		outStream.close();
				
	}
}
