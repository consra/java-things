package lab7;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.SortedSet;

class SListSet<E> extends LinkedList<Object> implements SortedSet<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Comparator<Object> compare = null;
	
	public SListSet ()
	{
		super();
	}
	
	public SListSet (Comparator <Object> compare)
	{
		super();
		this.compare = compare;
	}
	
	public boolean add (Object e)
	{
		boolean ok = false;
		for (Object kek: this)
		{
			if (e.equals(kek))
				ok = true;
		}
		if (ok == false)
			ok = super.add(e);
		Collections.sort(this, this.comparator());
		return ok;
	}

	@Override
	public Comparator<Object> comparator() {
		// TODO Auto-generated method stub
		return this.compare;
	}

	@Override
	public Object first() {
		return this.get(0);
	}
	
	public int find_index (Object e) {
		for (int i = 0; i < this.size(); ++i)
		{
			if (e.equals(this.get(i)))
				return i;
		}
		return -1;
	}

	@Override
	public SortedSet<Object> headSet(Object arg0) {
		int end = find_index(arg0);
		SortedSet <Object> my_set = new SListSet <>();
		for (int i = 0; i <= end; ++i)
			my_set.add(this.get(i));
		return my_set;
	}

	@Override
	public Object last() {
		return this.get(this.size() - 1);
	}

	@Override
	public SortedSet<Object> subSet(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		int start = find_index(arg0);
		int end = find_index(arg1);
		SortedSet <Object> my_set = new SListSet <>();
		for (int i = start; i <= end; ++i)
			my_set.add(this.get(i));
		return my_set;
	}

	@Override
	public SortedSet<Object> tailSet(Object arg0) {
		// TODO Auto-generated method stub
		int start = find_index(arg0);
		SortedSet <Object> my_set = new SListSet <>();
		for (int i = start; i < this.size(); ++i)
			my_set.add(this.get(i));
		return my_set;
	}
	
}

public class Prob4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SListSet<Integer> list = new SListSet<>();
		list.add(4);
		list.add(6);
		list.add(5);
		list.add(6);
		list.add(4);
		System.out.println("The size of the list is " + list.size());
		for (int i = 0; i < list.size(); ++i)
			System.out.println(list.get(i));
	}

}
