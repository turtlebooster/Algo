package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_골드5_13549_숨바꼭질3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] dist = new int[100_001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N, 0});
		dist[N] = 0;
		
		int[] curr;
		int p, t;
		while(!q.isEmpty()) {
			curr = q.poll();
			p = curr[0];
			t = curr[1];			
								
			if (p - 1>= 0 && dist[p - 1] > t + 1) {
				q.add(new int[] {p - 1, t + 1});
				dist[p - 1] = t + 1;
			}
			if (p + 1 <= 100_000 && dist[p + 1] > t + 1) {
				q.add(new int[] {p + 1, t + 1});
				dist[p + 1] = t + 1;
			}
			if (2 * p <= 100_000 && dist[2 * p] > t) {
				q.add(new int[] {2 * p, t});
				dist[2 * p] = t;
			}
		}
		
		
		System.out.println(dist[K]);
		sc.close();
	}
}
