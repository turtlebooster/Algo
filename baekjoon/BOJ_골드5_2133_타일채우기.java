package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_2133_타일채우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 1 ~ 30
		int[] dp = new int[N + 1];
		
		dp[0] = 1;
		if (N >= 2) dp[2] = 3;
		
		for (int i = 4; i <= N; i++) {
			if (i % 2 != 0) continue;
			dp[i] = 3 * dp[i - 2];
			for (int j = i - 4; j >= 0; j -= 2) {
				dp[i] += 2 * dp[j];
			}
		}
		
		System.out.println(dp[N]);
		sc.close();
	}
}
