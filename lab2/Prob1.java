package lab2;

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		String s1 = "si";
		String s = "sir1 si cu sir2 fac un sir3";
		int index = s.indexOf(s1);
		while (index != -1)
		{
			count++; 
			s = s.substring(index + 1);
			index = s.indexOf(s1);
		}
		System.out.println("Numarul de aparitii al sirului s1 in s este: " + count);
	}

}
