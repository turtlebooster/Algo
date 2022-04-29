package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드5_5546_파스타 {
	static class Plan {
		int d, n;	// d: 날짜, n: 파스타 번호
		public Plan(int d, int n) {
			this.d = d;
			this.n = n;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Plan> pq = new PriorityQueue<>((p1, p2) -> p1.d - p2.d);	// 날짜 순
		
		int N = Integer.parseInt(st.nextToken());	// N 일
		int K = Integer.parseInt(st.nextToken());	// 미리 파스타를 정해놓은 날의 수
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			// 날짜, 파스타 번호 % 3
			pq.add(new Plan(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) % 3));
		}
		
		int[][][] dp = new int[N + 1][3][3];	// [i][j][k]: i일에 j 번 파스타를 k 번 연속하도록 선택하는 경우의 수
		
		
		if (!pq.isEmpty() && pq.peek().d == 1) {
			// 첫 날 정해놓은 파스타가 있을 경우
			// 그 번호만 선택 가능
			int p = pq.poll().n;
			dp[1][p][1] = 1;
		} else { 
			// 첫날 정해놓은 파스타가 없을 경우
			// 각 번호마다 1 개씩 경우의 수가 존재
			dp[1][1][1] = 1;
			dp[1][2][1] = 1;
			dp[1][0][1] = 1;			
		}
		
		for (int i = 2; i <= N; i++) {
				if(!pq.isEmpty() && pq.peek().d == i) {
					// i 일에 정해진 파스타가 있을 경우
					int p = pq.poll().n;
					dp[i][p][1] = dp[i - 1][(p + 1) % 3][1] + dp[i - 1][(p + 2) % 3][1] 
								+ dp[i - 1][(p + 1) % 3][2] + dp[i - 1][(p + 2) % 3][2];
					dp[i][p][2] = dp[i - 1][p][1];
					dp[i][p][1] %= 10000;
				} else {
					for (int j = 0; j < 3; j++) {
					// i 일에 정해진 파스타가 없을경우
					// 연속되지 않도록 다른 수를 고르면 1 번 연속하도록 선택됨
					dp[i][j][1] = dp[i - 1][(j + 1) % 3][1] + dp[i - 1][(j + 2) % 3][1] 
								+ dp[i - 1][(j + 1) % 3][2] + dp[i - 1][(j + 2) % 3][2];
					// 바로 전 날짜에 1번 연속된 경우에 다시 j 를 선택하면 2번 연속되도록 선택 됨
					dp[i][j][2] = dp[i - 1][j][1];
					dp[i][j][1] %= 10000;					
					}
				}
		}
		
		
		int ans = 0;
		for (int j = 0; j < 3; j++) {
			ans += dp[N][j][1] + dp[N][j][2];
			ans %= 10000;
		}
		System.out.println(ans);
	}
}
