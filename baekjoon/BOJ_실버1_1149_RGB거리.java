package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_1149_RGB거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] costs = new int[N + 1][3];
		
		// 데이터 입력
		for (int i = 1; i <= N; i++) {
			costs[i][0] = sc.nextInt();
			costs[i][1] = sc.nextInt();
			costs[i][2] = sc.nextInt();
		}		
		
		// dp[i][j] i 번째 집까지 i번째 집이 j 색깔을 골랐을때 최소 비용
		int[][] dp = new int[N + 1][3];	
			
		for (int i = 1; i <= N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0]; 
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];			
		}
		
		int min = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])); // 칠하는 비용 최소값
		
		System.out.println(min);
		sc.close();
	}
	
	/*
	// 재귀 -> 시간초과
	static int N, min;
	static int[][] costs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		costs = new int[N + 1][3];
		
		// 데이터 입력
		for (int i = 1; i <= N; i++) {
			costs[i][0] = sc.nextInt();
			costs[i][1] = sc.nextInt();
			costs[i][2] = sc.nextInt();
		}		
		
		min = Integer.MAX_VALUE; // 칠하는 비용 최소값
		
		calcCost(2, 0, costs[1][0]);
		calcCost(2, 1, costs[1][1]);
		calcCost(2, 2, costs[1][2]);
		
		System.out.println(min);
		sc.close();
	}
	
	static void calcCost(int idx, int before, int sum) {
		// 재귀 끝
		if (idx > N) {
			min = Math.min(min, sum);
			return;
		}
		
		// 재귀
		for (int i = 0; i < 3; i++) {
			// idx 번 집은 idx - 1 번 집과 다른 색
			// 이전 집과만 다르게 해도 양 옆은 다름
			if (i == before) continue;
			calcCost(idx + 1, i, sum + costs[idx][i]);
		}
		
	}
	*/	
}
