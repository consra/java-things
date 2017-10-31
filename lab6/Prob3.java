package lab6;

import java.util.Collections;
import java.util.Vector;

interface Persoana extends Comparable<Object> {
	public double calculMedieGenerala ();
	public String getNume();
	public void setNume (String nume);
	public void addMedie (double medie);
}

class Student implements Persoana {
	private String name;
	private Vector <Double> medii;
	
	public Student ()
	{
		this.name = "Mocanu cel Gay";
		this.medii = new Vector<> (10);
	}
	
	public Student (String name)
	{
		this.name = name;
		this.medii = new Vector<> (10);
	}
	
	public void addMedie (double medie)
	{
		this.medii.add(medie);
	}
	
	public void setNume (String nume)
	{
		this.name = nume;
	}
	
	public String getNume ()
	{
		return name;
	}
	
	public double calculMedieGenerala()
	{
		double sum = 0;
		for (int i = 0; i < this.medii.size(); ++i)
			sum += this.medii.get(i);
		return sum / (double)this.medii.size();
	}
	@Override
	public int compareTo (Object plm)
	{
		int kek = 0;
		Student x = (Student) plm;
		if (this.name.equals(x.name))
			kek = (int)this.calculMedieGenerala() - (int)x.calculMedieGenerala();
		return kek;
	}
	
}

public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector <Student> vect = new Vector <> (10);
		Student one = new Student ("Mihu poponar");
		one.addMedie(6.9);
		one.addMedie(5.4);
		one.addMedie(1.3);
		vect.add(one);
		Student two = new Student ("Costi fricos");
		two.addMedie(6.2);
		two.addMedie(7.4);
		two.addMedie(8.3);
		vect.add(two);
		Student plm = new Student ("Mihu poponar");
		plm.addMedie(1.9);
		plm.addMedie(3.4);
		plm.addMedie(1.3);
		vect.add(plm);
		Student three = new Student ("Mocanu pederast");
		three.addMedie(5.9);
		three.addMedie(9.4);
		three.addMedie(4.3);
		vect.add(three);
		System.out.println("Inainte de sortare");
		for (int i = 0; i < vect.size(); ++i)
			System.out.println("Nume: " + vect.get(i).getNume() + " Media: " + vect.get(i).calculMedieGenerala());
		Collections.sort(vect);
		System.out.println("Dupa sortare");
		for (int i = 0; i < vect.size(); ++i)
			System.out.println("Nume: " + vect.get(i).getNume() + " Media: " + vect.get(i).calculMedieGenerala());
		
	}

}
