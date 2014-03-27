package org.cronopios.training.codility.prefixsums;
public class GenomicRangeQuery {

	public static void main(String[] args) {
		String S = "AC";
		int[] P = new int[] { 0, 0, 1 };
		int[] Q = new int[] { 0, 1, 1 };
		int[] solution = new GenomicRangeQuery().solution(S, P, Q);
		for (int i : solution) {
			System.out.println(i);
		}
	}

	public int[] solution(String S, int[] P, int[] Q) {
		// write your code in Java SE 7

		int[] aCounts = new int[S.length() + 1];
		int[] cCounts = new int[S.length() + 1];
		int[] gCounts = new int[S.length() + 1];
		int[] tCounts = new int[S.length() + 1];
		int[] r = new int[P.length];

		for (int i = 1; i < S.length() + 1; i++) {
			char c = S.charAt(i - 1);
			aCounts[i] = aCounts[i - 1];
			cCounts[i] = cCounts[i - 1];
			gCounts[i] = gCounts[i - 1];
			tCounts[i] = tCounts[i - 1];
			if (c == 'A') {
				aCounts[i]++;
			}
			if (c == 'C') {	
				cCounts[i]++;
			}
			if (c == 'G') {
				gCounts[i]++;
			}
			if (c == 'T') {
				tCounts[i]++;
			}
		}

		for (int i = 0; i < P.length; i++) {
			int s = P[i];
			int e = Q[i] + 1;
			char charAt = S.charAt(s);
			switch (charAt) {
			case 'A':
				r[i] = 1;
				break;
			case 'C':
				r[i] = 2;
				break;
			case 'G':
				r[i] = 3;
				break;
			case 'T':
				r[i] = 4;
				break;
			}

			if (aCounts[e] - aCounts[s] > 0) {
				r[i] = 1;
				continue;
			}
			if (cCounts[e] - cCounts[s] > 0) {
				r[i] = 2;
				continue;
			}
			if (gCounts[e] - gCounts[s] > 0) {
				r[i] = 3;
				continue;
			}
			if (tCounts[e] - tCounts[s] > 0) {
				r[i] = 4;
				continue;
			}
		}
		return r;
	}
}
