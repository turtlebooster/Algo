package swea;

import java.util.Scanner;

public class SW_D4_3289_서로소집합 {
	static int[] set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			StringBuilder ans = new StringBuilder();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			set = new int[N + 1];
			for (int i = 1; i <= N; i++) set[i] = i;
			
			for (int i = 0; i < M; i++) {
				int op = sc.nextInt();
				switch (op) {
				case 0:
					// 합집합
					unionSet(sc.nextInt(), sc.nextInt());
					break;
				case 1:
					// 같은 집합인지 유무 확인 - 같은 집합 1, 다른 집합 0
					if (findSet(sc.nextInt()) == findSet(sc.nextInt())) ans.append(1);
					else ans.append(0);
					break;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
	public static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		set[py] = px;		
	}
	
	public static int findSet(int x) {
		if (set[x] == x) return x;
		return set[x] = findSet(set[x]);
	}
}
