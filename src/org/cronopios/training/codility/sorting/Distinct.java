package org.cronopios.training.codility.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distinct {

	public int solution(int[] A) {
		Set<Integer> s = new HashSet<Integer>();
		for (int i : A) {
			s.add(i);
		}
		return s.size();
	}

	public int solution1(int[] A) {
		if (A.length == 0)
			return 0;
		// write your code in Java SE 7
		Arrays.sort(A);

		int ant = A[0];
		int count = 1;
		for (int i = 0; i < A.length; i++) {
			int j = A[i];
			if (j != ant) {
				count++;
			}
			ant = j;
		}
		return count;
	}
}
