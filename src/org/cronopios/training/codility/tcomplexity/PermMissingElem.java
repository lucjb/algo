package org.cronopios.training.codility.tcomplexity;


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
