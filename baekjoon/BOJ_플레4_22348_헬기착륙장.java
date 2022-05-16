package baekjoon;

import java.util.Scanner;

public class BOJ_플레4_22348_헬기착륙장 {
	private static final int MOD = 1000000007;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		int A, B;
		int[] dp;
		boolean[] visited;
		for (int t = 0; t < T; t++) {
			A = sc.nextInt();
			B = sc.nextInt();
			
			dp = new int[50000];
			visited = new boolean[50000];
			
			
			ans = 0;
			comb(1, A, B);			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	public static void comb(int cnt, int A, int B) {		
		// A 페인트로 그릴 경우
		if (cnt <= A) {
			if (++ans >= MOD) ans %= MOD;
			comb(cnt + 1, A - cnt, B);
		}
		// B 페인트로 그릴 경우
		if (cnt <= B) {
			if (++ans >= MOD) ans %= MOD;
			comb(cnt + 1, A, B - cnt);
		}
	}
}
/*
// 20점
public class BOJ_플레4_22348_헬기착륙장 {
	private static final int MOD = 1000000007;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		int A, B;
		for (int t = 0; t < T; t++) {
			A = sc.nextInt();
			B = sc.nextInt();
			
			ans = 0;
			comb(1, A, B);			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	public static void comb(int cnt, int A, int B) {		
		// A 페인트로 그릴 경우
		if (cnt <= A) {
			// ans = ++ans % MOD;
			if (++ans >= MOD) ans %= MOD;
			comb(cnt + 1, A - cnt, B);
		}
		// B 페인트로 그릴 경우
		if (cnt <= B) {
			// ans = ++ans % MOD;
			if (++ans >= MOD) ans %= MOD;
			comb(cnt + 1, A, B - cnt);
		}
	}
}
*/
