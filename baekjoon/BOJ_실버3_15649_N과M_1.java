package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버3_15649_N과M_1 {
	public static int N, M;
	public static int[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		perm(0, 0);
		
		sc.close();
	}
	
	public static void perm(int cnt, int visited) {
		if (cnt == M) {
			System.out.println(Arrays.toString(sel).replaceAll("[\\[\\,\\]]", ""));
			return;
		}
		for (int i = 1; i <= N; i++) {
			if ((visited & 1 << i) > 0) continue;
			sel[cnt] = i;
			perm(cnt + 1, visited | 1 << i);
		}
	}
}
