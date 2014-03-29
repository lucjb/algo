package org.cronopios.training.codility.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Discs {

	public static void main(String[] args) {
		// int solution = new Discs().solution(new int[] { 1, 5, 2, 1, 4, 0 });
		// int solution = new Discs().solution(new int[] { 1, 1, 1 });
		// int solution = new Discs().solution(new int[] { 1, 0, 1, 0, 1 });
		// int solution = new Discs().solution(new int[] { 3, 3, 3, 5, 1, 2 });
		int solution = new Discs().solution(new int[] { 1, 2147483647, 0 });
		System.out.println(solution);
	}

	public int solution(final int[] A) {
		// write your code in Java SE 7

		Integer[] discs = new Integer[A.length];
		for (int i = 0; i < discs.length; i++) {
			discs[i] = i;
		}

		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				return Integer.compare(x - A[x], y - A[y]);
			}
		};
		Arrays.sort(discs, c);
		long[] starts = new long[A.length];
		for (int i = 0; i < A.length; i++) {
			Integer disc = discs[i];
			starts[i] = disc - A[disc];
		}

		int r = 0;
		for (int i = 0; i < discs.length; i++) {
			Integer disc = discs[i];
			long key = (long) disc + (long) A[disc];
			int count = Arrays.binarySearch(starts, key);
			if (count < 0) {
				count = -count - 1;
			} else {
				while (count < starts.length && starts[count] == key)
					count++;
			}
			count -= i + 1;
			r += count;
			if (r > 10000000)
				return -1;
		}
		return r;

	}
}
