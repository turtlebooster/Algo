package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈1_10163_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[1001][1001];
		int N = sc.nextInt();
		
		// 색종이 수 만큼 반복 진행
		for (int num = 1; num <= N; num++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			int ccnt = sc.nextInt();
			int rcnt = sc.nextInt();
			// 각 색종이 번호가 덮어씌워짐
			for (int i = r; i < r + rcnt; i++) {
				for (int j = c; j < c + ccnt; j++) {
					map[i][j] = num;
				}			
			}			
		}
		
		// 면적 행렬에 면적 저장
		int[] area = new int[N + 1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				for (int k = 1; k <= N; k++) {
					// 색종이 번호가 나올때마다 + 1
					if (map[i][j] == k) area[k]++;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) System.out.println(area[i]);
		sc.close();
	}
}
