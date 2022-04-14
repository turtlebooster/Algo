package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SW_test_5650_핀볼게임 {
	static int N, max;	
	// 0 상, 1 하, 2 좌, 3 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static List<int[]> list;
	// 공 블록에 따른 공 들어오는 방향 : 나가는 방향
//	static Map<Integer, Integer>[] blockIO = new HashMap[6];
	static int[][] blockIO = new int[][] {{}, {1, 3, 0, 2}, {3, 0, 1, 2}, {2, 0, 3, 1}, {1, 2, 3, 0}, {1, 0, 3, 2}};
	static Map<Integer, List<int[]>> warm;
	
	// 상하좌우
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			
			warm = new HashMap<>();
			for (int i = 6; i <= 10; i++) warm.put(i, new ArrayList<>());
			
			// 맵 데이터 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
					if (num >= 6 && num <= 10) {
						warm.get(num).add(new int[] {i, j});
					}
				}
			}
			
			max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] != 0) continue;
					for (int dir = 0; dir < 4; dir++) {
						play(r, c, dir, 0);
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	public static void play(int r, int c, int dir, int score) {
		int num;
		int sr = r;
		int sc = c;
//		int[][] mapCopy = new int[N][];
//		for (int i = 0; i < N; i++) mapCopy[i] = Arrays.copyOf(map[i], map.length);
//		mapCopy[r][c] = 99;
		while (true) {
			// 다음 방향
			r += dr[dir];
			c += dc[dir];
			
			// 벽을 만나면
			if (r < 0 || r >= N || c < 0 || c >= N) {
				max = Math.max(max, 2 * score + 1);
				return;
			}
			else if (sr == r && sc == c) {
				// 출발위치로 돌아오면
				max = Math.max(max, score);
				return;
			}
			
//			mapCopy[r][c] = 99;
			num = map[r][c];
			
			if (num == 0) continue;
			
			// 블록 만나면
			else if (num >= 1 && num <= 5) {
				int sumdr = dr[dir];
				int sumdc = dc[dir]; 
				// 다음 방향으로 변환
				dir = blockIO[num][dir];
				
				sumdr += dr[dir];
				sumdc += dc[dir];
				// 반대방향이 되면
				if (sumdr == 0 && sumdc == 0) {
					max = Math.max(max, 2 * score + 1);
					return;
				}
				
				score++;
				continue;
			}
			
			// 웜홀 만나면
			else if (num >= 6 && num <= 10) {
				int[] next = nextWarm(r, c);
				r = next[0];
				c = next[1];
				continue;
			}			
			// 블랙홀 만나면
			else {
				max = Math.max(max, score);
				return;
			}
		}
	}
	
	private static int[] nextWarm(int r, int c) {
		int num = map[r][c];
		list = warm.get(num);
		for (int[] p : list) {
			if (p[0] == r && p[1] == c) continue;
			return p;
		}
		return null;
	}
}
