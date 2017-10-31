package lab8;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class ArrayMap <K, V> extends AbstractMap<K, V>{
	
	@SuppressWarnings("hiding")
	class ArrayMapEntry<K, V> implements Map.Entry<K, V> {
		public K key;
		public V value;
		
		public ArrayMapEntry (K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		@Override
		public K getKey()
		{
			return this.key;
		}
		
		@Override
		public V getValue()
		{
			return this.value;
		}
		
		 @Override
		 public V setValue(V value) 
		 {
		    V old = this.value;
		    this.value = value;
		    return old;
		 }
		 
		 public String toString ()
		 {
			 String result = "Value: " + this.value + "\nKey: " + this.key;
			 return result;
		 }
		 
		 public int hashCode ()
		 {
			 return (this.getKey()==null   ? 0 : this.getKey().hashCode()) ^
				     (this.getValue()==null ? 0 : this.getValue().hashCode());
		 }
		 
		 @SuppressWarnings("unchecked")
		public boolean equals(Object other){
			 ArrayMapEntry<K, V> o = (ArrayMapEntry<K, V>) other;
			    if (this.getKey()==null ?
			    	      o.getKey()==null : this.getKey().equals(o.getKey())  &&
			     (this.getValue()==null ?
			      o.getValue()==null : this.getValue().equals(o.getValue())))
			    	return true;
			    return false;
			}}
		
		 public ArrayList <ArrayMapEntry<K, V>> list;
		 public ArrayMap ()
		 {
			 list = new  ArrayList <ArrayMapEntry<K, V>>();
		 }
		 public int size ()
		 {
			 return list.size();
		 }
		 
		 public Set<ArrayMapEntry<K, V>> entrySet1()
		 {
			 Set<ArrayMapEntry<K, V>> things = new TreeSet<>();
			 for (int i = 0; i < this.list.size(); ++i)
				 things.add(this.list.get(i));
			 return things;
		 }
		 
		 
		 public V put (K key, V value)
		 {
			 ArrayMapEntry<K, V> obj = new ArrayMapEntry<>(key, value);
			 this.list.add(obj);
			 return (V) obj.getValue();
		 }
	

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString ()
	{
		return "kke";
	}
	
	
}

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayMap<Integer, String> map = new ArrayMap<>();

        System.out.println("Populam colectia...");
        map.put(7, "Colectii si genericitate");
        map.put(8, "Clase interne");
        map.put(5, "Fluxuri");

        System.out.println("Verificam...");
        System.out.println("Continutul colectiei: " + map);

        if (map.size() != 3) {
            System.err.println("ArrayMap.size() (" + map.size() + ") a fost implementata gresit.");
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        if (entries.size() != 3) {
            System.err.println("ArrayMap.entrySet() a fost implementata gresit.");
        }

        for (Map.Entry<Integer, String> e : entries) {
            map.put(e.getKey(), new StringBuffer(e.getValue()).reverse().toString());
            if (!map.entrySet().contains(e)) {
                System.err.println("ArrayMap.put() nu inlocuieste vechea valoare.");
            }
            if ((!e.toString().contains(e.getKey().toString()) || (!e.toString().contains(e.getValue())))) {
                System.err.println("ArrayMap.ArrayMapEntry.toString() a fost implementata gresit.");
            }
        }

        for (Map.Entry<Integer, String> e1 : entries) {
            for (Map.Entry<Integer, String> e2 : entries) {
                if ((e1 == e2) != (e1.equals(e2))) {
                    System.err.println("ArrayMap.ArrayMapEntry.equals() a fost implementata gresit.");
                }
                if ((e1 == e2) != (e1.hashCode() == e2.hashCode())) {
                    System.err.println("ArrayMap.ArrayMapEntry.hashCode() a fost implementata gresit.");
                }
            }
        }
	}

}
