package lab6;

import java.util.Vector;

abstract class Vagon {
	int capacitate;
	int colete;
	abstract void inchidere();
	abstract void deschidere();
	abstract void blocare();
}

class CalatoriA extends Vagon {
	//int capacitate;
	//int colete;
	
	public CalatoriA () {
		this(40, 300);
	}

	public CalatoriA(int i, int j) {
		// TODO Auto-generated constructor stub
		this.capacitate = i;
		this.colete = j;
	}
	
	void inchidere() {
		System.out.println("Se inchid usile");
	}
	
	void deschidere() {
		System.out.println("Se deschid usile");
	}
	
	void blocare() {
		System.out.println("Geamurile nu se blocheaza");
	}
}

class CalatoriB extends Vagon {
	//int capacitate;
	//int colete;
	
	public CalatoriB () {
		this(50, 400);
	}

	public CalatoriB (int i, int j) {
		// TODO Auto-generated constructor stub
		this.capacitate = i;
		this.colete = j;
	}
	
	void inchidere() {
		System.out.println("Se inchid usile");
	}
	
	void deschidere() {
		System.out.println("Se deschid usile");
	}
	
	void blocare() {
		System.out.println("Geamurile se blocheaza");
	}
}

class Marfa extends Vagon {
	//int colete;
	
	public Marfa () {
		this(400);
	}

	public Marfa (int j) {
		// TODO Auto-generated constructor stub
		this.colete = j;
	}
	
	void inchidere() {
		System.out.println("Nu se inchid usile");
	}
	
	void deschidere() {
		System.out.println("Nu se deschid usile");
	}
	
	void blocare() {
		System.out.println("Geamurile se blocheaza");
	}
}

class Tren implements Comparable <Object>{
	public Vector <Vagon> tren;
	
	public Tren () {
		tren = new Vector <Vagon> (50);
	}
	
	public void addVagon (Vagon kek)
	{
		this.tren.add(kek);
	}
	
	public String toString ()
	{
		return "Trenuletul";
	}
	@Override
	public int compareTo (Object t)
	{
		Tren kek = (Tren) t;
		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < this.tren.size(); ++i)
			sum1 += this.tren.get(i).colete;
		for (int i = 0; i < kek.tren.size(); ++i)
			sum2 += kek.tren.get(i).colete;
		return sum1 - sum2;
	}
}

public class Prob6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tren t = new Tren();
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriB());
        t.addVagon(new CalatoriA());
        t.addVagon(new Marfa());
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriA());
        t.addVagon(new CalatoriB());
        t.addVagon(new CalatoriB());
        t.addVagon(new Marfa());
        System.out.println(t);
        Tren t1 = new Tren();
        t1.addVagon(new CalatoriB());
        t1.addVagon(new CalatoriB());
        t1.addVagon(new CalatoriA());
        t1.addVagon(new CalatoriB());
        t1.addVagon(new Marfa());
        t1.addVagon(new CalatoriB());
        t1.addVagon(new CalatoriA());
        t1.addVagon(new CalatoriA());
        t1.addVagon(new Marfa());
        System.out.println(t1);
        boolean ok = true;
        if(t.compareTo(t1) != 0) {
            System.out.println("Testul 1 a trecut!");
        } else {
            System.out.println("Testul 1 este picat!");
            ok = false;
        }
        if(t.compareTo(t) == 0 && t1.compareTo(t1) == 0) {
            System.out.println("Testul 2 a trecut!");
        } else {
            System.out.println("Testul 2 este picat!");
            ok = false;
        }
        if(t.compareTo(t1) < 0 && t1.compareTo(t) > 0) {
            System.out.println("Testul 3 a trecut!");
        } else {
            System.out.println("Testul 3 a picat!");
            ok = false;
        }
        if(ok) {
            System.out.println("Toate testele au trecut!");
        }
	}

}
