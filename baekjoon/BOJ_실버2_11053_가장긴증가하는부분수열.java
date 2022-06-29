package baekjoon;

import java.util.Scanner;

public class BOJ_실버2_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		
		int max = 1;
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[j] >= arr[i]) continue;
				if (dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
			}
			if (max < dp[i]) max = dp[i];
		}
		
		System.out.println(max);
		sc.close();
	}
}
