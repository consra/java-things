import java.util.Hashtable;

class HSet extends Hashtable {
	private static final long serialVersionUID = 1L;

	public HSet ()
	{
		super();
	}
	
	@SuppressWarnings("unchecked")
	public boolean add (Object value, Object key)
	{
		boolean ok = false;
		if (!super.contains(value))
			{
				super.put(key, value);
				ok = true;
			}
		return ok;
		
	}
	public int size ()
	{
		return super.size();
	}
	
	public String toString()
	{
		return super.toString();
	}
	
	public Object remove (Object key) {
		return super.remove(key);
	}
	
	public boolean remove (Object key, Object value) {
		return super.remove(key, value);
	}
}


public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HSet set = new HSet();
        set.add("Laborator", "Laborator");
        set.add("Agregare", "Agregare");
        set.add("Mostenire", "Mostenire");
        System.out.println(set);
        System.out.println(set.size());
        set.add("Laborator", "Laborator");
        if(set.size() == 4) {
            System.out.println("Multimea nu trebuie sa contina duplicate!");
        }
        System.out.println(set.remove("POO", "POO"));
        System.out.println(set.remove("Laborator", "Laborator"));
        System.out.println(set.remove("Polimorfism"));
        if(set.size() != 2) {
            System.out.println("Stergerea nu functioneaza!");
        }
        set.add("Supradefinire", "Supradefinire");
        set.add("Supraincarcare", "Supraincarcare");
        System.out.println(set);
	}

}
