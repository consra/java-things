package lab8;

import java.util.Vector;

class Table {
	
	public Vector<Vector<Object>> list;
	
	public Table (Object rows[][])
	{
		list = new Vector<Vector<Object>> ();
		for (int i = 0; i < rows.length; ++i)
		{
			Vector <Object> kek = new Vector <Object>();
			for (int j = 0; j < rows[i].length; ++j)
			{
				kek.add(rows[i][j]);
			}
			list.add(kek);
		}
	}
	
	class CsvPrinter
	{
		public String toString ()
		{
			String result = "";
			for (int i = 0; i < list.size(); ++i)
			{
				for (int j = 0; j < list.get(i).size(); ++j)
				{
					result = result + list.get(i).get(j);
					if (j != list.get(i).size() - 1)
						result += ",";
				}
				result += "\n";
			}
			return result;
		}
	}
	
	class AsciiPrinter 
	{
		public Vector<Integer> vect;
		
		public AsciiPrinter(int array[])
		{
			vect = new Vector<Integer>();
			for (int i = 0; i < array.length; ++i)
				vect.add(array[i]);
		}
		
		public String toString ()
		{
			String result = "";
			for (int i = 0; i < list.size(); ++i)
			{
				result = result + list.get(i).get(0) + "| " + list.get(i).get(1); 
				int one = vect.get(1) - list.get(i).get(1).toString().length();
				result = result + String.format("%" + one + "s", " ") + "| ";
				one = vect.get(2) - list.get(i).get(2).toString().length() - 5;
				result = result + list.get(i).get(2) + String.format("%" + one + "s", " ") + "| ";
				one = vect.get(3) - list.get(i).get(3).toString().length() + 1;
				result = result + list.get(i).get(3) + String.format("%" + one + "s", " ") + "| ";
				one = vect.get(4) - list.get(i).get(4).toString().length();
				result = result + list.get(i).get(4) + String.format("%" + one + "s", " ") + "| ";
				if (i != list.size() - 1)
					result += "\n";
			}
			return result;
		}
	}
	
	void print (Object o)
	{
		System.out.println(o);
	}
}

public class Prob4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object rows[][] = new Object[][] {
            {"#", "Materie", "An", "Semestru", "Credite"},
            {1, "Programarea calculatoarelor", 1, 1, 6},
            {2, "Structuri de date", 1, 2, 6},
            {3, "Programare Orientata pe Obiecte", 2, 1, 6},
		};
    	Table t = new Table(rows);
    	t.print(t.new CsvPrinter());
    	t.print(t.new AsciiPrinter(new int[] {2, 32, 8, 8, 8}));
	}

}