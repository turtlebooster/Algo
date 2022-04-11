package baekjoon;

import java.util.Scanner;

public class BOJ_골드4_2616_소형기관차 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 기관차가 끌고 가던 객차 수
		int[] train = new int[N];
		for (int i = 0; i < N; i++) {
			train[i] = sc.nextInt();	// 각 객차에 타고 있는 손님의 수
		}
		int R = sc.nextInt();	// 각 소형 기관차가 최대로 끌 수 있는 객차의 수
		
		int size = N - R + 1;
		// sum[i] = i ~ i + R - 1 객차의 손님 수 합
		int[] sum = new int[size];
		
		for (int i = 0; i < R; i++) {
			sum[0] += train[i];
		}
		for (int i = 1; i < size; i++) {
			// 이전 객차 - 맨 앞 + 새로운 객차
			sum[i] = sum[i - 1] - train[i - 1] + train[i + R - 1];
		}
		
		// i 까지 sum 1, 2, 3 개 골랐을때 최대 손님 수
		int[] dp1 = new int[size];
		int[] dp2 = new int[size];
		int[] dp3 = new int[size];
		
		dp1[0] = sum[0];
		for (int i = 1; i < size; i++) {
			dp1[i] = Math.max(dp1[i - 1], sum[i]);
		}
		
		dp2[R] = sum[0] + sum[R];
		for (int i = R + 1; i < size; i++) {
			// dp1[i - R] : sum[i] 랑 겹치지 않는 곳 까지 구간에서 1 개 골랐을때 최대값
			dp2[i] = Math.max(dp2[i - 1], dp1[i - R] + sum[i]);
		}
		
		dp3[2 * R] = sum[0] + sum[R] + sum[2 * R];
		for (int i = 2 * R + 1; i < size; i++) {
			// dp2[i - R] : sum[i] 랑 겹치지 않는 곳 까지 구간에서 2 개 골랐을때 최대값
			dp3[i] = Math.max(dp3[i - 1], dp2[i - R] + sum[i]);
		}
		
		System.out.println(dp3[size - 1]);
		sc.close();
	}
}
/*
import java.util.Scanner;

public class BOJ_골드4_2616_소형기관차 {
	static int N, R, max;
	static int[] sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 기관차가 끌고 가던 객차 수
		int[] train = new int[N];
		int total = 0;
		for (int i = 0; i < N; i++) {
			train[i] = sc.nextInt();	// 각 객차에 타고 있는 손님의 수
			total += train[i];
		}
		R = sc.nextInt();	// 각 소형 기관차가 최대로 끌 수 있는 객차의 수
		
		sum = new int[N - R + 1];
		
		for (int i = 0; i < R; i++) {
			sum[0] += train[i];
		}
		for (int i = 1; i < N - R + 1; i++) {
			// 이전 객차 - 맨 앞 + 새로운 객차
			sum[i] = sum[i - 1] - train[i - 1] + train[i + R - 1];
		}
		
		max = 1<<31;
		comb(0, 0, 0, total);
		
		System.out.println(max);
		sc.close();
	}
	
	public static void comb(int cnt, int idx, int people, int remain) {
		if (people + remain < max) return;
		if (cnt == 3) {
			max = Math.max(max, people);
			return;
		}
		if (idx >= N - R + 1) return;
		
		// 선택한 경우
		comb(cnt + 1, idx + R, people + sum[idx], remain - sum[idx]);
		// 선택 하지 않은 경우
		comb(cnt , idx + 1, people, remain);
	}
}
*/