package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Comparison implements Comparator<String>
{
	public int compare (String one, String two)
	{
		String a = one, b = two;
		return b.compareTo(a);
	}
}

public class Prob1 {
	
	public static TreeSet<String> printWords (String kek)
	{
		TreeSet <String> words = new TreeSet<String>();
		Scanner scan = null;
		try {
			scan = new Scanner (new File(kek));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = scan.nextLine();
		while (scan.hasNextLine())
		{
			StringTokenizer token = new StringTokenizer(line, "()-,. ");
			while (token.hasMoreTokens())
			{	
				words.add(token.nextToken());
			}
			line = scan.nextLine();
		}
		scan.close();
		return words;
	}
		
	public static TreeSet<String> printWordsComparator (TreeSet<String> set)
	{
		TreeSet <String> ialapula = new TreeSet<String> (new Comparison());
		Iterator<String> itr=set.iterator();  
		  while(itr.hasNext()) 
		  {  
			  ialapula.add(itr.next());  
		  }
		return ialapula;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> kek = printWords("D:\\Java Things\\lab7\\src\\lab7\\test01.in");
		TreeSet<String> mocanu_gay = printWordsComparator(kek);
		 Iterator<String> itr=mocanu_gay.iterator();  
		  while(itr.hasNext()) 
		  {  
			  System.out.println(itr.next());  
		  }

	}

}
