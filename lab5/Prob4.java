package lab5;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.StreamTokenizer;

public class Prob4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader file = null;
		int n = 0;
		try {
			file = new FileReader(new File("D:\\\\Java Things\\\\lab5\\\\src\\\\lab5\\\\test02.in"));
			StreamTokenizer str = new StreamTokenizer(file);
			while (str.nextToken() != StreamTokenizer.TT_EOF)
				n++;
			System.out.println("Numarul de cuvinte din fisier este: " + n);
				
			}
		 catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (IOException ex) {

				ex.printStackTrace();
		}
	}

}}
