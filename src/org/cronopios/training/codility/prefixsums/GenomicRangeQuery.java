package org.cronopios.training.codility.prefixsums;

/**
 * A non-empty zero-indexed string S is given. String S consists of N characters
 * from the set of upper-case English letters A, C, G, T. This string actually
 * represents a DNA sequence, and the upper-case letters represent single
 * nucleotides. You are also given non-empty zero-indexed arrays P and Q
 * consisting of M integers. These arrays represent queries about minimal
 * nucleotides. We represent the letters of string S as integers 1, 2, 3, 4 in
 * arrays P and Q, where A = 1, C = 2, G = 3, T = 4, and we assume that A < C <
 * G < T. Query K requires you to find the minimal nucleotide from the range
 * (P[K], Q[K]), 0 ≤ P[i] ≤ Q[i] < N. For example, consider string S = GACACCATA
 * and arrays P, Q such that: P[0] = 0 Q[0] = 8 P[1] = 0 Q[1] = 2 P[2] = 4 Q[2]
 * = 5 P[3] = 7 Q[3] = 7 The minimal nucleotides from these ranges are as
 * follows: (0, 8) is A identified by 1, (0, 2) is A identified by 1, (4, 5) is
 * C identified by 2, (7, 7) is T identified by 4. Write a function: class
 * Solution { public int[] solution(String S, int[] P, int[] Q); } that, given a
 * non-empty zero-indexed string S consisting of N characters and two non-empty
 * zero-indexed arrays P and Q consisting of M integers, returns an array
 * consisting of M characters specifying the consecutive answers to all queries.
 * The sequence should be returned as: a Results structure (in C), or a vector
 * of integers (in C++), or a Results record (in Pascal), or an array of
 * integers (in any other programming language). For example, given the string S
 * = GACACCATA and arrays P, Q such that: P[0] = 0 Q[0] = 8 P[1] = 0 Q[1] = 2
 * P[2] = 4 Q[2] = 5 P[3] = 7 Q[3] = 7 the function should return the values [1,
 * 1, 2, 4], as explained above. Assume that: N is an integer within the range
 * [1..100,000]; M is an integer within the range [1..50,000]; each element of
 * array P, Q is an integer within the range [0..N − 1]; P[i] ≤ Q[i]; string S
 * consists only of upper-case English letters A, C, G, T. Complexity: expected
 * worst-case time complexity is O(N+M); expected worst-case space complexity is
 * O(N), beyond input storage (not counting the storage required for input
 * arguments). Elements of input arrays can be modified.
 * 
 * @author 1
 * 
 */
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
