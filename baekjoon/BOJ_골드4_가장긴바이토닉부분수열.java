package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드4_가장긴바이토닉부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		// 0 가장 긴 증가하는 부분수열
		// 1 역방향 가장 긴 증가하는 부분수열
		int[][] dp = new int[2][N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[0][i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[0][i] = Math.max(dp[0][j] + 1, dp[0][i]);
				}
			}
		}
		
		for (int i = N - 1; i >= 0; i--) {
			dp[1][i] = 1;
			for (int j = N - 1; j >= i; j--) {
				if (arr[j] < arr[i]) {
					dp[1][i] = Math.max(dp[1][j] + 1, dp[1][i]);
				}
			}
		}
		
		int max = 1;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[0][i] + dp[1][i] - 1);
		}
		
		System.out.println(max);
		br.close();
	}
}
