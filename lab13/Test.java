package lab13;

import java.util.ArrayList;

interface Function <A, B> {
	public B execute (A obj);
}

interface Addition <T extends Number> {
	public T zero ();
	public T add (T a, T b);
}

public class Test {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Math.round((float) Math.random() * 100));
        }
        System.out.println(list);
        
        System.out.println(ListUtil.map(new Function<Integer, Integer>() {
            @Override
            public Integer execute(Integer x) {
                return 2*x;
            }
        }, list));
        
        System.out.println(ListUtil.filter(new Function<Integer, Boolean>() {

			@Override
			public Boolean execute(Integer obj) {
				return (obj % 2 != 1);
			}}, list));
        ListUtil.reverse(list);
        System.out.println(list);
        
        System.out.println(ListUtil.sum(list, new Addition <Integer>() {

			@Override
			public Integer zero() {
				return new Integer (0);
			}

			@Override
			public Integer add(Integer a, Integer b) {
				Integer result = a + b;
				return result;
			}
        	
        }));
        
        Function<Integer,Function<Integer,Integer>> add = new Function<Integer,Function<Integer,Integer>>(){
            @Override
            public Function<Integer,Integer> execute(final Integer a) {
                return new Function<Integer,Integer>(){
                    @Override
                    public Integer execute(Integer b) {
                        return a + b;
                    }
                };
            }
        };
        System.out.println(ListUtil.foldl(add, new Integer(0), list));

        System.out.println(ListUtil.reduce(add, list));

        Function<ArrayList<Integer>,Function<Integer,ArrayList<Integer>>> append = new Function <ArrayList<Integer>,Function<Integer,ArrayList<Integer>>>() {

			@Override
			public Function<Integer, ArrayList<Integer>> execute(ArrayList<Integer> obj) {
				return new Function <Integer, ArrayList<Integer>>() {

					@Override
					public ArrayList<Integer> execute(Integer obj) {
						// TODO Auto-generated method stub
						ArrayList<Integer> kek = new ArrayList <>();
						for (int i = 0; i < 3; ++i)
							kek.add(i * obj);
						return kek;
					}
					
				};
			}
        	
        };
        ArrayList<Integer> feck = new ArrayList<>();
        feck.add(2);
        feck.add(5);
        feck.add(7);
        System.out.println(ListUtil.foldr(append, feck, list));
        
        System.out.println(ListUtil.all(new Function<Integer, Boolean>() {
            @Override
            public Boolean execute(Integer x) {
                return x % 2 == 0;
            }
        }, list));
        System.out.println(ListUtil.any(new Function<Integer, Boolean>() {
            @Override
            public Boolean execute(Integer x) {
                return x % 3 == 1;
            }
        }, list));
    }
}
