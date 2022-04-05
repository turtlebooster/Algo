package baekjoon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BOJ_실버2_4963_섬의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w == 0 && h == 0) break;
			
			int[][] map = new int[h][w];
			Queue<int[]> q = new LinkedList<>();
			
			// 상 상우 우 우하 하 하좌 좌 좌상 
			int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
			int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
			
			int num = 2;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();				
					if (map[i][j] == 1) {
						map[i][j] = num++;
						q.add(new int[] {i, j});
					}
				}
			}
			
			while(!q.isEmpty()) {
				int[] pos = q.poll();
				for (int i = 0; i < 8; i++) {
					int nr = pos[0] + dr[i];
					int nc = pos[1] + dc[i];
					
					// 범위 벗어나면 통과
					if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
					// 0 이면 통과
					if (map[nr][nc] == 0) continue;
					
					if (map[nr][nc] > map[pos[0]][pos[1]]) {
						map[nr][nc] = map[pos[0]][pos[1]];
						q.add(new int[] {nr, nc});
					}
				}
				
				
			}
			
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 0) continue;
					set.add(map[i][j]);
				}
			}
			System.out.println(set.size());
		}
		
		sc.close();
	}
}
