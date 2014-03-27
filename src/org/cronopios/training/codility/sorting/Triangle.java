package org.cronopios.training.codility.sorting;
import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		int solution = new Triangle().solution(new int[] { 2147483647,
				2147483647, 1 });
		System.out.println(solution);
	}

	public int solution(int[] A) {
		// write your code in Java SE 7
		Arrays.sort(A);

		for (int i = A.length - 1; i >= 2; i--) {
			if (A[i - 1] + A[i - 2] - A[i] > 0)
				return 1;
		}
		return 0;
	}
}
