package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_1904_01타일 {
	private static final int MOD = 15746;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if (N <= 3) {
			System.out.println(N);
		} else {
			int[] dp = new int[N + 1];
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <=N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
			}
			System.out.println(dp[N]);
		}		
		sc.close();
	}
}

/*
public class BOJ_실버3_1904_01타일 {
	private static final int MOD = 15746;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int ans = 0;		
		
		for (int i = 0; i <= N; i += 2) {			
			int n = N - i + 1;
			int r = i / 2;
			if (n > r) {
				ans += comb(N - i + 1, i / 2) % MOD;				
			} else {
				n = i / 2 + 1;
				r = N - i;
				ans += comb(n, r) % MOD;
			}			
			ans %= MOD;
		}
		
		System.out.println(ans);
		sc.close();
	}
	public static int comb(int n, int r) {
		if (r == 0 || r == n) return 1;
		if (r == 1) return n % MOD;		
		
		return comb(n - 1, r) + comb(n - 1, r - 1);
	}
}
*/