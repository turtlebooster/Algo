package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_2302_극장좌석 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		
		// 연속된 변경가능 좌석 수 별 가짓수
		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			// 마지막 자리는 안 바꾸고 (i - 1 개 좌석으로 앉는 가짓수) + 마지막 두 자리 서로 바꾸고 (i - 2 개 좌석 앉는 가짓수)
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		// 고정석 개수
		int M = sc.nextInt();
		// 이전 고정석 번호
		int temp = 0;
		// 앉을 수 있는 가짓수
		int cnt = 1;
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			cnt *= dp[num - temp - 1];
			temp = num;
		}
		cnt *= dp[N - temp];
		
		System.out.println(cnt);
		sc.close();
	}
/*	
	static int cnt, N;
	static boolean[] vip, visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		vip = new boolean[N]; 
		visited = new boolean[N];
		int M = sc.nextInt();
		int idx;
		for (int i = 0; i < M; i++) {
			idx = sc.nextInt() - 1;
			vip[idx] = true;
			visited[idx] = true;
		}
		cnt = 0;
		count(0);
		
		System.out.println(cnt);
		sc.close();
	}
	private static void count(int idx) {
		if (idx >= N) {
			cnt++;
			return;
		}
		
		if (vip[idx]) {
			count(idx + 1);
			return;
		}
		
		if (idx > 0 && !visited[idx - 1]) {
			visited[idx - 1] = true;
			count(idx + 1);
			visited[idx - 1] = false;
		}
		if (!visited[idx]) {
			visited[idx] = true;
			count(idx + 1);
			visited[idx] = false;
		}
		if (idx < N - 1 && !visited[idx + 1]) {
			visited[idx + 1] = true;
			count(idx + 1);
			visited[idx + 1] = false;
		}
	}
*/
}
