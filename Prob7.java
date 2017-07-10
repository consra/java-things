package lab1;

import java.util.Scanner;

public class Prob7 {
	
	public static boolean check (int n)
	{
		int count = 0;
		if (n == 1 || n == 0)
			return false;
		for (int i = 2; i <= n; ++i)
		{
			if (n % i == 0)
				count++;
		}
		if (count == 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = 2 * n;
		for (int i = 0; i < k; i += 2)
		{
			if (i == 0 || i == 2)
				System.out.println("Nope: " + i);
			else
			{
				for (int j = 2; j <= i; j++)
				{
					if (check(j) && (check(i - j)))
						System.out.println(i + " = " + j + " + " + (i - j));
				}
			}
		}
		scan.close();

	}

}
