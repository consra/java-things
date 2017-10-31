package lab8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

class Catalog extends TreeSet<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Catalog ()
	{
		super();
	}
	
	public Catalog (Comparator<Student> comparator)
	{
		super();
	}
	
	class Student implements Comparable<Object> {

		public String name;
		public int clazz;
		public double media;
		
		public Student (String name, double media, int clazz)
		{
			this.name = name;
			this.clazz = clazz;
			this.media = media;
		}
		
		@Override
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			Student std = (Student) arg0;
			if (std.media != this.media)
				return ((int)this.media - (int)std.media);
			else
				return this.name.compareTo(std.name);
			
			}
		}
	
		public void addStudent (String name, double media, int clazz)
		{
			super.add(new Catalog.Student(name, media, clazz));
		}

		public void removeStudent (String name)
		{
			ArrayList<Catalog.Student> removing = new ArrayList<>();
			for (Object kek: this)
			{
				Catalog.Student meh = (Catalog.Student) kek;
				if (meh.name.equals(name))
					removing.add(meh);
			}
			this.removeAll(removing);
		}

		public Catalog byClass(int i) {
			Catalog my_catalog = new Catalog();
			for (Object kek: this)
			{
				Catalog.Student meh = (Catalog.Student) kek;
				if (meh.clazz == i)
					my_catalog.add(meh);
			}
			return my_catalog;
		}

		public Catalog.Student getStudent(String string) {
			// TODO Auto-generated method stub
			for (Object kek: this)
			{
				Catalog.Student meh = (Catalog.Student) kek;
				if (string.equals(meh.name))
					return meh;
			}
			return null;
		}
		
		public String toString ()
		{
			String result = "";
			for (Object meh: this)
			{
				Catalog.Student kek = (Catalog.Student) meh;
				result += "Nume: " + kek.name + "\nClasa: " + kek.clazz + "\nMedie: " + kek.media + "\n\n";
			}
			return result;
		}
		
		public int size ()
		{
			return super.size();
		}
	
}

public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Catalog catalog = new Catalog();
        catalog.addStudent("Alexandru", 7, 324);
        catalog.addStudent("Ioana", 5, 321);
        catalog.addStudent("Maria", 10, 322);
        catalog.addStudent("Ionut", 6.2, 323);
        catalog.addStudent("Diana", 7, 322);
        Catalog catalog2 = new Catalog(new Comparator<Catalog.Student>() {
            @Override
            public int compare(Catalog.Student o1, Catalog.Student o2) {
                // TODO: Sort by average (descending) and by name (ascending).
            	if (o1.media != o2.media)
            		return (int)(o1.media - o2.media);
            	else
            		return o2.name.compareTo(o1.name);
               
            }
        });
        catalog2.addAll(catalog);
        //catalog.forEach(catalog2::add);
	
        System.out.println("Verificam...");
        System.out.println("Continutul colectiei catalog: " + catalog);
        System.out.println("Continutul colectiei catalog2: " + catalog2);

        Catalog.Student last = null;
        for (Object o : catalog) {
            if (last == null) {
                last = (Catalog.Student) o;
                continue;
            }
            Catalog.Student student = (Catalog.Student) o;
            int r = last.media != student.media ? new Double(last.media).compareTo(student.media) : last.name.compareTo(student.name);
            if (r != last.compareTo(o)) {
                System.err.println("Catalog.Student.compareTo a fost implementata gresit.");
            }
        }
        if (catalog.size() != 5) {
            System.err.println("Catalog.size() a fost implementata gresit.");
        }

        catalog.removeStudent("Ionut");
        if (catalog.size() != 4) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }
        catalog.removeStudent("");
        if (catalog.size() != 4) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }

        if (catalog.byClass(322).size() != 2) {
            System.err.println("Catalog.byClass() a fost implementata gresit.");
        }

        catalog.removeStudent("Maria");
        if (catalog.byClass(322).size() != 1) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }

        if (catalog.getStudent("Maria") != null) {
            System.err.println("Catalog.getStudent() a fost implementata gresit.");
        }

        if ((catalog.getStudent("Alexandru") == null) || (catalog.getStudent("Alexandru").media != 7)) {
            System.err.println("Catalog.getStudent() a fost implementata gresit.");

	}

}}
