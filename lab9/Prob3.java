package lab9;

import java.util.ArrayList;

interface GenericInterface<T> extends Comparable<T> {
	public abstract void removeDuplicates();
	public abstract T max();
	public abstract int binarySearch(int start, int end, T x);
}

class GenericList<T> implements GenericInterface<T> {
	public ArrayList<T> list;
	
	public GenericList ()
	{
		list = new ArrayList<>();
	}
	
	public void add (T element)
	{
		this.list.add(element);
	}

	public int count (T element)
	{
		int n = 0;
		for (int i = 0; i < list.size(); ++i)
		{
			if (element.equals(list.get(i)))
				n++;
		}
		return n;
	}
	
	@Override
	public void removeDuplicates() {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); ++i)
		{
			if (count(list.get(i)) > 1)
				list.remove(i);
		}
	}

	@Override
	public T max() {
		int maximum = Integer.MIN_VALUE;
		int index = 0;
		T our_max = list.get(0);
		for (int i = 0; i < this.list.size(); ++i)
		{
			if (maximum <= ((Comparable<T>) our_max).compareTo(list.get(i)))
			{
				maximum = ((Comparable<T>) our_max).compareTo(list.get(i));
				index = i;
			}
		}
		return list.get(index);
	}

	@Override
	public int binarySearch(int start, int end, T x) {
		// TODO Auto-generated method stub
		if (start > end)
			return -1;
		int middle = start + (end - start) / 2;
		if (((Comparable<T>) x).compareTo(this.list.get(middle)) == 0)
			return middle;
		else if (((Comparable<T>) x).compareTo(this.list.get(middle)) > 0)
			return binarySearch(middle + 1, end, x);
		else
			return binarySearch(start, middle, x);
	}

	public T obtain_middle ()
	{
		int middle = list.size() / 2;
		return this.list.get(middle);
	}
	
	@Override
	public int compareTo(Object o) {
		T kek = (T) o;
		return this.compareTo(kek);
	}
	
}

public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericList<Integer> kek = new GenericList<>();
		kek.add(-1);
		kek.add(3);
		kek.add(6);
		kek.add(9);
		System.out.println(kek.max());
	}

}
