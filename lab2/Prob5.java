package lab2;

public class Prob5 {

	public static String codify (String one, String[] two)
	{
		int n = two.length;
		String result = "";
		for (int i = 0; i < n; ++i)
		{
			if (Prob2.apparitions_1(one, two[i]) == 1)
				System.out.println("Text suspect");
			else
				System.out.println("Nimic suspect");
			int k = two[i].length();
			StringBuilder plm = new StringBuilder();
			for (int j = 0; j < k - 2; ++j)
				plm.append("*");
			String kek = two[i].substring(0, 1)  + plm.toString() + two[i].substring(k - 1);
			result = result + kek + " ";
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Un terorist avea o bomba";
		String[] cuvinte = new String[3];
		cuvinte[0] = "terorist";
		cuvinte[1] = "bomba";
		cuvinte[2] = "allah";
		String rezultat = codify(text, cuvinte);
		System.out.println(rezultat);

	}

}
