package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//그냥 무식하게 모든 경우 살펴보기
public class SW_test_1949_등산로조성 {
	static int N, K, max, ans;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			// 지도 데이터 입력
			max = 0; // 최대 높이
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > max) max = map[i][j];
				}
			}
			
			ans = 1;
			
			// 높이 변화 없는 상태에서 진행
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] != max) continue;
					visited = new boolean[N][N];
					visited[r][c] = true;
					travle(1, r, c);
				}
			}
			
			// 1 ~ K 만큼 임의의 높이를 줄인 모든 경우의 수에 대해서 탐색 
			for(int k = 1; k <= K; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// k 만큼 높이 줄이기
						map[i][j] -= k;
						
						for (int r = 0; r < N; r++) {
							for (int c = 0; c < N; c++) {
								if (map[r][c] != max) continue;
								visited = new boolean[N][N];
								visited[r][c] = true;
								travle(1, r, c);
							}
						}
						
						// 원상 복구
						map[i][j] += k;					
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
		br.close();
	}
	
	public static void travle(int cnt, int r, int c) {
		if (cnt > ans) ans = cnt;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if (map[r][c] <= map[nr][nc]) continue;
			visited[nr][nc] = true;
			travle(cnt + 1, nr, nc);			
			visited[nr][nc] = false;			
		}
		
	}
	
}
