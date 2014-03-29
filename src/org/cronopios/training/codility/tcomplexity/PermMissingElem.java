package org.cronopios.training.codility.tcomplexity;

/**
 * A zero-indexed array A consisting of N different integers is given. The array
 * contains integers in the range [1..(N + 1)], which means that exactly one
 * element is missing. Your goal is to find that missing element. Write a
 * function: int solution(int A[], int N); that, given a zero-indexed array A,
 * returns the value of the missing element. For example, given array A such
 * that: A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it
 * is the missing element. Assume that: N is an integer within the range
 * [0..100,000]; the elements of A are all distinct; each element of array A is
 * an integer within the range [1..(N + 1)]. Complexity: expected worst-case
 * time complexity is O(N); expected worst-case space complexity is O(1), beyond
 * input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 * 
 * @author 1
 * 
 */
public class PermMissingElem {

	public static void main(String[] args) {
		int N = 40000000;
		int[] A = new int[N];
		for (int i = 2; i <= N + 1; i++) {
			A[i - 2] = i;
		}
		int solution = new PermMissingElem().solution(A);
		System.out.println(solution);
	}

	public int solution(int[] A) {
		long t = 0;
		for (int i : A) {
			t += i;
		}
		long n = A.length + 2;
		return (int) (n * ((n - 1) / 2d) - t);

	}
}
