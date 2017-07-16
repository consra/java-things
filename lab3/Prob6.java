package lab3;

class Punct {
	private int abscisa;
	private int ordonata;
	
	public Punct ()
	{
		this.abscisa = 0;
		this.ordonata = 0;
	}
	
	public void setX (int x)
	{
		this.abscisa = x;
	}
	
	public void setY (int y)
	{
		this.ordonata = y;
	}
	
	public int getX()
	{
		return abscisa;
	}
	
	public int getY ()
	{
		return ordonata;
	}
	
	public String toString ()
	{
		String coordonate = "(" + abscisa + ", " + ordonata + ")";
		return coordonate;
	}
	
	public double distance (int x, int y)
	{
		double sum = Math.sqrt(Math.pow(x - this.abscisa, 2) + Math.pow(y - this.ordonata, 2));
		return sum;
	}
	
	public double distance (Punct P1)
	{
		double sum = Math.sqrt(Math.pow(P1.abscisa - this.abscisa, 2) + Math.pow(P1.ordonata - this.ordonata, 2));
		return sum;
	}
}

public class Prob6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punct A = new Punct ();
		A.setX(1);
		A.setY(2);
		System.out.println(A.toString());
		Punct B = new Punct ();
		B.setX(-1);
		B.setY(3);
		System.out.println(B.toString());
		System.out.println("Distanta dintre A si B este: " + A.distance(B));
	}

}
