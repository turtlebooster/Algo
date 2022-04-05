package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버3_15650_N과M_2 {
	public static int N, M;
	public static int[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		comb(0, 1);
		
		sc.close();
	}
	
	public static void comb(int cnt, int start) {
		if (cnt == M) {
			System.out.println(Arrays.toString(sel).replaceAll("[\\[\\,\\]]", ""));
			return;
		}
		for (int i = start; i <= N; i++) {
			sel[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
}
