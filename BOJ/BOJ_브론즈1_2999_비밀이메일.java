package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈1_2999_비밀이메일 {
	/*
	 * N 글자 이메일
	 * R<=C && R*C=N 을 만족하는 R 중 큰 값
	 * 행 R 개, 열 C 개
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] msg = sc.next().toCharArray();
		
		int Rmax = 1;		
		int N = msg.length;
		int Cmin = N;
		for (int R = 1, C = N; R <= C ; R++, C = N / R) {
			if (N == R * C) {
				if (Rmax < R) {
					Rmax = R;
					Cmin = C;
				}
			}
		}
		
		char[][] map = new char[Rmax][Cmin];
		int k = 0;
		for (int j = 0; j < Cmin ; j++) {
			for (int i = 0; i < Rmax ; i++) {
				map[i][j] = msg[k++]; 
			}			
		}
		
		for (int i = 0; i < Rmax ; i++) {
			for (int j = 0; j < Cmin ; j++) {
				System.out.print(map[i][j]); 
			}			
		}
		
		
		sc.close();
	}
}
