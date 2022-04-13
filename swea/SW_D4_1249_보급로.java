package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SW_D4_1249_보급로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine().trim());
		int N;
		final int INF = Integer.MAX_VALUE;
		int[] dr = {-1, 1, 0, 0};	// 세로 방향	상하좌우 
		int[] dc = {0, 0, -1, 1};	// 가로 방향	상하좌우
		int[][] map = new int[100][100];	// 지도
		int[][] dist;						// 거리 저장
		boolean[][] visited;
		for (int t = 1; t <= T; t++) {
			// 지도의 크기
			N = Integer.parseInt(br.readLine().trim());
			
			// 지도 데이터 입력
			for (int i = 0; i < N; i++) {
				String row = br.readLine().trim();
				for (int j = 0; j < N; j++) {
					map[i][j] = row.charAt(j) - '0';
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			
			
//			visited = new boolean[N][N];
//			dist = new int[N][N];
//			for (int i = 0; i < N; i++) Arrays.fill(dist[i], INF);
//			dist[0][0] = 0;
//			
//			for (int n = 0; n < N * N - 1; n++) {
//				int mini = -1;
//				int minj = -1;
//				int minValue = INF;
//				
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						if (!visited[i][j] && minValue > dist[i][j]) {
//							minValue = dist[i][j];
//							mini = i;
//							minj = j;
//						}
//					}
//				}
//				
//				visited[mini][minj] = true;
//				
//				for (int d = 0; d < 4; d++) {
//					// 다음 좌표
//					int nr = mini + dr[d]; 
//					int nc = minj + dc[d];
//					// 범위 벗어나면 다음 순서로
//					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
//					
//					if (!visited[nr][nc] && dist[nr][nc] > dist[mini][minj] + map[nr][nc]) {
//						dist[nr][nc] = dist[mini][minj] + map[nr][nc];
//					}
//				}
//			}
			
			
			// {row, col, cost}
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
			
			// 방문 체크 배열
			visited = new boolean[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) Arrays.fill(dist[i], INF);
			
			
			dist[0][0] = 0;
			pq.offer(new int[] {0, 0, 0});
			
			
			while(!pq.isEmpty()) {
				int[] curr = pq.remove();
				int r = curr[0];
				int c = curr[1];
				int w = curr[2];
				
				if(visited[r][c]) continue;
				visited[r][c] = true;
				
				// 4방 탐색
				for (int d = 0; d < 4; d++) {
					// 다음 좌표
					int nr = r + dr[d]; 
					int nc = c + dc[d];
					// 범위 벗어나면 다음 순서로
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
					
					if (dist[nr][nc] > dist[r][c] + map[nr][nc]) {
						dist[nr][nc] = dist[r][c] + map[nr][nc];
						pq.offer(new int[] {nr, nc, dist[nr][nc]});
					}
				}
			}
			System.out.println("#" + t + " " + dist[N - 1][N - 1]);
		}
	}
}
