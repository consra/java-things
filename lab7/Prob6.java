package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Prob6 {

	public static TreeSet<String> extractWords (String kek)
	{
		TreeSet <String> words = new TreeSet<String>();
		Scanner scan = null;
		try {
			File lel = new File (kek);
			System.out.println(lel.getAbsolutePath());
			scan = new Scanner (lel);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet <String> list = extractWords("‪D:\\file_input.txt");
		TreeMap<String, LinkedList<Integer>> words = new TreeMap <String, LinkedList<Integer>> ();
		Iterator <String> itr = list.iterator();
		while (itr.hasNext())
		{
			int i = 1;
			Scanner scan = null;
			try {
				scan = new Scanner (new File ("‪D:\\file_input.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String line = scan.nextLine();
			LinkedList<Integer> numbers = new LinkedList<Integer>();
			while (scan.hasNextLine())
			{
				if (line.indexOf(itr.toString()) != -1)
				{
					numbers.add(i);
					i++;
				}
				line = scan.nextLine();
					
			}
			scan.close();
			words.put(itr.toString(), numbers);
			
		}
		for (Map.Entry<String, LinkedList<Integer>> entry: words.entrySet())
		{
			System.out.println(" Nume: " + entry.getValue());
		}
	}

}
