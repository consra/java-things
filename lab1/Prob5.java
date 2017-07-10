package lab1;

public class Prob5 {

	public static int power1 (int n, int k)
	{
		int p = 1;
		for (int i = 1; i <= n; ++i)
			p *= k;
		return p;
	}
	
	public static int power2 (int n, int k)
	{
		if (n == 0)
			return 1;
		else
			return (k * power2(n - 1, k));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power1(3, 9));
		System.out.println(power2(3, 9));
		System.out.println(Math.pow(9, 3));
	}

}
