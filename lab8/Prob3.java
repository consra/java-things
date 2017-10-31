package lab8;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedList<T> implements Iterable<T>{
	
	private static class Node<T> {
		public T value;
		public Node<T> next;
		public Node (T data, Node<T> next)
		{
			this.value = data;
			this.next = next;
		}
		@SuppressWarnings("unused")
		public Node (T data)
		{
			this.value = data;
			this.next = null;
		}
	}
	public Node<T> first;
	public Node<T> last;
	
	public LinkedList ()
	{
		first = null;
	}
	
	public void addFirst (T data)
	{
		first = new Node<T> (data, first);
	}
	
	public void add (T data)
	{
		if (first == null)
			addFirst(data);
		else
		{
			Node<T> aux = first;
			while (aux.next != null)
				aux = aux.next;
			aux.next = new Node <T> (data, null);
		}
	}
	
	public T getNode ()
	{
		if (first == null)
			throw new NoSuchElementException();
		return first.value;
	}
	
	private class LinkedListIterator  implements Iterator<T>
	   {
	      public Node<T> nextNode;

	      public LinkedListIterator()
	      {
	         nextNode = first;
	      }

	      public boolean hasNext()
	      {
	         return nextNode != null;
	      }

	      public T next()
	      {
	         if (!hasNext())
	        	 throw new NoSuchElementException();
	         T res = nextNode.value;
	         nextNode = nextNode.next;
	         return res;
	      }

	      public void remove() { throw new UnsupportedOperationException(); }
	   }
	public Iterator<T> iterator()
	   {
	      return new LinkedListIterator();
	   }
}

public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.add(22);
        list.add(25);
        list.add(30);

        int last = 0;
        System.out.println("Afisare 1");
        for (Integer i : list) {
            System.out.print(i + ", ");
            if (i < last) {
                System.err.println("LinkedList a fost implementata gresit.");
            }
            last = i;
        }
        System.out.println();

        System.out.println("Afisare 2");
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
	}

}
