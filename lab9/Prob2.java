package lab9;

import java.util.ArrayList;

abstract class AMatrix<T extends Number> extends ArrayList<ArrayList<T>> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public abstract AMatrix<T> addition(AMatrix<T> m1);
    public abstract String toString();
    public abstract T add(T obj1, T obj2);
}

@SuppressWarnings("rawtypes")
class IntegerMatrix<T> extends AMatrix {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntegerMatrix ()
	{
		super();
	}
	
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public IntegerMatrix addition(AMatrix m1) {
		// TODO Auto-generated method stub
		IntegerMatrix<Number> kek = new IntegerMatrix<>();
		for (int i = 0; i < m1.size(); ++i)
		{
			ArrayList <Number> plm = new ArrayList<>();
			for (int j = 0; j < ((ArrayList<?>) m1.get(i)).size(); ++j)
			{
				Number one = (Number)((ArrayList<?>) m1.get(i)).get(j);
				Number two = (Number)((ArrayList<?>) this.get(i)).get(j);
				Number result = add(one, two);
				plm.add(result);
			}
			kek.add(plm);
		}
		return kek;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		for (int i = 0; i < this.size(); ++i)
		{
			for (int j = 0; j < ((ArrayList<?>) this.get(i)).size(); ++j)
				result = result + ((ArrayList<?>) this.get(i)).get(j) + " ";
			result += "\n";
		}
		return result;
	}

	@Override
	public Number add(Number one, Number two) {
		if (one.getClass() == Integer.class) {
	        // With auto-boxing / unboxing
	        return (Number) ((Integer) one + (Integer) two);
	    }
	    if (one.getClass() == Long.class) {
	        // Without auto-boxing / unboxing
	        return (Number) Long.valueOf(((Long) one).longValue() + 
	                                ((Long) two).longValue());
	    }
	    return null;

	}

	
}

public class Prob2 {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
        IntegerMatrix<?> matrix1 = new IntegerMatrix<>();
        IntegerMatrix<?> matrix2 = new IntegerMatrix<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> line1, line2;
            line1 = new ArrayList<>();
            line2 = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                line1.add(Math.round((float) (Math.random() * 100.0)));
                line2.add(Math.round((float) (Math.random() * 100.0)));
            }
            matrix1.add(line1);
            matrix2.add(line2);
        }
        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix1.addition(matrix2));
    }
}
