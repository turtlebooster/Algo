package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드4_4485_녹색옷입은애가젤다지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int t = 1;
		int[] dr = {-1, 1, 0, 0};	// 세로 방향	상하좌우 
		int[] dc = {0, 0, -1, 1};	// 가로 방향	상하좌우
		int[][] map, dist;
		boolean[][] visited;
		PriorityQueue<int[]> pq;
		while (N != 0) {
			map = new int[N][N];
			// 도둑루피 데이터 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			// dijkstra
			pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
			
			// 방문체크
			visited = new boolean[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
			
			// 0, 0 부터 시작
			dist[0][0] = map[0][0];
			pq.add(new int[] {0, 0, dist[0][0]});
			
			while (!pq.isEmpty()) {
				int[] curr = pq.poll();
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
					
					if (dist[nr][nc] > w + map[nr][nc]) {
						dist[nr][nc] = w + map[nr][nc];
						pq.offer(new int[] {nr, nc, dist[nr][nc]});
					}
				}
			}
			
			System.out.println("Problem " + t++ + ": " + dist[N - 1][N - 1]);
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
		}
	}
}
