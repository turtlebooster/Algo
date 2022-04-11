package swea;

/*
import java.util.Scanner;

public class SW_D4_7465_창용마을무리의개수 {
	static int[] data;
	public static void main(String[] args) {
		Scanner sc = new Scanner("\r\n" + 
				"2\r\n" + 
				"6 5\r\n" + 
				"1 2\r\n" + 
				"2 5\r\n" + 
				"5 1\r\n" + 
				"3 4\r\n" + 
				"4 6\r\n" + 
				"6 8\r\n" + 
				"1 2\r\n" + 
				"2 5\r\n" + 
				"5 1\r\n" + 
				"3 4\r\n" + 
				"4 6\r\n" + 
				"5 4\r\n" + 
				"2 4\r\n" + 
				"2 3");		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int N = sc.nextInt(),
				M = sc.nextInt();
			data = new int[N + 1];
			
			// makeSet 집합 만들기
			for (int i = 1; i <= N; i++) {
				data[i] = i;
			}
			// 간선 수 만큼 unionSet
			for (int i = 0; i < M; i++) {
				unionSet(sc.nextInt(), sc.nextInt());
			}
//			System.out.println(Arrays.toString(data));
			
			for (int i = 1; i <= N; i++) {
				if (data[i] == i) ans++;
			}
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
	private static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		data[py] = px;
	}
	private static int findSet(int x) {
		if (x == data[x]) return x;
		return data[x] = findSet(data[x]);
//		return findSet(data[x]);
	}
}
*/

import java.util.Scanner;

public class SW_D4_7465_창용마을무리의개수 {
	static int[] zzang;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			zzang = new int[N + 1];
			// 처음엔 자기 자신이 짱
			for (int i = 1; i <= N; i++) zzang[i] = i;
			
			for (int i = 0; i < M; i++) {
				unionZ(sc.nextInt(), sc.nextInt());
			}
			
			int ans = 0;
			// 짱의 수 찾기
			for (int i = 1; i <= N; i++) {
				if (zzang[i] == i) ans++;
			}
			
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
	
	public static int findZ(int x) {
		if (zzang[x] == x) return x;
		return zzang[x] = findZ(zzang[x]);
	}
	public static void unionZ(int x, int y) {
		int zx = findZ(x);
		int zy = findZ(y);
		zzang[zy] = zx;
	}
}