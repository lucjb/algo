package org.cronopios.training.codility.prefixsums;
public class PassingCars {

	public int solution(int[] A) {
		long zeroCount = 0;
		long passCount = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0)
				zeroCount++;
			else
				passCount += zeroCount;
		}
		if (passCount > 1000000000)
			return -1;
		return (int) passCount;

	}
}
