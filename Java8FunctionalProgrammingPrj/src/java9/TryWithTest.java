package java9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithTest {

	public static void main(String[] args) throws IOException  {

		BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
		try(reader) {
			System.out.println(reader.readLine());
		}
	}
}
