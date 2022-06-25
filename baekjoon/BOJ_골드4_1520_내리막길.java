package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_골드4_1520_내리막길 {
	static final int INF = Integer.MAX_VALUE;
	static int M, N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 세로 크기
		M = Integer.parseInt(st.nextToken());	// 가로 크기
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][M];
		for (int i = 0; i < N; i++) Arrays.fill(dp[i], INF);
		dfs(0, 0);
		
		System.out.println(dp[0][0]);
	}
	private static int dfs(int r, int c) {
		if (r == N - 1 && c == M - 1) {
			return 1;
		}
		
		if (dp[r][c] != INF) return dp[r][c];
		
		dp[r][c] = 0;
		int nr, nc;
		for (int n = 0; n < 4; n++) {
			nr = r + dr[n];
			nc = c + dc[n];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if (map[nr][nc] >= map[r][c]) continue;
			dp[r][c] += dfs(nr, nc);
		}
		
		return dp[r][c];
	}
}
