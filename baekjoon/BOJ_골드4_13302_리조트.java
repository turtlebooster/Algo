package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_골드4_13302_리조트 {
	static int N, MAX;
	static int[][] dp;
	static boolean[] impossible;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		impossible = new boolean[N + 1];	// impossible[i]: i일에 갈 수 없으면 true 
		
		if(M > 0) {
			st = new StringTokenizer(br.readLine());
			while(M-- > 0) {
				impossible[Integer.parseInt(st.nextToken())] = true;
			}
		}
				
		dp = new int[N + 1][N / 5 * 2 + 1];	// dp[i][j]: i 일에 쿠폰 j개를 가지고있을때 최소비용
		MAX = (N - M) * 10;
		
		for (int i = 1; i <= N; i++) Arrays.fill(dp[i], MAX);
		
//		dfs(1, 0);
		
		System.out.println(dfs(1, 0) * 1000);		
	}
	
	public static int dfs(int day, int coupon) {
		if (day > N) {
//			if (min > cost) min = cost;
			return 0;
		}		
//		if (cost > min) return;
		if (dp[day][coupon] != MAX) return dp[day][coupon];
		
//		dp[day][coupon] = Integer.MAX_VALUE;
		if (impossible[day]) {
			dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 1, coupon));
		}
		else {		
			// 5일 연속
//			dfs(day + 5, coupon + 2);
			// 3일 연속
//			dfs(day + 3, coupon + 1);
			// 하루
			if (coupon >= 3) {
//				dfs(day + 1, coupon - 3);			
				dp[day][coupon] = Math.min(Math.min(dp[day][coupon], dfs(day + 1, coupon - 3)), 
										   Math.min(dfs(day + 5, coupon + 2) + 37, dfs(day + 3, coupon + 1) + 25));
			} else {
//				dfs(day + 1, coupon);
				dp[day][coupon] = Math.min(Math.min(dp[day][coupon], dfs(day + 1, coupon) + 10), 
								  		   Math.min(dfs(day + 5, coupon + 2) + 37, dfs(day + 3, coupon + 1) + 25));
			}
			
		}
		
		return dp[day][coupon];
	}
}
