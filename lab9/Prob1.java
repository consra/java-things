package lab9;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

class MyEntry<K, V> implements Map.Entry<K, V> {
    public K key;
    public V value;
    public MyEntry(K key) {
        this.key = key;
    }
    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}

class ArrayMap<K, V> extends AbstractMap<K, V> {
	public Vector <K> keys;
	public Vector <V> values;
	
	public ArrayMap ()
	{
		keys = new Vector<>();
		values = new Vector<> ();
	}
	@Override
	public V put (K key, V value)
	{
		V val = null;
		int ok = 0;
		for (int i = 0; i < keys.size(); ++i)
		{
			if (keys.get(i).equals(key))
			{
				val = values.get(i);
				values.remove(i);
				ok = 1;
			}
		}
		if (ok == 0)
		{
			keys.add(key);
			values.add(value);
		}
		return val;
	}
	
	public boolean isEmpty()
	{
		return values.isEmpty();
	}
	
	public void clear()
	{
		values.clear();
		keys.clear();
	}
	
	public int size()
	{
		return values.size();
	}
	
	public V get (Object key)
	{
		V value = null;
		for (int i = 0; i < values.size(); ++i)
		{
			if (keys.get(i).equals(key))
			{
				value = values.get(i);
			}
		}
		return value;
	}
	
	public Set <K> keySet() {
		Set<K> things = new TreeSet<>();
		things.addAll(keys);
		return things;
	}
	
	public Collection <V> values ()
	{
		Collection <V> valori = new Vector<>();
		valori.addAll(values);
		return valori;
	}
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> mapping = new TreeSet<>();
		for (int i = 0; i < keys.size(); ++i)
		{
			Map.Entry<K, V> entry = new MyEntry<>(keys.get(i), values.get(i));
			mapping.add(entry);
		}
		return mapping;
	}
	
	public String toString ()
	{
		String result = "";
		for (int i = 0; i < keys.size(); ++i)
		{
			result = result + "#" + (i + 1) + "\nValue: " + values.get(i) + "\n" + "Key: " + keys.get(i) + "\n\n";
		}
		return result;
	}
	
}

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayMap <String, String> map = new ArrayMap<>();
		map.put("plm", "kek");
		map.put("pederast", "ialapula");
		System.out.println(map);
		TreeSet<String> hashing = (TreeSet<String>) map.keySet();
		Iterator<String> iterate = hashing.iterator();
		while (iterate.hasNext())
			System.out.println(iterate.next());
	}

}
