package lab5;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "D:\\Java Things\\lab5\\src\\lab5\\test01.in";
		LineNumberReader kek = null;
		FileReader in = null;
		try
		{
			in = new FileReader(input);
			String print_line;
			kek = new LineNumberReader(in);
			while((print_line = kek.readLine()) != null)
			{
				if (kek.getLineNumber() % 2 == 1)
					System.out.println(kek.getLineNumber() + ": " + print_line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				if (kek != null)
					kek.close();

				if (in != null)
					in.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}

}
