package baekjoon;

import java.util.Scanner;

public class BOJ_골드4_15562_친구비 {
	static int[] A, p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int k = sc.nextInt();
		A = new int[N];
		p = new int[N];
		for (int i = 0; i < N; i ++) {
			A[i] = sc.nextInt();
			p[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			int px = findSet(sc.nextInt() - 1);
			int py = findSet(sc.nextInt() - 1);
			
			if (px != py) {
				union(px, py);
			}
		}
		
		boolean[] visited = new boolean[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int px = findSet(i);
			if (visited[px]) continue;
			visited[px] = true;
			sum += A[px];
		}
		
		if (sum <= k) {
			System.out.println(sum);			
		} else {
			System.out.println("Oh no");		
		}
		sc.close();
	}
	private static void union(int px, int py) {		
		A[px] = A[py] = Math.min(A[px], A[py]);
		if (px > py) {
			p[px] = py;
		} else {
			p[py] = px;
		}
	}
	private static int findSet(int x) {
		if (p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
}
