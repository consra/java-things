package lab7;

abstract class Hero {
	abstract void print();
}

class Warrior extends Hero {
	public void print()
	{
		System.out.println("Mocanu e pederast");
	}
}

class Ninja extends Hero {
	public void print()
	{
		System.out.println("Mocanu ia la pula");
	}
}

class Rogue extends Hero {
	public void print()
	{
		System.out.println("Mocanu + Malone = Luv");
	}
}

abstract class BadLuck {
	abstract void execute (Hero h);
	abstract void execute (Warrior w);
	abstract void execute (Ninja n);
	abstract void execute (Rogue r);
}

class StormFire extends BadLuck {
	public void execute (Hero h)
	{
		h.print();
	}
	public void execute (Warrior w)
	{
		w.print();
	}
	public void execute (Ninja n)
	{
		n.print();
	}
	public void execute (Rogue r)
	{
		r.print();
	}
}

public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hero h1 = new Warrior();
		Hero h2 = new Ninja();
		Hero h3 = new Rogue();
		BadLuck bl = new StormFire();
		bl.execute(h1);
		bl.execute(h2);
		bl.execute(h3);
	}

}
