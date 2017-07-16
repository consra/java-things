package lab3;

// Problema 1

public class Fractie {
	
	double numitor, numarator;
	public Fractie (double numi, double numa)
	{
		this.numitor = numi;
		this.numarator = numa;
	}
	
	public Fractie ()
	{
		this (0.5, 2);
	}
	
	public Fractie add (Fractie frac)
	{
		return new Fractie (numitor + frac.numitor, numarator + frac.numarator);
	}
	
	public String toString ()
	{
		String kek = this.numarator + " " + this.numitor;
		return kek;
	}

	public boolean equals (Object obj)
	{
		if (obj == null)
			return false;
		if (!(obj instanceof Fractie))
			return false;
		Fractie frac = (Fractie) obj;
		return (frac.numitor == numitor && frac.numarator == numarator);
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fractie kek = new Fractie (0.69, 2);
		System.out.println(kek.toString());
		
	}

}
