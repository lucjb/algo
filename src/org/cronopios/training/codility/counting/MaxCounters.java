package org.cronopios.training.codility.counting;
public class MaxCounters {

	public static void main(String[] args) {
		int N = 5;
		int[] A = new int[] { 3, 4, 4, 6, 1, 4, 4 };
		int[] solution = new MaxCounters().solution(N, A);
		print(solution);

	}

	private static void print(int[] solution) {
		for (int i : solution) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	public int[] solution(int N, int[] A) {
		// write your code in Java SE 7

		int[] x = new int[N];
		int max = Integer.MIN_VALUE;
		int base = 0;
		for (int e : A) {
			if (e > 0 && e <= N) {
				if (x[e - 1] < base) {
					x[e - 1] = base;
				}
				x[e - 1]++;
				if (x[e - 1] > max) {
					max = x[e - 1];
				}
			} else {
				base = max;
			}
		}

		for (int i = 0; i < N; i++) {
			if (x[i] < base) {
				x[i] = base;
			}
		}
		return x;

	}
}
