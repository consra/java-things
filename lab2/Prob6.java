package lab2;

import java.util.Vector;

public class Prob6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector vect = new Vector();
		vect.add(69.69);
		vect.add("mocanu ia la pula");
		vect.add(true);
		vect.add('c');
		vect.add(420);
		for (int i = 0; i < vect.size(); ++i)
			System.out.println(vect.get(i).getClass());
	}

}
