package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버1_1890_점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N =Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		long[][] dp = new long[N][N];
		
		// 게임판 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		
		// 접프
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] == 0 || map[i][j] == 0) continue;
				if (i + map[i][j] < N) {
					dp[i + map[i][j]][j] += dp[i][j];
				}
				if (j + map[i][j] < N) {
					dp[i][j + map[i][j]] += dp[i][j];					
				}
			}
		}
		
//		System.out.println(Arrays.deepToString(dp).replace("], ", "\n").replaceAll("[\\[\\,\\]]", ""));
		System.out.println(dp[N - 1][N - 1]);
	}
}
