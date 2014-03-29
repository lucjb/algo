package org.cronopios.training.codility.prefixsums;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. A pair of
 * integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A
 * (notice that the slice contains at least two elements). The average of a
 * slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length
 * of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... +
 * A[Q]) / (Q − P + 1). For example, array A such that: A[0] = 4 A[1] = 2 A[2] =
 * 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 contains the following example slices:
 * slice (1, 2), whose average is (2 + 2) / 2 = 2; slice (3, 4), whose average
 * is (5 + 1) / 2 = 3; slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is
 * minimal. Write a function: int solution(int A[], int N); that, given a
 * non-empty zero-indexed array A consisting of N integers, returns the starting
 * position of the slice with the minimal average. If there is more than one
 * slice with a minimal average, you should return the smallest starting
 * position of such a slice. For example, given array A such that: A[0] = 4 A[1]
 * = 2 A[2] = 2 A[3] = 5 A[4] = 1 A[5] = 5 A[6] = 8 the function should return
 * 1, as explained above. Assume that: N is an integer within the range
 * [2..100,000]; each element of array A is an integer within the range
 * [−10,000..10,000]. Complexity: expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not
 * counting the storage required for input arguments). Elements of input arrays
 * can be modified.
 * 
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
