package org.cronopios.training.codility.prefixsums;
/**
 * Treak: Given an array A, if subarray S has min avg then exists a sub array of
 * S with also min avg and length 2 or 3. Then checking all subarrays with lenth
 * 2 and 3 suffices to find the start of the min avg subarray in A.
 * 
 * Proof: Given A, consider S a subarray of A such that avg(S)=k is the minimum
 * avg of every subarray in A.
 * 
 * If length(S)=2 or lenght(S)=3, trivial.
 * 
 * If length(S) >3 odd, then we can split S in to one subarray P such that
 * lenght(P)=3 and another subarray Q such that length(Q) is even. Note that if
 * avg(P)= >k, then, avg(Q)<k which is false by hipotesis (no subarray in A has
 * avg<k, since k is minimum). Then avg(Q)=avg(P)=k.
 * 
 * If length(S)> 3 even, then we can split S in several subarrays of lenght 2.
 * If one of these subarrays has avg>k, then there must exist another with
 * avg<k, which is false by hipotesis, then all these subarrays has de same avg
 * = k.
 * 
 * This shows that there must be an optimal subarray with length 2 or 3.
 * 
 * @author lbernardi
 * 
 */
public class MinAvgTwoSlice {

	public static void main(String[] args) {
		// int[] A = new int[] { 2, 2, 1, 2, 1, 2 };
		// int[] A = new int[] { 7, 1, 3, 2, 5, 1, 6, 3 };
		// int[] A = new int[] { 2, 2, 1, 2, 1 };
		int[] A = new int[] { 4, 2, 2, 5, 1, 5, 8 };
		int solution = new MinAvgTwoSlice().solution(A);
		System.out.println(solution);
	}

	public int solution(int[] A) {
		// write your code in Java SE 7

		int minS = -1;
		double minAvg = Double.MAX_VALUE;
		for (int i = 0; i < A.length - 1; i++) {
			double avg = (A[i] + A[i + 1]) / 2d;
			if (avg < minAvg) {
				minS = i;
				minAvg = avg;
			}
			if (i + 2 < A.length) {
				avg = (A[i] + A[i + 1] + A[i + 2]) / 3d;
				if (avg < minAvg) {
					minS = i;
					minAvg = avg;
				}

			}

		}
		return minS;

	}
}
