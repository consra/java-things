package lab13;

interface IceCream {
	
	public String getDescription();
	public double getCost();
}

class BasicIceCream implements IceCream {
	private double cost;
	
	public BasicIceCream ()
	{
		this.cost = 0.5;
	}

	@Override
	public String getDescription() {
		String result = "A basic ice cream at the price of " + cost;
		return result;
	}

	@Override
	public double getCost() {
		return this.cost;
	}
	
	
}

abstract class ToppingDecorator {
	protected IceCream tempIceCream;
	
	public ToppingDecorator (IceCream cream) {
		this.tempIceCream = cream;
	}
	
	public String getDescription () {
		return this.tempIceCream.getDescription();
	}
	public double getCost()
	{
		return this.tempIceCream.getCost();
	}
	
}

class Chocolate extends ToppingDecorator {
	
	public Chocolate (IceCream chocolate)
	{
		super(chocolate);
	}	
}

class Vanilla extends ToppingDecorator {
	
	public Vanilla (IceCream vanilla)
	{
		super(vanilla);
	}	
}

public class Prob2 {
	public static void main (String[] args) {
		Chocolate choco = new Chocolate (new IceCream () {

			private double cost = 1.5;
			
			@Override
			public String getDescription() {
				return "Ice cream with choco at the price of " + this.cost;
			}

			@Override
			public double getCost() {
				return cost;
			}
			
		});
		System.out.println("Adding choco with the price of " + choco.getCost());
		Vanilla vani = new Vanilla (new IceCream () {
			private double cost = 2;
			@Override
			public String getDescription() {
				return "Ice cream with topping of vanilla";
			}

			@Override
			public double getCost() {
				return this.cost;
			}
			
		});
		System.out.println("Adding vanilla with the price of " + vani.getCost());
		BasicIceCream ice_cream = new BasicIceCream ();
		System.out.println(ice_cream.getDescription());
		double total_cost = choco.getCost() + vani.getCost() + ice_cream.getCost();
		System.out.println("Total cost: " + total_cost);
		
	}
	
}
