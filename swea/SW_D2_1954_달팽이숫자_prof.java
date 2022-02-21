package swea;

import java.util.Scanner;

public class SW_D2_1954_달팽이숫자_prof {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			
			
			int k = N;	// 반복 횟수
			int change = 1;
			int r = 0, c = -1;		
			int num = 0;
			
			// 숫자입력
			while (true) {
				for (int i = 0; i < k; i++) {	// 수평
					c += change;
					snail[r][c] = ++num; 
				}
//				k--;
				if (--k == 0) break;
				for (int i = 0; i < k; i++) {	// 수직
					r += change;
					snail[r][c] = ++num;
				}	
				change *= -1;	// 수평-수직 이후에 값을 증감 변경
			}
			
			
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
			
			
		}
		sc.close();
	}
}