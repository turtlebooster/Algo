package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드5_7569_토마토 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 가로 세로 높이
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] dr = {1, -1, 0, 0, 0, 0};
		int[] dc = {0, 0, 1, -1, 0, 0};
		int[] dh = {0, 0, 0, 0, 1, -1};
		
		// 토마토 상태 입력
		int[][][] tomatos = new int[M][N][H];
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					tomatos[m][n][h] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// BFS
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[M][N][H];
		
		// 익은 토마토 입력
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (tomatos[m][n][h] != 1) continue;
					visited[m][n][h] = true;
					q.add(new int[] {m, n, h});
				}
			}
		}
		
		// BFS 진행
		int day = -1;
		while(!q.isEmpty()) {
			day++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				
				// 상 하 좌 우 위 아래  6 방 탐색
				for (int d = 0; d < 6; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					int nh = curr[2] + dh[d];
					
					// 범위 이탈
					if (nr < 0 || nr >= M || nc < 0 || nc >= N || nh < 0 || nh >= H) continue;
					if (visited[nr][nc][nh] || tomatos[nr][nc][nh] == -1) continue;
					visited[nr][nc][nh] = true;
					tomatos[nr][nc][nh] = 1;
					q.add(new int[] {nr, nc, nh});
				}
			}
		}
		
		// 안익은 토마토 체크
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (tomatos[m][n][h] == 0) {
						day = -1;
						break;
					}
				}
			}
		}
		
		System.out.println(day);
		br.close();
	}
}
