package swea;

import java.util.Scanner;

public class SW_test_no2_헌터 {
	static int min, N, M;
	static int[] cnt, order;
	static int[][] mPos, uPos;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mPos = new int[5][];
		uPos = new int[5][];
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			// 맵의 크기
			N = sc.nextInt();
			// 해당 번호의 유저 및 몬스터 수
			cnt = new int[5];
			int num;
			// 유저, 몬스터 순서 길이
			M = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					num = sc.nextInt();
					if (num == 0) continue;
					else if (num > 0) {
						mPos[num] = new int[] {i, j};
					} else {
						uPos[-num] = new int[] {i, j};
					}
					cnt[Math.abs(num)]++;
					M++;
				}
			}
			// 유저 및 몬스터 방문 순서
			order = new int[M];
			min = Integer.MAX_VALUE;
			findMin();
			
			System.out.println("#" + t + " " + min);
		}
		sc.close();
	}
	private static void findMin() {
		makeOrder(0);
	}
	private static void makeOrder(int idx) {
		if (idx >= M) {
			calc();
			return;
		}
		
		for (int i = 1; i <= 4; i++) {
			if (cnt[i] == 0) continue;
			cnt[i]--;
			order[idx] = i;
			makeOrder(idx + 1);
			cnt[i]++;
		}
	}
	private static void calc() {
		boolean[] visited = new boolean[5];
		int sum = 0;
		int[] p = {1, 1};
		for (int num : order) {
			if (!visited[num]) {
				// 몬스터
				visited[num] = true;
				sum += getDist(p, mPos[num]);
				p = mPos[num];
			} else {
				// 유저
				sum += getDist(p, uPos[num]);
				p = uPos[num];
			}
		}
		min = Math.min(min, sum);
	}
	private static int getDist(int[] pos1, int[] pos2) {
		return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
	}
}
