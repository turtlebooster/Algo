package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SW_test_no1_낚시터자리잡기 {
	static int min;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] orders = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
		for (int t = 1; t <= T; t++) {
			// 낚시터 자리 개수
			N = sc.nextInt();
			int[][] gates = new int[3][2];
			for (int i = 0; i < 3; i++) {
				// 출입구 위치
				gates[i][0] = sc.nextInt() - 1;
				// 출입구 대기 낚시꾼들 수
				gates[i][1] = sc.nextInt();
			}
			
			min = Integer.MAX_VALUE;
			for (int[] order : orders) {
				boolean[] seats = new boolean[N]; 
				calc(order, gates, seats, 0, 0);
			}
			
			System.out.println("#" + t + " " + min);
		}
		sc.close();
	}

	private static void calc(int[] order, int[][] gates, boolean[] seats, int idx, int sum) {
		// 최소 합 보다 크거나 같다면 중지
		if (sum >= min) return;
		// 게이트 3개에 대해 모두 배치 했을 경우
		if (idx >= 3) {
			// 최소 합 갱신
			min = sum;
			return;
		}
		
		
		// 마지막 사람을 제외한 낚시꾼 배치
		// 게이트로 부터 떨어진 거리
 		int d = 0;
		// 게이트 위치
		int p = gates[order[idx]][0];
		boolean flag;
		for (int i = 0; i < gates[order[idx]][1] - 1; i++) {
			flag = false;
			while(true) {
				if (p + d < N && !seats[p + d]) {
					seats[p + d] = true;
					sum += d + 1;
					flag = true;
					break;
				} else if (p - d >= 0 && !seats[p - d]) {
					seats[p - d] = true;
					sum += d + 1;
					d++;
					flag = true;
					break;
				}
				d++;
			}
		}
		
		// 마지막 낚시꾼 배치
		flag = false;
		boolean[] origin = Arrays.copyOf(seats, N);
		while(true) {
			if (p + d < N && !seats[p + d]) {
				seats[p + d] = true;
				calc(order, gates, seats, idx + 1, sum + d + 1);
				seats = origin;
				flag = true;
			}
			if (p - d >= 0 && !seats[p - d]) {
				seats[p - d] = true;
 				calc(order, gates, seats, idx + 1, sum + d + 1);
 				seats = origin;
				flag = true;
			}
			if (flag) break;
			d++;
		}
		seats = origin;
	}
}
