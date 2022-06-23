package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_2579_계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 단어의 개수
		
		int[] scores = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			scores[i] = sc.nextInt();
		}		
		
		// dp[i][0] : 연속된 계단을 밟아 i 에 도달했을때의 최대 점수
		// dp[i][1] : 한 계단 넘어서 i 에 도달했을때의 최대 점수
		int[][] dp = new int[N + 1][2];
		dp[1][0] = dp[1][1] = scores[1];
		
		for (int i = 2; i <= N; i++) {
			// 연속된 계단을 밟아 i에 도달하려면 i-1 에는 한 계단 넘어서 도착했어야 함
			dp[i][0] = dp[i - 1][1] + scores[i];
			// i에 도달하려면 i-2 에서 출발 -> 둘 중 큰 값을 이용하면 최대 점수
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + scores[i];
		}
		
		System.out.println(Math.max(dp[N][0], dp[N][1]));
		sc.close();
	}	

}
