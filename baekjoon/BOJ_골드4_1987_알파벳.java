package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드4_1987_알파벳 {
	static int R, C, max;
	static int[] dr = new int[] {1, -1, 0, 0};
	static int[] dc = new int[] {0, 0, 1, -1};
	static boolean[] alpha = new boolean['Z' - 'A' + 1];
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 보드 크기 입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		// 보드 배열 입력
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		alpha[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(max);
	}
	private static void dfs(int r, int c, int cnt) {
		if (cnt > max) {
			max = cnt;
		}
		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;			
			if (alpha[map[nr][nc] - 'A']) continue;
			
			alpha[map[nr][nc] - 'A'] = true;
			dfs(nr, nc, cnt + 1);
			alpha[map[nr][nc] - 'A'] = false;
		}
		
	}
}
