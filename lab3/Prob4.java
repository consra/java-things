package lab3;

class IaLaPula {
	int a;
	
	public IaLaPula (int kek)
	{
		this.a = kek;
	}
	
	public int suma (int b)
	{
		return a + b;
	}
	
	public int suma (int b, int c)
	{
		return suma(b) + c;
	}
	
	public int suma (int b, int c, int d)
	{
		return suma (b, c) + d;
	}
	
	public int suma (int b, int c, int d, int e)
	{
		return suma (b, c, d) + e;
	}
}

public class Prob4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IaLaPula kek = new IaLaPula(6);
		System.out.println(kek.suma(9));
		System.out.println(kek.suma(9, 1));
		System.out.println(kek.suma(9, 8, 4));

	}

}
