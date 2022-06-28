package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_1929_소수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] check = new boolean[N + 1];
		check[1] = true;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 2; i * j <= N; j++) {
				check[i * j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (check[i]) continue;
			sb.append(i + "\n");
		}
		
		System.out.print(sb);
		sc.close();
	}
}
