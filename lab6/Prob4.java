package lab6;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

class SortedVector<T> extends Vector<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Comparator<T> compare;

	public SortedVector (Comparator<T> compare)
	{
		super();
		this.compare = compare;
	}
	
	public boolean add (T o)
	{
		boolean ok = super.add(o);
		Collections.sort(this, compare);
		return ok;
	}
	
	public boolean sorted_remove (T o)
	{
		boolean ok = super.remove(o);
		Collections.sort(this, compare);
		return ok;	
	}	
}

class Pair {
	public String one;
	public Integer two;
	
	public Pair (String one, Integer two)
	{
		this.one = one;
		this.two = two;
	}
	
	public boolean equals() {
	    return one.equals(two);
	}
	
	public String toString ()
	{
		String result = "First object is " + one + " and the second one is " + two;
		return result;
	}
}

public class Prob4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedVector <Pair> first = new SortedVector <>(new Comparator<Pair>() {

			@Override
			public int compare(Pair arg0, Pair arg1) {
				return arg0.one.compareTo(arg1.one);
			}
			
		});
		
		SortedVector <Pair> second = new SortedVector <> (new Comparator <Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return (o1.two - o2.two);
			}
			
		});
		System.out.println("First");
		first.add(new Pair("mocanu gay", 69));
		first.add(new Pair("tarfa pederasta", 420));
		first.add(new Pair("ganja tonino", 489));
		for (int i = 0; i < first.size(); ++i)
			System.out.println(first.get(i));
		System.out.println("Second");
		second.add(new Pair("mocanu gay", 69));
		second.add(new Pair("tarfa pederasta", 420));
		second.add(new Pair("ganja tonino", 489));
		for (int i = 0; i < second.size(); ++i)
			System.out.println(second.get(i));
	}

}
