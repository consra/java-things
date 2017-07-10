package lab2;

import java.util.StringTokenizer;

public class Prob2 {

	public static int apparitions_1 (String s1, String s2)
	{
		int count = 0;
		for (String value: s1.split(" "))
		{
			if (s2.equals(value))
				count++;
			
		}
		if (count == 0)
			return 0;
		else
			return 1;
	}
	
	public static int apparitions_2 (String s1, String s2)
	{
		int count = 0;
		StringTokenizer kek = new StringTokenizer (s1, " ,.-\\/(][)\n");
		while (kek.hasMoreTokens())
		{
			if (s2.equals(kek.nextToken().toString()))
				count++;
		}
		if (count == 0)
			return 0;
		else
			return 1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String one = "sir1 si sir2 sunt 2 siruri";
		String two = "sir1";
		System.out.println(apparitions_1(one, two));
		System.out.println(apparitions_2(one, two));
	}

}
