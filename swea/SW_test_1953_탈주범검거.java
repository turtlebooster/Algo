package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_test_1953_탈주범검거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M, R, C, L, time, cnt;
		int[][] map;
		// 상하좌우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int[][] type = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};
		int[] match = {1<<1 | 1<<2 | 1<<5 | 1<<6,	//상-하
					   1<<1 | 1<<2 | 1<<4 | 1<<7,	//하-상
					   1<<1 | 1<<3 | 1<<4 | 1<<5,	//좌-우
					   1<<1 | 1<<3 | 1<<6 | 1<<7};	//우-좌
		
		boolean[][] visited;
		Queue<int[]> q;
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 세로 크기
			M = Integer.parseInt(st.nextToken());	// 가로 크기
			R = Integer.parseInt(st.nextToken());	// 맨홀 뚜껑 세로 위치
			C = Integer.parseInt(st.nextToken());	// 맨홀 뚜껑 가로 위치
			L = Integer.parseInt(st.nextToken());	// 탈출 후 소요된 시간
			
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// BFS
			visited = new boolean[N][M];
			q = new LinkedList<>();
			visited[R][C] = true;
			q.offer(new int[] {R, C});
			
			time = 1;
			cnt = 1;
			while(!q.isEmpty()) {
				if (time++ == L) break;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] pos = q.remove();
					int no = map[pos[0]][pos[1]];
					for (int d = 0; d < type[no].length; d++) {
						int nr = pos[0] + dr[type[no][d]];
						int nc = pos[1] + dc[type[no][d]];
						
						if (nr < 0 || nr >= N || nc < 0 || nc >= M
							|| visited[nr][nc]
							|| (match[type[no][d]] & 1<<map[nr][nc]) == 0
							|| map[nr][nc] == 0) continue;
						
						visited[nr][nc] = true;
						q.offer(new int[] {nr, nc});
						cnt++;
					}
				}
//				System.out.println("time : " + time + " cnt : " + cnt);
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}
