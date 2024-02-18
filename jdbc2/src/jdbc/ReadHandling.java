package jdbc;

import java.io.FileReader;

public class ReadHandling {

	public static void main(String[] args) {
		char[] array = new char[100];
		try{
			FileReader file = new FileReader("file4.text");
			file.read(array);
			System.out.println("Data are in the file");
			file.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}

		
	}

}
