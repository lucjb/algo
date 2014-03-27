package org.cronopios.training.codility.sorting;
public class MaxProductOfThree {

	public static void main(String[] args) {
		int solution = new MaxProductOfThree().solution(new int[] { 1, -8, -1, -500,
				-2, -3, -4, -100, -100 });
		System.out.println(solution);
	}

	/**
	 * linear solution
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		// write your code in Java SE 7

		int firstMax = -1;
		for (int i = 0; i < A.length; i++) {
			if (firstMax == -1 || A[i] > A[firstMax]) {
				firstMax = i;
			}
		}

		int secondMax = -1;
		for (int i = 0; i < A.length; i++) {
			if (i != firstMax && (secondMax == -1 || A[i] > A[secondMax])) {
				secondMax = i;
			}
		}

		int thirdMax = -1;
		for (int i = 0; i < A.length; i++) {
			if (i != firstMax && i != secondMax
					&& (thirdMax == -1 || A[i] > A[thirdMax])) {
				thirdMax = i;
			}
		}

		int firstMin = -1;
		for (int i = 0; i < A.length; i++) {
			if (i != firstMax && (firstMin == -1 || A[i] < A[firstMin])) {
				firstMin = i;
			}
		}

		int seccondMin = -1;
		for (int i = 0; i < A.length; i++) {
			if (i != firstMax && i != firstMin
					&& (seccondMin == -1 || A[i] < A[seccondMin])) {
				seccondMin = i;
			}
		}

		return (int) Math.max(A[firstMax] * A[secondMax] * A[thirdMax],
				A[firstMax] * A[firstMin] * A[seccondMin]);

	}
}
