package lab13;

import java.util.*;

public class ListUtil {
    public static <A, B> A foldl(Function<A, Function<B, A>> function, A acc, List<B> xs) {
    	A z = acc;
    	for (B x : xs)
    		z = function.execute(z).execute(x);
        return z;
    }

    
	public static <A> void reverse(List<A> xs) {
    	List <A> copy = new ArrayList<>();
    	ListIterator<A> iter =  xs.listIterator(xs.size());
    	while (iter.hasPrevious())
    		copy.add((A)iter.previous());
    	xs.removeAll(xs);
    	xs.addAll(copy);
    }

    public static <A, B> A foldr(Function<A, Function<B, A>> function, A acc, List<B> xs) {
    	reverse(xs);
    	return foldl(function, acc, xs);
    }

	public static <A, B> List<B> map(Function<A, B> function, List<A> xs) {
    	ListIterator<A> iter = xs.listIterator();
    	List<B> listing = new ArrayList<>();
    	while (iter.hasNext())
    	{
    		listing.add(function.execute(iter.next()));
    	}
        return listing;
    }

    
	public static <A> List<A> filter(Function<A, Boolean> function, List<A> xs) {
    	ListIterator <A> iter = xs.listIterator();
    	List <A> list = new ArrayList<>();
    	if (function == null)
    		return xs;
    	while (iter.hasNext())
    	{
    		A item = (A) iter.next();
    		if (function.execute(item))
    			list.add(item);
    	}
        return list;
    }

    
	public static <A> A reduce(Function<A, Function<A, A>> function, List<A> xs) {
    	A result = xs.get(0);
    	List <A> copy = new ArrayList<>();
    	copy.addAll(xs);
    	copy.remove(0);
    	ListIterator<A> iter = copy.listIterator();
    	while (iter.hasNext())
    	{
    		result = function.execute(result).execute(iter.next());
    	}
        return result;
    }

    public static <A> boolean all(Function<A, Boolean> function, List<A> xs) {
    	boolean ok = true;
    	ListIterator<A> iter = xs.listIterator();
    	while (iter.hasNext())
    	{
    		if (!function.execute(iter.next()))
    			ok = false;
    	}
        return ok;
    }

    public static <A> boolean any(Function<A, Boolean> function, List<A> xs) {
    	boolean ok = false;
    	ListIterator <A> iter = xs.listIterator();
    	while (iter.hasNext())
    	{
    		if (function.execute(iter.next()))
    			ok = true;
    	}
        return ok;
    }

    public static <A extends Number> A sum(List<A> xs, Addition<A> operation) {
    	
    	A result = operation.zero();
    	ListIterator<A> iter = xs.listIterator();
    	while (iter.hasNext())
    	{
    		result = operation.add(result, iter.next());
    	}
        return result;
    }
}
