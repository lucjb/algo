package org.cronopios.training.codility.tcomplexity;


public class FrogJmp {
	
	public int solution(int X, int Y, int D) {
		// write your code in Java SE 7
		int a = Y - X;
		int steps = a / D;
		if (a % D != 0)
			steps++;
		return steps;
	}
}
