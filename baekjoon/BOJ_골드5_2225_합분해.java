package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_2225_합분해 {
	static final int MOD = 1_000_000_000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// dp[i][j]: j 개의 수를 사용하여 합이 i가 되는 경우의 수
		int[][] dp = new int[N + 1][K + 1];
		
		// 1 개의 수를 사용하여 i를 만드는건 자기 자신뿐
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}
		// j개의 수로 0을 만드는 경우는 항상 1가지
		for (int j = 0; j <= K; j++) {
			dp[0][j] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= K; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
			}
		}
		System.out.println(dp[N][K]);
		sc.close();
	}
}
