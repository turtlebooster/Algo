package swea;

import java.util.Scanner;

public class SW_D3_11315_오목판정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 판정 방향 
		// 아래, 오른, 대각 왼 아래, 대각 오른 아래
		int[] dr = {1, 0, 1, 1};
		int[] dc = {0, 1, -1, 1};
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String ans = "NO";			
			int N = sc.nextInt();	// 오목판의 크기
			char[][] map = new char[N][];	// 오목판
			
			// 오목판 입력
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			// 돌 다섯개 이상 연속 유무 판정
			outer:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 'o') continue;
					// o 일경우에만 판정 진행
					// 4 방향 탐색
					for (int d = 0; d < 4; d++) {
						int r = i;
						int c = j;					
						// 4 칸 이후 돌까지 확인
						for (int n = 1; n <= 4; n++) {
							r += dr[d];
							c += dc[d];
							if (r < 0 || r >= N || c < 0 || c >= N || map[r][c] != 'o') break;
							// 4칸 맞으면 자기자신 포함 5개 이상 연속
							if (n == 4) {
								ans = "YES";
								break outer;
							}
						}
					}
				}				
			}
			
			
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
