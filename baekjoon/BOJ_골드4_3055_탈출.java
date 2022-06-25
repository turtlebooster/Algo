package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_3055_탈출 {
	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 숲의 크기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 숲 정보 입력
		char[][] forest = new char[N][];
		boolean findS = false;
		boolean findD = false;
		Pos s = null;
		Pos d = null;
		for (int i = 0; i < N; i++) {
			forest[i] = br.readLine().toCharArray();
			// 고슴도치 시작 위치 찾기
			if (findS && findD) continue;
			for (int j = 0; j < M; j++) {
				if (!findS && forest[i][j] == 'S') {
					findS = true;
					s = new Pos(i, j);					
				} else if (!findD && forest[i][j] == 'D') {
					findD = true;
					d = new Pos(i, j);				
				}
			}
		}
		
		// BFS 를 통한 이동 위치 찾기
		int cnt = BFS(forest, s, d, N, M);
		
		
		
		if (cnt != -1) {
			System.out.println(cnt);
		} else {
			System.out.println("KAKTUS");
		}
	}
	private static int BFS(char[][] forest, Pos s, Pos d, int N, int M) {
		Queue<Pos> q = new LinkedList<>();
		Queue<Pos> wq = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		// 고슴도치
		q.add(s);
		visited[s.r][s.c] = true;
		
		// 물가 업데이트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (forest[i][j] != '*') continue;
				wq.add(new Pos(i, j));
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int size, nr, nc;
		int cnt = 0;
		while(!q.isEmpty()) {
			
			// 홍수 업데이트
			size = wq.size();
			for (int i = 0; i < size; i++) {
				Pos wc = wq.poll();
				
				for (int n = 0; n < 4; n++) {
					nr = wc.r + dr[n];
					nc = wc.c + dc[n];
					// 범위 이탈
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					// 이미 물이 차있거나 돌이거나 굴 일경우
					if (forest[nr][nc] == '*' || forest[nr][nc] == 'X' || forest[nr][nc] == 'D') continue;
					forest[nr][nc] = '*';
					wq.add(new Pos(nr, nc));
				}
			}
			
			// 고슴도치 이동 업데이트
			cnt++;	// 이동 횟수 업데이트
			size = q.size();
			for (int i = 0; i < size; i++) {
				Pos c = q.poll();
				
				for (int n = 0; n < 4; n++) {
					nr = c.r + dr[n];
					nc = c.c + dc[n];
					// 범위 이탈
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					// 이미 방문, 물, 돌
					if (visited[nr][nc] || forest[nr][nc] == '*' || forest[nr][nc] == 'X') continue;
					
					// 목적지 도착
					if (nr == d.r && nc == d.c) {
						return cnt;
					}
					
					visited[nr][nc] = true;
					q.add(new Pos(nr, nc));
				}
			}
		}
		
		return -1;
	}
}
