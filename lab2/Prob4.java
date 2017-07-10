package lab2;

import java.util.Vector;

public class Prob4 {
	
	public static int check (Vector <Integer> vect, int x)
	{
		int count = 0;
		for (int i = 0; i < vect.size(); ++i)
		{
			if (vect.get(i) == x)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector <Integer> one = new Vector<> (20);
		Vector <Integer> two = new Vector<> (20);
		Vector <Integer> reunion = new Vector<> (50);
		Vector <Integer> intersection = new Vector<> (20);
		Vector <Integer> difference = new Vector<> (20);
		int i;
		one.add(3);
		one.add(1);
		one.add(6);
		one.add(9);
		one.add(0);
		one.add(13);
		one.add(10);
		one.add(19);
		one.add(4);
		one.add(8);
		one.add(69);
		two.add(34);
		two.add(30);
		two.add(25);
		two.add(23);
		two.add(39);
		two.add(14);
		two.add(19);
		two.add(20);
		two.add(10);
		two.add(6);
		two.add(1);
		for (i = 0; i < one.size(); ++i)
			reunion.add(one.get(i));
		for (i = 0; i < two.size(); ++i)
			reunion.add(two.get(i));
		for (i = 0; i < one.size(); ++i)
		{
			if(!two.contains(one.get(i)))
				intersection.add(one.get(i));
			else
				difference.add(one.get(i));
		}
		System.out.println("First");
		for (i = 0; i < one.size(); ++i)
			System.out.printf("%d ", one.get(i));
		System.out.println("\nSecond");
		for (i = 0; i < two.size(); ++i)
			System.out.printf("%d ", two.get(i));
		System.out.println("\nReunion");
		for (i = 0; i < reunion.size(); ++i)
			System.out.printf("%d ", reunion.get(i));
		System.out.println("\nIntersection");
		for (i = 0; i < intersection.size(); ++i)
			System.out.printf("%d ", intersection.get(i));
		System.out.println("\nDifference");
		for (i = 0; i < difference.size(); ++i)
			System.out.printf("%d ", difference.get(i));
		
	}

}
