package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버1_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int[][] arr, dp;
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			arr = new int[2][N + 1];
			dp = new int[2][N + 1];
			
			// 스티커 점수 입력
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			// dp 계산
			for (int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(Math.max(dp[0][i - 2], dp[1][i - 2]), dp[1][i - 1]) + arr[0][i];
				dp[1][i] = Math.max(Math.max(dp[0][i - 2], dp[1][i - 2]), dp[0][i - 1]) + arr[1][i];
			}
			
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
	}
}
