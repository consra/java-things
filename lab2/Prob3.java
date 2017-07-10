package lab2;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class Prob3 {

	public static int apparitions (Vector <Integer> vect, int x)
	{
		int count = 0;
		for (int i = 0; i < vect.size(); ++i)
		{
			if (vect.get(i) == x)
				count++;
		}
		if (count != 0)
		{
			for (int j = 0; j < count; ++j)
			{
				vect.remove(x);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector <Integer> vect = new Vector<>(20);
		Random generate = new Random();
		for (int i = 0; i < 20; ++i)
			vect.add(new Integer (generate.nextInt(10)));
		for (int i = 0; i < 20; ++i)
			System.out.println(vect.get(i));
		System.out.println("Apparitions: " + apparitions(vect, 3));
		System.out.println("Maximum element: " + Collections.max(vect));
		System.out.println("Minimum element: " + Collections.min(vect));
		int sum = 0;
		for (int i = 0; i < vect.size(); ++i)
			sum += vect.get(i);
		System.out.println("Media aritmetica = " + ((float)sum / (float)vect.size()));

	}

}
