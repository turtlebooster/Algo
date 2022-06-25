package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_골드5_2294_동전2 {
	private static final int INF = 10000001;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 동전 종류 수
		int k = sc.nextInt();	// 목표 금액
		
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		
		int[] dp = new int[k + 1];
		
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
		}

		System.out.println(dp[k] == INF ? -1 : dp[k]);		
		sc.close();
	}
}
