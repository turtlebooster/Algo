package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_1309_동물원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		
		dp[0] = 1;
		dp[1] = 3;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = ((2 * dp[i - 1]) % 9901 + dp[i - 2]) % 9901;
		}
		
		System.out.println(dp[N]);
		sc.close();
	}
}
