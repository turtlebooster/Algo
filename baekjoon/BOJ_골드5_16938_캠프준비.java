package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_16938_캠프준비 {
	static int N, L, R, X, ans;
	static int[] levels;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		X = sc.nextInt();
		
		levels = new int[N];
		for (int i = 0; i < N; i++) {
			levels[i] = sc.nextInt();
		}
		
		dfs(0, 0, 0, Integer.MAX_VALUE, 0);
		
		System.out.println(ans);
		sc.close();
	}
	
	public static void dfs(int idx, int cnt, int sum, int min, int max) {
		if (sum > R) {
			return;
		}
		if (idx == N) {
			if (sum >= L && max - min >= X) {
				ans++;
			}
			return;
		}
		
		int level = levels[idx];
		dfs(idx + 1, cnt + 1, sum + level, Math.min(min, level), Math.max(max, level));
		dfs(idx + 1, cnt, sum, min, max);
	}
}
