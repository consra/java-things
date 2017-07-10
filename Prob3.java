package lab1;
import java.util.*;

class One {
	public static void print (String kek)
	{
		System.out.println(kek);
	}
}

public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		String kek = scan.nextLine();
		One.print(kek);
		scan.close();
	}

}
