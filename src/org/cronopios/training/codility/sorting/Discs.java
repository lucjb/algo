package org.cronopios.training.codility.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array A of N integers, we draw N discs in a 2D plane such that the
 * I-th disc is centered on (0,I) and has a radius of A[I]. We say that the J-th
 * disc and K-th disc intersect if J ≠ K and J-th and K-th discs have at least
 * one common point. Write a function: class Solution { public int
 * solution(int[] A); } that, given an array A describing N discs as explained
 * above, returns the number of pairs of intersecting discs. For example, given
 * N=6 and: A[0] = 1 A[1] = 5 A[2] = 2 A[3] = 1 A[4] = 4 A[5] = 0 intersecting
 * discs appear in eleven pairs of elements: 0 and 1, 0 and 2, 0 and 4, 1 and 2,
 * 1 and 3, 1 and 4, 1 and 5, 2 and 3, 2 and 4, 3 and 4, 4 and 5. so the
 * function should return 11. The function should return −1 if the number of
 * intersecting pairs exceeds 10,000,000. Assume that: N is an integer within
 * the range [0..100,000]; each element of array A is an integer within the
 * range [0..2147483647]. Complexity: expected worst-case time complexity is
 * O(N*log(N)); expected worst-case space complexity is O(N), beyond input
 * storage (not counting the storage required for input arguments). Elements of
 * input arrays can be modified.
 * 
 * @author 1
 * 
 */
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
