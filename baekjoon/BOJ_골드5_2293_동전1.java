package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_골드5_2293_동전1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 동전 종류 수
		int k = sc.nextInt();	// 목표 금액
		
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		
		// 작은 순으로 동전 정렬
		Arrays.sort(coins);
		
		int[] dp = new int[k + 1];
		
		// 초기화
		dp[0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				dp[j] += dp[j - coins[i]];
			}
		}
		
		System.out.println(dp[k]);		
		sc.close();
	}
}
