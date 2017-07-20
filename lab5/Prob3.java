package lab5;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Prob3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String line;
		BufferedReader reading = null;
		FileWriter fisier = new FileWriter("mocanu_gay.txt");
		try {
			reading = new BufferedReader (new InputStreamReader(System.in));
			line = reading.readLine();
			while (!line.equals("exit"))
			{
				fisier.write(line);
				fisier.write(System.getProperty("line.separator"));
				line = reading.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				if (reading != null)
					reading.close();

				if (fisier != null)
					fisier.close();

			} catch (IOException ex) {

				ex.printStackTrace();
		}
		

	}

}}
