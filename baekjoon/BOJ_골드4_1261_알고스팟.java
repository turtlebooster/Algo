package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_골드4_1261_알고스팟 {
	static int N, M;
	static boolean[][] wall;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);		
		N = Integer.parseInt(input[1]);
		
		// 벽 위치 표시
		wall = new boolean[N][M];
		char[] line;
		int[][] dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			line = br.readLine().toCharArray();
			for (int j = 0; j < line.length; j++) {
				if (line[j] == '1') wall[i][j] = true;
			}
			
			Arrays.fill(dist[i], 10000);
		}
		
		// dijkstra
		Queue<int[]> q = new LinkedList<>();
		dist[0][0] = 0;
		q.add(new int[] {0, 0});
		
		int[] p;
		int nr, nc, add;
		while(!q.isEmpty()) {
			p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				nr = p[0] + dr[d];
				nc = p[1] + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
								
				if (wall[nr][nc]) {
					add = 1;
				} else {
					add = 0;
				}
				
				if (dist[nr][nc] > dist[p[0]][p[1]] + add) {
					dist[nr][nc] = dist[p[0]][p[1]] + add;
					q.add(new int[] {nr, nc});
				}
			}
		}
		
		
		System.out.println(dist[N - 1][M - 1]);
	}
}
