
class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }
}

class Paralelogram extends Patrulater {
	public Paralelogram (int latura1, int latura2, double unghi1, double unghi2)
	{
		super(latura1, latura2, latura1, latura2, unghi1, unghi2, unghi1, unghi2);
	}
	
	public double Arie ()
	{
		double suprafata = (double) latura1 * (double) latura2 * Math.sin(Math.toRadians(unghi1));
		return suprafata;
	}
	
}

class Dreptunghi extends Paralelogram {
	public Dreptunghi (int latura1, int latura2)
	{
		super(latura1, latura2, 90, 90);
	}
	
	public double Arie ()
	{
		double suprafata = (double) (latura1 * latura2);
		return suprafata;
	}
}

class Romb extends Paralelogram {
	int diagonala1, diagonala2;
	
	public Romb (int latura, int diagonala1, int diagonala2, double unghi1, double unghi2) {
		super(latura, latura, unghi1, unghi2);
		this.diagonala1 = diagonala1;
		this.diagonala2 = diagonala2;
	}
	
	public double Arie ()
	{
		double suprafata = (double)(diagonala1 * diagonala2) / 2;
		return suprafata;
	}
	
}

class Patrat extends Dreptunghi {
	public Patrat (int latura)
	{
		super (latura, latura);
	}
	
	public double Arie ()
	{
		double suprafata = (double) (latura1 * latura2);
		return suprafata;
	}
}

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paralelogram kek = new Paralelogram (3, 4, 30, 150);
		System.out.print(kek.Arie());
		

	}

}
