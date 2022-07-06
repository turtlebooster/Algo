package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_브론즈1_2309_일곱난쟁이 {
	public static final int N = 9;
	public static int[] tall;
	public static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		tall = new int[N];
		for (int i = 0; i < N; i++) {
			tall[i] = sc.nextInt();
		}
		sc.close();
		
		// 키 오름차순 정렬
		Arrays.sort(tall);
		comb(0, 0, 0, 0);		
	}
	private static void comb(int idx, int cnt, int sum, int visited) {
		// 답을 찾았다면 더이상 진행하지 않음
		if (flag) return;
		// 100 을 넘거나 7명을 넘으면 패스
		if (sum > 100 || cnt > 7) return;
		// 7명을 조건에 맞게 다 골랐다면
		if (cnt == 7 && sum == 100) {			
			flag = true;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				if ((1<<i & visited) == 0) continue;
				sb.append(tall[i]).append("\n");
			}
			System.out.println(sb);
			return;
		}
		// 범위를 넘으면 패스
		if (idx >= N) return;
		// idx 난쟁이를 고른 경우
		comb(idx + 1, cnt + 1, sum + tall[idx], visited | 1<<idx);
		// idx 난쟁이를 고르지 않은 경우
		comb(idx + 1, cnt, sum, visited);
	}
}
