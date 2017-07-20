package lab5;

import java.util.Vector;
import java.util.Collections;
import java.util.Scanner;

class NumarNegativ extends Exception {
	
	public NumarNegativ (String message)
	{
		super (message);
	}
}

public class Prob5 {
	
	public static Vector<Integer> myRead() throws NumarNegativ
	{
		Vector <Integer> vect = new Vector<> (100);
		int input;
		Scanner scan = new Scanner(System.in);
		input = scan.nextInt();
		while (input > 0)
		{
			vect.add(input);
			input = scan.nextInt();
			//scan.close();
			if (input < 0)
			{
				throw new NumarNegativ("Numar negativ introdus!");
			}
		}
		
		return vect;
	}

	public static void main(String[] args) throws NumarNegativ{
		// TODO Auto-generated method stub
		Vector <Integer> kek = myRead();
		System.out.println(Collections.max(kek));

	}

}
