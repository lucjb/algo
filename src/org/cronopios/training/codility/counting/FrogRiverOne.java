package org.cronopios.training.codility.counting;
public class FrogRiverOne {
	public int solution(int X, int[] A) {
		// write your code in Java SE 7

		boolean[] Z = new boolean[X];
		int seenSoFar = 0;
		int t = 0;
		for (; t < A.length && seenSoFar < X; t++) {
			int p = A[t];
			if (!Z[p - 1]) {
				seenSoFar++;
				Z[p - 1] = true;

			}
		}

		if (seenSoFar == X)
			return t-1;
		return -1;

	}

}
