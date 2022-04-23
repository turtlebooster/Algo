package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버1_1932_정수삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][];
		
		for (int i = 0; i < N; i++) {
			int[] part = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				part[j] = sc.nextInt();
			}
			arr[i] = part;
		}
		
		int[][] dp = new int[N][];
		dp[0] = new int[] {arr[0][0]};
		
		for (int i = 1; i < N; i++) {
			dp[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				dp[i][j] = arr[i][j] + Math.max(j - 1 < 0 ? 0 : dp[i - 1][j - 1], j >= i ? 0 : dp[i - 1][j]);
			}
		}
		
		int max = 0;
		for (int j = 0; j < N; j++) {
			max = Math.max(max, dp[N - 1][j]);
		}
//		System.out.println(Arrays.deepToString(dp).replace("], ", "]\n"));
		System.out.println(max);
		sc.close();
	}
}
