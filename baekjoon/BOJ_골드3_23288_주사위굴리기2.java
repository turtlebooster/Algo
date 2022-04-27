package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_골드3_23288_주사위굴리기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 시계방향 동 남 서 북
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		int N = sc.nextInt();	// 지도 세로 크기
		int M = sc.nextInt();	// 지도 가로 크기
		int K = sc.nextInt();	// 이동 가능 횟수
		
		// 지도 정보 입력
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 지도 위치별 점수 매핑
		int[][] scoreMap = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		List<int[]> BList;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (scoreMap[i][j] != 0) continue;
				int[] pos = {i, j};
				q.add(pos);
				BList = new ArrayList<>();
				BList.add(pos);
				scoreMap[i][j] = 1; // 방문체크
				
				int B = map[i][j];	// 해당 좌표에 적혀있는 수
				
				// BFS 로 B 로 연속된 위치 탐색
				while(!q.isEmpty()) {
					int[] curr = q.poll();
					int r = curr[0];
					int c = curr[1];
					
					// 4방 탐색
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						// 범위 밖, 이미 방문 패스
						if (nr < 0 || nr >= N || nc < 0 || nc >= M
								|| scoreMap[nr][nc] != 0
								|| map[nr][nc] != B) continue;
						
						// 방문 체크
						scoreMap[nr][nc] = 1;
						int[] npos = {nr, nc};
						q.add(npos);
						BList.add(npos);
					}
					
				}
				
				// 탐색된 위치들에 대해 B * 개수 로 점수 저장
				int score = B * BList.size();				
				for (int[] p : BList) {
					scoreMap[p[0]][p[1]] = score;
				}
			}
		}
		
		int dir = 0; // 처음 주사위 이동방향 동쪽
		// 주사위 초기 상태 - 뒤 위 앞 아래 왼 오른
		int[] dice = {2, 1, 5, 6, 4, 3};
		// 주사위 초기 위치
		int r = 0;
		int c = 0;
		
		int ans = 0;
		
		// K 횟수반큼 이동 진행
		for (int t = 1; t <= K; t++) {
			r += dr[dir];
			c += dc[dir];
			// 이동 방향에 칸이 없다면
			if (r < 0 || r >= N || c < 0 || c >= M) {
				// 반대 방향으로
				dir = (dir + 2) % 4;
				r += 2 * dr[dir];
				c += 2 * dc[dir];
			}
			
			ans += scoreMap[r][c];
			
			roll(dice, dir);
			
			int A = dice[3];
			int B = map[r][c];
			
			if (A > B) {
				dir = (dir + 1) % 4;
			} else if(A < B) {
				dir = (dir + 3) % 4;
			} 
			
		}
		
		System.out.println(ans);
		sc.close();
	}

	private static void roll(int[] dice, int dir) {
		int temp = 0;
		switch (dir) {
		case 0:
			// 동
			temp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
			return;
		case 1:
			// 남
			temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[2];
			dice[2] = dice[1];
			dice[1] = temp; 
			return;
		case 2:
			// 서
			temp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[4];
			dice[4] = temp;
			return;
		case 3:
			// 북
			temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = temp; 
			return;
		}
	}
}
