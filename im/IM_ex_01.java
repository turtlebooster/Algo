package im;

import java.util.Scanner;

public class IM_ex_01 {
	/*
	 * 기지국 커버했을까??
	 * 커버되지 않은 집의 수 찾기 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();	// 지도 크기 N x N	1 ~ 50
			char[][] map = new char[N][N];
			
			// 지도 데이터 입력
			for(int i = 0; i < N; i++) {
				// 각 줄에 대해서 charArray로 만들기
				map[i] = sc.next().toCharArray();
			}
			
			// 상 하 좌 우
			int[] dr = {-1, 1, 0, 0};			
			int[] dc = {0, 0, -1, 1};
			
			int home = 0; 	// 집의 총 갯수 카운트
			int cover = 0; 	// 커버된 집의 수 카운트
			
			// 총 집의 수 카운트
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H') home++;
				}
			}
					
			// 커버된 집의 수 카운트
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'X' || map[i][j] == 'H') continue;
					// 기지국만 여기로 내려옴
					// 기지국 타입에 따라 4방 탐색 진행
					// 커버리지에 따른 반복 횟수	A: 1 B: 2 C: 3
					for (int n = 1; n <= map[i][j] - 'A' + 1; n++) {
						// 사방탐색을 위한 반복문
						for (int d = 0; d < 4; d++) {
							int nr = i + n * dr[d];
							int nc = j + n * dc[d];
							// 범위를 넘어가면 수행하지 않음 + 집이 아니면 체크할 필요 없음
							if (nr < 0 || nr > N || nc < 0 || nc > N || map[nr][nc] != 'H') continue;
							// 범위 안넘어가고 집인 것들만 내려옴
							map[nr][nc] = 'X';	// 커버된것은 X로 표기
							cover++;			// 커버된 개수 + 1
						}
					}
					
				}
			}
			
			
			int ans = home - cover;
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
