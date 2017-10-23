/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.Hashtable;

/**
 *
 * @author Asus ROG
 */

class HSet extends Hashtable {
	public HSet ()
	{
            super();
	}
	
	public boolean add (Object value)
	{
            boolean ok = false;
            if (!super.contains(value))
            {
                super.put(value, value);
                ok = true;
            }
            return ok;
		
	}
        @Override
	public int size ()
	{
            return super.size();
	}
	
        @Override
	public String toString()
	{
            return super.toString();
	}
	
        @Override
	public Object remove (Object key) {
            return super.remove(key);
	}
}


public class Prob3_2017 {

	public static void main(String[] args) {
	HSet set = new HSet();
        set.add("Laborator");
        set.add("Agregare");
        set.add("Mostenire");
        System.out.println(set);
        System.out.println(set.size());
        set.add("Laborator");
        if(set.size() == 4) {
            System.out.println("Multimea nu trebuie sa contina duplicate!");
        }
        System.out.println(set.remove("POO"));
        System.out.println(set.remove("Laborator"));
        if(set.size() != 2) {
            System.out.println("Stergerea nu functioneaza!");
        }
        set.add("Supradefinire");
        set.add("Supraincarcare");
        System.out.println(set);
	}

}
