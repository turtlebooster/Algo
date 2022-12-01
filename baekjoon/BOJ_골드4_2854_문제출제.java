package baekjoon;

import java.util.Scanner;

public class BOJ_골드4_2854_문제출제 {
	static final int MOD = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N + 1];
		int[] B = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		
		for (int i = 1; i < N; i++) {
			B[i] = sc.nextInt();
		}
		
		long[][] dp = new long[N + 1][2];
		dp[0][0] = 1L;
		
		for (int i = 1; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] * (A[i] + B[i - 1]) + dp[i - 1][1] * (A[i] + B[i - 1] - 1) ) % MOD;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) * B[i] % MOD;
		}
		
		System.out.println(dp[N][0] % MOD);
		sc.close();
	}
}
