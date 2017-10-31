package lab6;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

class Fisiere implements FileFilter {
	public Vector <String> extensions;
	public Vector <String> words;
	
	public Fisiere ()
	{
		File extensii = new File ("D:\\Java Things\\lab6\\src\\lab6\\extension.in");
		Scanner scan = null;
		try {
			scan = new Scanner (extensii);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extensions = new Vector <String> (10);
		while (scan.hasNextLine())
			extensions.add(scan.nextLine());
		scan.close();
		
		File cuvinte = new File ("D:\\Java Things\\lab6\\src\\lab6\\words.in");
		Scanner read = null;
		try {
			read = new Scanner (cuvinte);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		words = new Vector <String> (10);
		while (read.hasNextLine())
			words.add(read.nextLine());
		read.close();
	}
	
	public boolean accept (File file)
	{   
		int ok = 0;
		for (int i = 0; i < this.extensions.size(); ++i)
		{
			if (file.getName().toLowerCase().endsWith(this.extensions.get(i)))
				ok = 1;
		}
		if (ok == 0)
			return false;
		for (int i = 0; i < this.words.size(); ++i)
		{
			if (file.getName().toLowerCase().indexOf(this.words.get(i)) != -1)
				return true;
		}
		return false;
	}
	
}

public class Prob5{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File kek = new File ("D:\\Java Things\\lab6\\src\\lab6\\director\\fisiere_c\\omp_workshare1.c");
		Fisiere plm = new Fisiere();
		if (plm.accept(kek))
			System.out.println("OK");
		else
			System.out.println("Not OK");
		
			
	}

}
