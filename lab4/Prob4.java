//import java.util.Hashtable;
import java.util.Vector;

class Person {
	String name, address;
	
	public Person(String nume, String adresa)
	{
		this.name = nume;
		this.address = adresa;
	}
	
	public void setAddress (String adresa)
	{
		this.address = adresa;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String toString()
	{
		String result = "Nume: " + name + "\nAdresa: " + address;
		return result;
	}
}

class Student extends Person {
	int numCourses;
	Vector <String> courses;
	Vector <Integer> grades;
	public Student (String nume, String adresa)
	{
		super(nume, adresa);
		this.courses = new Vector<> (20);
		this.grades = new Vector<> (20);
		this.numCourses = 0;
	}
	
	public void addCourseGrade (String course, int grade)
	{
		this.courses.add(course);
		this.grades.add(grade);
		this.numCourses++;
	}
	
	public String toString ()
	{
		String result = "";
		for (int i = 0; i < courses.size(); ++i)
			result += "Materie: " + courses.get(i) + " - Nota: " + grades.get(i) + "\n";
		return result;
	}
	
	public void printGrades()
	{
		for (int i = 0; i < courses.size(); ++i)
			System.out.println("Materie: " + courses.get(i) + " - Nota: " + grades.get(i));
	}
	
	public double getAverageGrade ()
	{
		int sum = 0;
		for (int i = 0; i < grades.size(); ++i)
			sum += grades.get(i);
		double average = (double) sum / (double) grades.size();
		return average;
	}
}

class Teacher extends Person {
	int numCourses;
	Vector <String> courses;
	public Teacher (String nume, String adresa)
	{
		super(nume, adresa);
		this.numCourses = 0;
		courses = new Vector <> (10);
	}
	
	public boolean addCourse (String course)
	{
		if (this.courses.contains(course))
			return false;
		else
		{
			this.courses.add(course);
			return true;
		}
	}
	
	public boolean removeCourse (String course)
	{
		if (this.courses.contains(course))
		{
			this.courses.remove(course);
			return true;
		}
		else
			return false;
	}
	
	public String toString ()
	{
		String result = "";
		for (int i = 0; i < courses.size(); ++i)
			result += "Materie: " + courses.get(i) + "\n";
		return result;
	}
}

public class Prob4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person student, teacher, person;
        student = new Student("Popescu Ion", "Bucuresti");
        teacher = new Teacher("Ionescu Gigel", "Bucuresti");
        person = new Person("Maria", "Iasi");
        assert (person.getName().equals("Maria")) : "Metoda getName din clasa Person nu este implementata corect";
        assert (((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Algoritmica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Matematica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).removeCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        ((Student) student).addCourseGrade("Programare", 10);
        ((Student) student).addCourseGrade("Algoritmica", 9);
        ((Student) student).addCourseGrade("Matematica", 8);
        assert (Math.abs(((Student) student).getAverageGrade() - 9.00) <= 0.001) : "Metoda getAverageGrade din clasa " +
                "Student nu a fost implementat corect";
        ((Student) student).printGrades();
        //Ce metoda toString se va apela? Din ce clasa?
        System.out.println(student);
        System.out.println(person);
        System.out.println("Felicitari! Problema a fost rezolvata corect!");

	}

}
