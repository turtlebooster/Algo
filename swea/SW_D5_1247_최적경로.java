package swea;

import java.util.Scanner;

public class SW_D5_1247_최적경로 {
	public static int N, min;
	public static int[][] pos;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			pos = new int[N + 2][2];
			// 회사 좌표
			pos[0][0] = sc.nextInt();
			pos[0][1] = sc.nextInt();
			// 집 좌표
			pos[N + 1][0] = sc.nextInt();
			pos[N + 1][1] = sc.nextInt();
			// 고객 좌표	1 ~ N			
			for (int i = 1; i <= N; i++) {
				pos[i][0] = sc.nextInt();
				pos[i][1] = sc.nextInt();				
			}
			
			min = Integer.MAX_VALUE;
			perm(0, 0, 0, 0);			
			System.out.println("#" + t + " " + min);
		}
		sc.close();
	}
	
	public static void perm(int cnt, int check, int from, int sum) {
		if (cnt == N) {
			sum += getDist(pos[from], pos[N + 1]);
			min = Math.min(min, sum);
			return;
		}
		
		if (min < sum) return;
		
		for (int i = 1; i <= N; i++) {
			if((check & 1<<i) > 0) continue;
			perm(cnt + 1, check | 1<<i, i, sum + getDist(pos[from], pos[i]));			
		}
		
	}
	
	private static int getDist(int[] pos1, int[] pos2) {
		return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
	}
}
