package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드5_14502_연구소 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 세로 크기
		int M = Integer.parseInt(st.nextToken());	// 가로 크기
		
		int[] dr = {-1, 1, 0, 0};		
		int[] dc = {0, 0, -1, 1};
		
		// 연구소
		int[][] research = new int[N][M];
		
		// 연구소 상황 입력
		int zeroCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				research[i][j] = Integer.parseInt(st.nextToken());
				if (research[i][j] == 0) zeroCnt++;
			}
		}
		
		Queue<int[]> q;
		boolean[][] visited;
		
		int max = 0;
		int size = N * M;
		for (int i = 0; i < size - 2; i++) {
			int r1 = i / M;
			int c1 = i % M;
			if (research[r1][c1] != 0) continue;
			for (int j = i + 1; j < size - 1; j++) {
				int r2 = j / M;
				int c2 = j % M;
				if (research[r2][c2] != 0) continue;
				for (int k = j + 1; k < size; k++) {
					int r3 = k / M;
					int c3 = k % M;
					if (research[r3][c3] != 0) continue;
					// 0 인 위치 3개 조합으로 고르기 완료
					// 1 로 놓고 안전영역 크기 확인
					research[r1][c1] = research[r2][c2] = research[r3][c3] = 1;

					// BFS
					// 벽 3개 새웠으므로 초기 안전구역은 0 개수 - 3
					int safe = zeroCnt - 3;
					visited = new boolean[N][M];
					for (int idx = 0; idx < size; idx++) {
						int r = idx / M;
						int c = idx % M;
						
						if (research[r][c] != 2 || visited[r][c]) continue;
						
						q = new LinkedList<>();
						
						q.add(new int[] {r, c});
						visited[r][c] = true;
						
						while(!q.isEmpty()) {
							int[] pos = q.poll();
							
							// 사방탐색
							for (int d = 0; d < 4; d++) {
								int nr = pos[0] + dr[d];
								int nc = pos[1] + dc[d];
								
								// 범위 벗어나거나, 0이 아니거나, 이미 방문한 위치라면
								if (nr < 0 || nr >= N || nc < 0 || nc >= M
										|| research[nr][nc] != 0
										|| visited[nr][nc]) continue;
								
								visited[nr][nc] = true;
								safe--;
								q.add(new int[] {nr, nc});
							}
							
						}
					}
					max = Math.max(max, safe);
					
					// 원상복구
					research[r1][c1] = research[r2][c2] = research[r3][c3] = 0;
				}
			}
		}
		System.out.println(max);
	}
}
