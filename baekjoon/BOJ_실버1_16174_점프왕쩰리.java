package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_실버1_16174_점프왕쩰리 {
	public static class District {
		int r, c, range;

		public District(int r, int c, int range) {
			this.r = r;
			this.c = c;
			this.range = range;
		}
	}
	static int N;
	static String ans;
	// 하, 우
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = "Hing";
		visited = new boolean[N][N];
		
		
		Queue<District> q = new LinkedList<>();
		// 0, 0 에서 시작
		q.add(new District(0, 0, map[0][0]));
		visited[0][0] = true;
		outer:
		while(!q.isEmpty()) {
			District d = q.poll();
			
			for (int i = 0; i < 2; i++) {
				int nr = d.r + d.range * dr[i];
				int nc = d.c + d.range * dc[i];
				// 범위 밖
				if (nr >= N || nc >= N
						|| visited[nr][nc]) continue;
				if (map[nr][nc] == -1) {
					// 승리 지점 도달
					ans = "HaruHaru";
					break outer;
				}
				visited[nr][nc] = true;
				q.add(new District(nr, nc, map[nr][nc]));				
			}
		}
		
//		visited[0][0] = true;
//		travle(0, 0, map[0][0]);
		
		// 가능 HaruHaru 불가능 Hing
		System.out.println(ans);
	}
	/*
	public static void travle(int r, int c, int range) {
		if (ans.equals("HaruHaru")) return;
		if (map[r][c] == -1) {
			ans = "HaruHaru";
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			int nr = r + range * dr[i];
			int nc = c + range * dc[i];
			// 범위 밖
			if (nr >= N || nc >= N
					|| visited[nr][nc]) continue;
			visited[nr][nc] = true;
			travle(nr, nc, map[nr][nc]);
		}
	}
	*/
}
