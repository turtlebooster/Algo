package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드4_2573_빙산 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] bingmt, diff; 
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 이차원 배열의 크기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 입력 받을 이차원 배열
		bingmt = new int[N][M];
		
		// 이차원 배열 빙산 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				bingmt[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		int cnt = 0;
		
		while (true) {
			cnt = 0;
			visited = new boolean[N][M];
			diff = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (bingmt[i][j] == 0 || visited[i][j]) continue;
					cnt++;
					// DFS 로 위치별 빙하 녹는 양 기록
					updateDiff(i, j);
				}
			}
			
			// 2 개 이상으로 나뉘었거나 다 녹았을 경우 종료
			if (cnt >= 2 || cnt == 0) break;
			
			// 빙산 녹이기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (diff[i][j] == 0) continue;
					bingmt[i][j] -= diff[i][j];
					if (bingmt[i][j] < 0) bingmt[i][j] = 0; 
				}
			}
			
			year++;
		}
		
		// 끝까지 2개 이상으로 나뉘지 않으면 0 출력
		if (cnt < 2) year = 0;
		System.out.println(year);
	}
	
	public static void updateDiff(int r, int c) {
		visited[r][c] = true;
		
		int zeroCnt = 0;
		int nr, nc;
		for (int n = 0; n < 4; n++) {
			nr = r + dr[n];
			nc = c + dc[n];
			
			// 처음과 끝의 행, 열은 0 이므로 범위 체크 불필요
			if (bingmt[nr][nc] == 0) zeroCnt++;
			else if (!visited[nr][nc]) {
				updateDiff(nr, nc);
			}
		}
		
		diff[r][c] = zeroCnt;
	}
}
