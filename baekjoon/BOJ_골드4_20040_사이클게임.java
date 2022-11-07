package baekjoon;

import java.util.Scanner;

public class BOJ_골드4_20040_사이클게임 {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		
		int ans = 0;
	
		for (int i = 1; i <= M; i++) {
			int px = findSet(sc.nextInt());
			int py = findSet(sc.nextInt());
			
			if(px != py) {
				union(px, py);
			} else {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
	private static int findSet(int x) {
		if(p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
	private static void union(int px, int py) {
		if (px > py) {
			int temp;
			temp = px;
			px = py;
			py = temp;
		}
		p[py] = px;
	}
}
