package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_11048_이동하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + sc.nextInt();
			}
		}
		
		System.out.println(dp[N][M]);		
		sc.close();
	}
}
