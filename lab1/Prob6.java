package lab1;

public class Prob6 {

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
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++)
		{
			if (check(i))
				System.out.println("Prime " + i);
			else
				System.out.println("Not prime " + i);
		}
	}

}
