package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드5_16234_인구이동 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 인구 정보 입력
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int day = 0;
		
		outer:
		while(true) {			
			boolean flag = false;
			boolean[][] check = new boolean[N][N];		
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (check[i][j]) continue;
					List<int[]> list = new ArrayList<>();
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i, j});
					check[i][j] = true;
					int sum = 0;
					
					while(!q.isEmpty()) {					
						int[] pos = q.poll();
						int r = pos[0];
						int c = pos[1];
						sum += map[r][c];
						list.add(pos);
						
						for (int n = 0; n < 4; n++) {
							int nr = r + dr[n];
							int nc = c + dc[n];
							
							if(nr < 0 || nr >= N || nc < 0 || nc >= N
									|| check[nr][nc]) continue;
							
							int sub = Math.abs(map[r][c] - map[nr][nc]);
							if(sub < L || sub > R) continue;
							flag = true;
							q.add(new int[] {nr, nc});
							check[nr][nc] = true;
						}					
					}
					
					int ingu = sum / list.size();
					for (int[] p : list) {
						map[p[0]][p[1]] = ingu;
					}
					
				}
			}
			if(!flag) {
				break outer;
			}
			
			day++;
			
		}
		
		System.out.println(day);
		
	}
}
