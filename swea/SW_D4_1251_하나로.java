package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SW_D4_1251_하나로 {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();	// 섬의 개수 1 ~ 1000
			
			int[] X = new int[N];	// X 좌표
			int[] Y = new int[N];	// Y 좌표
			
			for (int i = 0; i < N; i++) X[i] = sc.nextInt();
			for (int i = 0; i < N; i++) Y[i] = sc.nextInt();
			
			double E = sc.nextDouble();	// 세율
			
			int size = (N - 1) * N / 2;
			long[][] path = new long[size][3];
			
			int idx = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					path[idx][0] = i;
					path[idx][1] = j;
					path[idx][2] = calcLenSq(X[i], Y[i], X[j], Y[j]);
					idx++;
				}
			}
			
			Arrays.sort(path, (p1, p2) -> {
				if (p1[2] > p2[2]) return 1;
				if (p1[2] < p2[2]) return -1;
				return 0;
			});
			
			p = new int[N];
			for (int i = 0; i < N; i++) p[i] = i;
			
			long ans = 0;
			
			int cnt = 1;
			for (int i = 0; i < size; i++) {
				int px = findSet((int)path[i][0]);
				int py = findSet((int)path[i][1]);
				
				if (px != py) {
					union(px, py);
					ans += path[i][2];
					cnt++;
				}
				if (cnt == N) break;
			}
			
			
			System.out.println("#" + t + " " + (long)(ans * E + 0.5));
		}
		sc.close();
	}
	
	private static void union(int px, int py) {
		p[py] = px;
	}

	private static int findSet(int x) {
		if (p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}

	private static long calcLenSq(int x1, int y1, int x2, int y2) {
		long dx = x1 - x2;
		long dy = y1 - y2;
		return dx * dx + dy * dy;
	}
}
