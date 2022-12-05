package baekjoon;

import java.util.Scanner;

public class BOJ_실버2_11051_이항계수2 {
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		dp = new int[N + 1][K + 1];
		
		System.out.println(comb(N, K));
		
		sc.close();
	}
	
	public static int comb(int n, int r) {		
		if (dp[n][r] > 0) return dp[n][r];	
		
		if (n == r || r == 0) return dp[n][r] = 1;
		else return dp[n][r] = (comb(n - 1, r - 1) % 10007 + comb(n - 1, r) % 10007) % 10007;
	}
}
