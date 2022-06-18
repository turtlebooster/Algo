package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_2206_벽부수고이동하기 {
	public static class Pos {
		int r, c;
		boolean drill;
		public Pos(int r, int c, boolean drill) {
			this.r = r;
			this.c = c;
			this.drill = drill;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][];
		
		for (int i = 0; i < N; i++) {			
				map[i] = br.readLine().toCharArray(); 
		}
		
		int ans = -1;
		if (N != 1 || M != 1) {			
			// BFS
			Queue<Pos> q = new LinkedList<>();
			
			
			boolean[][][] visited = new boolean[N][M][2];
			
			q.add(new Pos(0, 0, false));
			visited[0][0][0] = true;
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			int nr, nc, size, cnt = 1;
			outer:
				while(!q.isEmpty()) {
					cnt++;
					size = q.size();
					for (int i = 0; i < size; i++) {
						Pos p = q.poll();
						
						// 4방 탐색
						for (int n = 0; n < 4; n++) {
							nr = p.r + dr[n];
							nc = p.c + dc[n];
							
							if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
							
							// 벽 일 경우
							if (map[nr][nc] == '1') {
								// 뚫은 적 있으면 못감
								if (p.drill || visited[nr][nc][1]) continue;						
								q.add(new Pos(nr, nc, true));
								visited[nr][nc][1] = true;
							} 
							// 길 일 경우
							else {
								if (visited[nr][nc][p.drill ? 1 : 0]) continue;
								// 도착지 도달시 종료
								if (nr == N - 1 && nc == M - 1) {
									ans = cnt;
									break outer;
								}
								q.add(new Pos(nr, nc, p.drill));					
								visited[nr][nc][p.drill ? 1 : 0] = true;
							}
						}					
					}			
				}
		} else {
			ans = 1;
		}
		
		System.out.println(ans);
				
	}
}
