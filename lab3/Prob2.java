package lab3;

class Produs {
	String prod_name;
	double price;
	int quantity;
	public Produs (String name, double pret, int cantitate)
	{
		this.prod_name = name;
		this.price = pret;
		this.quantity = cantitate;
	}
	
	public double getTotalProdus ()
	{
		double kek = price * (double) quantity;
		return kek;
	}
	
	public String toString ()
	{
		String meh = prod_name + "_" + price + "_" + quantity;
		return meh;
	}
}

class Magazin {
	String name;
	Produs one, two, three;
	public Magazin (Produs mocanu, Produs suge, Produs kuku, String nume)
	{
		this.name = nume;
		this.one = mocanu;
		this.two = suge;
		this.three = kuku;
	}
	public String toString ()
	{
		String kek = one.toString() + "\n" + two.toString() + "\n" + three.toString();
		return kek;
	}
	
	public double getTotalMagazin ()
	{
		double sum = one.getTotalProdus() + two.getTotalProdus() + three.getTotalProdus();
		return sum;
	}
}

public class Prob2 {

	public static void main(String[] args) {
		Magazin shop = new Magazin (new Produs("vibrator", 0.69, 3), new Produs("prezervativ", 0.5, 6),
				new Produs("latex", 0.42, 7), "Sex Shop");
		System.out.println(shop.toString());

	}

}
