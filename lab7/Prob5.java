package lab7;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Prob5 {
	
	public static TreeMap<Long, String> files_one (File folder)
	{
		TreeMap<Long, String> mapping = new TreeMap<Long, String>();
		for (File fisier: folder.listFiles())
		{
			if (!fisier.isDirectory())
				mapping.put(fisier.length(), fisier.getName());
		}
		return mapping;
	}
	
	public static HashMap<Long, String> files_two (File folder)
	{
		HashMap<Long, String> mapping = new HashMap<Long, String>();
		for (File fisier: folder.listFiles())
		{
			if (!fisier.isDirectory())
				mapping.put(fisier.length(), fisier.getName());
		}
		return mapping;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Long, String> kek = files_one(new File("C:\\Users\\User\\Desktop"));
		System.out.println("Sorted by keys");
		for (Map.Entry<Long, String> entry: kek.entrySet())
			System.out.println("File size: " + entry.getKey() + " File name: " + entry.getValue());
		TreeMap<Long, String> kek_sorted = new TreeMap<Long, String> (new Comparator<Long>() {
			public int compare (Long one, Long two)
			{
				return kek.get(one).compareTo(kek.get(two));
			}
		});
		kek_sorted.putAll(kek);
		System.out.println("Sorted by values");
		for (Map.Entry<Long, String> entry: kek_sorted.entrySet())
			System.out.println("File size: " + entry.getKey() + " File name: " + entry.getValue());
	}

}
