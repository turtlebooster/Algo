package swea;

import java.util.Scanner;

public class SW_D3_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();	// 농장 크기, 항상 홀수
			int[][] map = new int[N][N];
			// 농장 데이터 세팅
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}				
			}
			
			int sum = 0;
			for (int j = 0; j < N ; j++) {				
				for (int i = j < N / 2 ? N / 2 - j : j - N / 2 ; j < N / 2 ? i < 2 * j + 1 + N / 2 - j: i < - 2 * (j - N / 2) + N + j - N / 2; i++) {
					sum += map[i][j];
				}				
			}						
			System.out.println("#" + tc + " " + sum);
		}
		sc.close();
	}
}