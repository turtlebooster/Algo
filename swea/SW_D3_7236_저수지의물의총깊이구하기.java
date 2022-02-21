package swea;

import java.util.Scanner;

public class SW_D3_7236_저수지의물의총깊이구하기 {
	// 9칸씩 보라는 것 같음
	// 그 안의 W 갯수가 물의 깊이 -> 자기자신 빼고!
	// 하지만 G로 둘러쌓였을땐 W 자기 자신만 카운트
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;	// 최대 물의 깊이
			int N = sc.nextInt();	//저수지 구획의 크기
			int[][] mull = new int[N][N];	// 9 ~ 100
			
			// 데이터 입력 받기
			// G = 0, W = 1
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if ("W".equals(sc.next())) mull[i][j] = 1;
				}
			}
			
			// 9 칸씩 보자 -> 8 방 탐색
			// 		 상 상우 우 하우 하 하좌 좌 상좌 순으로 탐색
			int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};			
			int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};			
			
			for (int r = 1; r < N - 1; r++) {
				for (int c = 1; c < N - 1; c++) {
					// 자기자신이 W 가 아니면 저수지로 생각 안할래
					if (mull[r][c] != 1) continue;
					int sum = 0;
					for (int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];					
						sum += mull[nr][nc];	// W 일 경우 1 이므로 sum 곧 구획의 물 깊이
					}
					if (sum == 0) sum++;
					ans = Math.max(ans, sum);
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
