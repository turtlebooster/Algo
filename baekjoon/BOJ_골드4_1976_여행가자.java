package baekjoon;

import java.util.Scanner;

public class BOJ_골드4_1976_여행가자 {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 도시의 수 N <= 200
		int M = sc.nextInt();	// 여행 계획에 속한 도시들의 수 M <= 1000
		
		p = new int[N + 1];
		// make set
		for (int i = 1; i <= N; i++) p[i] = i;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {				
				if (sc.nextInt() == 0) continue;
				union(i, j);
			}
		}		
				
		int num = findSet(sc.nextInt());
		String ans = "YES";
		
		for (int i = 1; i < M; i++) {
			if (findSet(sc.nextInt()) != num) {
				ans = "NO";
				break;
			}
		}
		
		
		System.out.println(ans);
		sc.close();
	}
	
	static int findSet(int x) {
		if (p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		if (y < x) {
			int temp = x;
			x = y;
			y = x;
		}
		p[findSet(y)] = findSet(x);
	}
}
