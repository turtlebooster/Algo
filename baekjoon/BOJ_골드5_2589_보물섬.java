package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_골드5_2589_보물섬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		char[][] map = new char[R][];
		
		// 지도 정보 입력
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		int max = 0;
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		int size;
		int[] curr;
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 'L') continue;
				// BFS
				cnt = 0;
				q.clear();
				for (int k = 0; k < R; k++)	Arrays.fill(visited[k], false);
				
				q.add(new int[] {i, j});
				visited[i][j] = true;
				
				while(!q.isEmpty()) {
					size = q.size();
					for (int s = 0; s < size; s++) {
						curr = q.poll();
						
						for (int d = 0; d < 4; d++) {
							int nr = curr[0] + dr[d];
							int nc = curr[1] + dc[d];
							
							if (nr < 0 || nr >= R || nc < 0 || nc >= C
									|| visited[nr][nc]
									|| map[nr][nc] != 'L') continue;
							
							visited[nr][nc] = true;
							q.add(new int[] {nr, nc});							
						}
						
					}
					cnt++;
				}
				if (max < cnt) max = cnt;
			}
		}
		
		System.out.println(max - 1);
		sc.close();
	}
}
