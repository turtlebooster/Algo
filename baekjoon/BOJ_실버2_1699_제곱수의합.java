package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버2_1699_제곱수의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 100000);
		dp[1] = 1;
		
		double root;
		for (int i = 2; i <= N; i++) {
			root = Math.sqrt(i);			
			if (root - (int)root == 0) {
				dp[i] = 1;
			} else {
				int res;
				for (int j = 1; (res = i - j * j) >= 0; j++) {
					if (dp[i] > dp[res] + 1) {
						dp[i] = dp[res] + 1;
					}
				}
			}
		}
		
		System.out.println(dp[N]);
		sc.close();
	}
}
