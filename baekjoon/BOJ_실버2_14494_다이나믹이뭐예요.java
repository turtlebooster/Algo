package baekjoon;

import java.util.Scanner;

public class BOJ_실버2_14494_다이나믹이뭐예요 {
	private static final int MOD = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] dp = new int[n + 1][m + 1];		
		dp[0][0] = 1;		
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = ((dp[i][j - 1] + dp[i - 1][j]) % MOD + dp[i - 1][j - 1]) % MOD;					
			}
		}
		
		System.out.println(dp[n][m]);
		sc.close();
	}
}
