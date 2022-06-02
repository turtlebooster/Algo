package swea;

import java.util.Scanner;

public class SW_D4_1865_동철이의일분배 {
	static int N;
	static double ans;
	static int[][] P;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			P = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					P[i][j] = sc.nextInt();
				}
			}
			
			ans = 0;
			check = new boolean[N];
			cal(0, 1);
			
			System.out.printf("#%d %.6f\n", t, ans);
		}
		
		sc.close();
	}
	
	public static void cal(int idx, double percent) {
		if (percent * 100 <= ans) return;
		
		if (idx == N) {
			// 계산 
			if (percent * 100 > ans) ans = percent * 100;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (check[i]) continue;
			check[i] = true;
			cal(idx + 1, percent * 0.01 * P[idx][i]);
			check[i] = false;
		}
		
		
	}
}