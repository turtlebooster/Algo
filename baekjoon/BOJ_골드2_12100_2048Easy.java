package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_골드2_12100_2048Easy {
	static int N, max;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		play(0);
		System.out.println(max);
	}
	private static void play(int idx) {
		if (idx >= 5) {
			findMax();
			return;
		}
		
		int[][] origin = deepCopy(map); 
		for (int d = 0; d < 4; d++) {
			move(d);
			removeZero(d);
			play(idx + 1);
			map = deepCopy(origin);
		}
	}
	private static void move(int d) {
		int r, c, n;
		if (d < 2) {
			r = N - 1;
			c = N - 1;
		} else {
			r = 0;
			c = 0;
		}
		for (int i = 0; i < N; i++) {
			switch (d) {
			case 0:
				if (c == 0) {
					r -= 1;
					c = N - 1;
				}
				break;
			case 1:
				if (r == 0) {
					r = N - 1;
					c -= 1;
				}
				break;
			case 2:
				if (c == N - 1) {
					r += 1;
					c = 0;
				}
				break;
			case 3:
				if (r == N - 1) {
					r = 0;
					c += 1;
				}
				break;
			}
			int cnt = 1;
			n = map[r][c];			
			for (int j = 1; j < N; j++) {
				r += dr[d];
				c += dc[d];
				if (n == map[r][c]) {
					map[r - cnt * dr[d]][c - cnt * dc[d]] += n;
					map[r][c] = 0;
					n = 0;
					cnt = 1;
				} else if (map[r][c] != 0) {
					n = map[r][c];
					cnt = 1;
				} else {
					cnt++;
				}
			}
		}
	}
	private static void removeZero(int d) {
		int r, c, nr, nc, n;
		if (d < 2) {
			nr = r = N - 1;
			nc = c = N - 1;
		} else {
			nr = r = 0;
			nc = c = 0;
		}
		for (int i = 0; i < N; i++) {
			switch (d) {
			case 0:
				if (c == 0) {
					nr = r -= 1;
					nc = c = N - 1;
				}
				break;
			case 1:
				if (r == 0) {
					nr = r = N - 1;
					nc = c -= 1;
				}
				break;
			case 2:
				if (c == N - 1) {
					nr = r += 1;
					nc = c = 0;
				}
				break;
			case 3:
				if (r == N - 1) {
					nr = r = 0;
					nc = c += 1;
				}
				break;
			}
			n = map[r][c];
			map[r][c] = 0;
			if (n != 0) {
				map[nr][nc] = n;
				nr += dr[d];
				nc += dc[d];
			}
			for (int j = 1; j < N; j++) {
				r += dr[d];
				c += dc[d];
				n = map[r][c];
				map[r][c] = 0;
				if (n != 0) {
					map[nr][nc] = n;
					nr += dr[d];
					nc += dc[d];
				}
			}
		}
	}
	private static void findMax() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(map[i][j], max);
			}
		}
	}
	private static int[][] deepCopy(int[][] map) {
		int[][] origin = new int[N][];
		for (int i = 0; i < N; i++) {
			origin[i] = Arrays.copyOf(map[i], N);
		}
		return origin;
	}
}
