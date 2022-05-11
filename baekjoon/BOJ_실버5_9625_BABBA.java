package baekjoon;

import java.util.Scanner;

public class BOJ_실버5_9625_BABBA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		int A = 1;
		int B = 0;
		int nA, nB;
		for (int i = 0; i < K; i++) {
			nA = B;
			nB = A + B;
			
			A = nA;
			B = nB;
		}
		
		System.out.println(A + " " + B);
		sc.close();
	}
}
