package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_17070_파이프옮기기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 벽 체크
		boolean[][] wall = new boolean[N + 1][N + 1];		
		wall[0][0] = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sc.nextInt() == 1) {
					wall[i][j] = true;
				}
			}
		}
		
		// dp[i][j][k]: i, j를 끝점으로하고 k방향으로 도착하는 방법의 수
		// k 방향: 0 - 가로, 1 - 세로, 2 - 대각선 
		int[][][] dp = new int[N + 1][N + 1][3];
		dp[0][1][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (wall[i][j]) continue;				
				// 가로 파이프 이동
				if (!wall[i][j + 1]) {
					dp[i][j + 1][0] += dp[i][j][0];
					if (!wall[i + 1][j] && !wall[i + 1][j + 1]) {
						dp[i + 1][j + 1][2] += dp[i][j][0];		
					}
				}
				// 세로 파이프 이동
				if (!wall[i + 1][j]) {
					dp[i + 1][j][1] += dp[i][j][1];
					if (!wall[i][j + 1] && !wall[i + 1][j + 1]) {
						dp[i + 1][j + 1][2] += dp[i][j][1];
					}
				}
				// 대각선 파이프 이동
				if (!wall[i][j + 1]) {
					dp[i][j + 1][0] += dp[i][j][2];
				}
				if (!wall[i + 1][j]) {
					dp[i + 1][j][1] += dp[i][j][2];
				}
				if (!wall[i][j + 1] && !wall[i + 1][j] && !wall[i + 1][j + 1]) {
					dp[i + 1][j + 1][2] += dp[i][j][2];
				}
			}
		}
		
		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
		sc.close();
	}
}
