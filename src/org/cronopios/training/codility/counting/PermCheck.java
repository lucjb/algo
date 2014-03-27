package org.cronopios.training.codility.counting;
public class PermCheck {

	public int solution(int[] A) {
		// write your code in Java SE 7
		int[] counts = new int[A.length];
		for (int x : A) {
			if (x < 1 || x > A.length)
				return 0;
			counts[x - 1]++;
		}
		for (int c : counts) {
			if (c != 1)
				return 0;
		}
		return 1;
	}

}
