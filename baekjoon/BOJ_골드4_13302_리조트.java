package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드4_13302_리조트 {
	static int N, min;
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
		
		min = (N - M) * 10;
		dfs(1, 0, 0);
		
		System.out.println(min * 1000);		
	}
	
	public static void dfs(int day, int coupon, int cost) {
		if (day > N) {
			if (min > cost) min = cost;
			return;
		}
		if (cost > min) return;
		
		if (impossible[day]) {
			dfs(day + 1, coupon, cost);
		}
		else {		
			// 5일 연속
			dfs(day + 5, coupon + 2, cost + 37);
			// 3일 연속
			dfs(day + 3, coupon + 1, cost + 25);
			// 하루
			if (coupon >= 3) {
				dfs(day + 1, coupon - 3, cost);			
			} else {
				dfs(day + 1, coupon, cost + 10);
			}			
		}
		
	}
}
