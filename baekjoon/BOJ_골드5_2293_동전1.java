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
		dp[coins[0]] = 1;
		
		
		for (int i = coins[0]; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				if (i - coins[j] < coins[0]) continue;
				dp[i] += dp[i - coins[j]];				
			}			
		}
		
		System.out.println(dp[k]);
		
		sc.close();
	}
}
