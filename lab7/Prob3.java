package lab7;

import java.util.Set;
import java.util.LinkedList;

class LinkedSet extends LinkedList<Object> implements Set<Object> {
	private static final long serialVersionUID = 1L;
	@Override
	public boolean add (Object e)
	{
		return super.add(e);
	}
	
	public void add (int i, Object e)
	{
		super.add(i, e);
	}
	
	public Object set (int i, Object e)
	{
		return super.set(i, e);
	}
}

public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedSet my_set = new LinkedSet();
		my_set.add(5);
		my_set.add("pula");
		my_set.add(new Float(69));
		for (int i = 0; i < my_set.size(); ++i)
			System.out.println(my_set.get(i));
	}

}
