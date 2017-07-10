package lab1;

import java.util.*;

public class Prob8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] array = new double[10];
		for (int i = 0; i < 10; ++i)
		{
			array[i] = 10 * Math.random();
		}
		System.out.printf("Unsorted\n");
		for (int i = 0; i < 10; ++i)
		{
			System.out.println(array[i]);
		}
		Arrays.sort(array);
		System.out.printf("Sorted\n");
		for (int i = 0; i < 10; ++i)
		{
			System.out.println(array[i]);
		}
		System.out.printf("Binary search:\n");
		for (int i = 0; i < 10; ++i)
		{
			System.out.println(Arrays.binarySearch(array, array[i]));
		}
	}

}
