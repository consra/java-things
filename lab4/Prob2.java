import java.util.Collections;
import java.util.Vector;

class Array {
    //Vectorul in care se vor retine elementele
    public Vector<Integer> vector;

    //Constructor clasei
    public Array() {
        //Instantierea vectorului cu elemente
        this.vector = new Vector<>();
    }

    //Metoda care adauga un element in vector, folosind pozitia curenta
    public void addElement(Integer x) {
        this.vector.add(x);
    }

    //Metoda care adauga un element in vector, tinand cont de pozitia indicata
    public void addElement(Integer x, int poz) {
        if(poz >= 0 && poz <= vector.size()) {
            this.vector.add(poz, x);
        }
    }

    //Metoda care returneaza elementul aflat in vector la pozitia indicata
    public int get(int poz) {
        int result;
        if(poz >= 0 && poz < vector.size()) {
            result = (int) this.vector.get(poz);
            return result;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    //Metoda ce intoarce numarul de elemente din vector
    public int getSize() {
        return this.vector.size();
    }

    //Metoda pentru stergerea unui element din vector
    public boolean remove(Integer x) {
        return this.vector.remove(x);
    }

    //Metoda pentru stergerea elementului de pe pozitia pos din vector
    public Integer remove(int pos) {
        return this.vector.remove(pos);
    }

    //Metoda uzitata pentru afisarea unui obiect de tip Array
    public String toString() {
        String result = "{";
        for(int i = 0; i < this.vector.size(); i++) {
            result += this.get(i) + ", ";
        }
        result += "}";
        return result;
    }
	
	public void sort() {
		Collections.sort(vector);
	}}

class SortedArray extends Array {
	public SortedArray ()
	{
		super();
	}
	
	public void addElement(Integer x) {
        this.vector.add(x);
        Collections.sort(this.vector);
    }
	
	public void addElement(Integer x, int poz) {
        if(poz >= 0 && poz <= vector.size()) {
            this.vector.add(poz, x);
        }
        Collections.sort(this.vector);
    }
	
	public boolean remove(Integer x) {
		boolean kek = this.vector.remove(x);
		Collections.sort(this.vector);
        return kek;
    }

    //Metoda pentru stergerea elementului de pe pozitia pos din vector
    public Integer remove(int pos) {
    	int kek = this.vector.remove(pos);
    	Collections.sort(this.vector);
        return kek;
    }
}

class Stack {
	public Array vect;
	
	public Stack ()
	{
		this.vect = new Array();
	}
	
	public void push (int x)
	{
		this.vect.addElement(x);
	}
	
	public int pop ()
	{
		int last = vect.getSize() - 1;
		return vect.remove(last);
	}
}

public class Prob2 {

	public static void main (String[] args) {
		// TODO Auto-generated method stub
		SortedArray meh = new SortedArray();
		meh.addElement(69);
		meh.addElement(34);
		meh.addElement(90);
		System.out.print(meh.toString());
		meh.addElement(40, 0);
		System.out.print(meh.toString());
		
		Stack stiva = new Stack();
		stiva.push(56);
		stiva.push(69);
		stiva.push(420);
		System.out.println(stiva.vect.toString());
		stiva.pop();
		System.out.println(stiva.vect.toString());
	}

}
