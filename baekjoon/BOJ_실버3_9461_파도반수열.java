package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_9461_파도반수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		long[] P = new long[101];
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;	
		
		for (int i = 4; i < 101; i++) {
			P[i] = P[i - 3] + P[i - 2];			
		}
		
		
		for (int t = 1; t <= T; t++) {
			
			System.out.println(P[sc.nextInt()]);
			
		}
		
		sc.close();
	}
}
