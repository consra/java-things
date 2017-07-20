import java.util.Hashtable;

class HSet extends Hashtable {
	Hashtable <String, String> table;
	int size;
	public HSet ()
	{
		this.table = new Hashtable <>(100);
		this.size = 0;
	}
	
	public void add (String value, String key)
	{
		
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
