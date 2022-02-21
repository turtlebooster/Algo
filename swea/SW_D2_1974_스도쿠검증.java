package swea;

import java.util.Scanner;

public class SW_D2_1974_스도쿠검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		testcase:
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int[][] sudoku = new int[9][9];
			// 스도쿠 데이터 세팅
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}				
			}
			
			//스도쿠 판별
			// 행, 열 방향 판별
			for (int i = 0; i < 9; i++) {
				// 같은 값이 2번 이상 들어오는지 체크할 행, 열방향 불리언배열
				boolean[] rcount = new boolean[10];
				boolean[] ccount = new boolean[10];
				for (int j = 0; j < 9; j++) {
					if (rcount[sudoku[i][j]]) {
						System.out.println("#" + tc + " " + ans);
						continue testcase;
					}
					if (ccount[sudoku[j][i]]) {
						System.out.println("#" + tc + " " + ans);
						continue testcase;
					}
					// 한번 체크되면 true로 변경
					rcount[sudoku[i][j]] = !rcount[sudoku[i][j]];
					ccount[sudoku[j][i]] = !ccount[sudoku[j][i]];
				}				
			}
			
			// 작은 네모 안 판별 -> 총 9개의 네모
			for (int i = 0; i < 9 ; i += 3) {
				for (int j = 0; j < 9 ; j += 3) {
					// 내부 체크
					boolean[] count = new boolean[10];
					for (int r = i; r < 3 + i; r++) {
						for (int c = i; c < 3 + i; c++) {
							if (count[sudoku[r][c]]) {
								System.out.println("#" + tc + " " + ans);
								continue testcase;
							}
							count[sudoku[r][c]] = !count[sudoku[r][c]];
						}						
					}
				}				
			}
			
			ans = 1;
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
