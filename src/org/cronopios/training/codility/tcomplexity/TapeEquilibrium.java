package org.cronopios.training.codility.tcomplexity;


public class TapeEquilibrium {

	public static void main(String[] args) {
		int solution = new TapeEquilibrium().solution(new int[] { 1, 2000 });
		System.out.println(solution);

	}

	public int solution(int[] A) {
		int t = 0;
		for (int i : A) {
			t += i;
		}

		int s = 0;
		int minr = Integer.MAX_VALUE;
		for (int i = 0; i < A.length - 1; i++) {
			s += A[i];
			int r = Math.abs(2 * s - t);
			if (r < minr) {
				minr = r;
			}
		}
		return minr;
	}
}
