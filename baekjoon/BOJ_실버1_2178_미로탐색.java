package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_실버1_2178_미로탐색 {
	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] maze = new char[N][];
		
		for (int i = 0; i < N; i++) {
			maze[i] = sc.next().toCharArray();
		}
		
		boolean[][] visited = new boolean[N][M];
		
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0));
		visited[0][0] = true;
		
		
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		
				int size;
		int moveCnt = 0;
		outer:
		while(!q.isEmpty()) {
			size = q.size();
			moveCnt++;
			for (int i = 0; i < size; i++) {
				Pos p = q.poll();
				if(p.r == N - 1 && p.c == M - 1) break outer;
				
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					
					// 범위 밖 제외
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					// 0 이면 못 가는 자리
					if (maze[nr][nc] == '0') continue;
					// 이미 방문한 곳 다시 가지 않음
					if (visited[nr][nc]) continue;
					q.add(new Pos(nr, nc));
					visited[nr][nc] = true;					
				}
				
			}			
		}
		
		System.out.println(moveCnt);
		sc.close();
	}
}
