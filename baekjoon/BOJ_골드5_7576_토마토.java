package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_골드5_7576_토마토 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();	// 상자 가로 칸의 수
		int N = sc.nextInt();	// 상자 세로 칸의 수
		
		// 상 우 하 좌
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int[][] box = new int[N][M];
		
		Queue<int[]> q = new LinkedList<>();
//		boolean[][] check = new boolean[N][M];
		int remain = M * N;		// 익지 않은 토마토 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
				if (box[i][j] == 1) {
					q.add(new int[] {i, j});
//					check[i][j] = true;
					remain--;
				} else if (box[i][j] == -1) {
					remain--;					
				}
			}
		}
		
		int ans = -1;
		
		if (remain != 0) {
			int day = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				day++;
				for (int i = 0; i < size; i++) {
					int[] pos = q.poll();
					
					// 4방 탐색
					for (int j = 0; j < 4; j++) {
						int nr = pos[0] + dr[j];
						int nc = pos[1] + dc[j];
						
						// 범위 벗어나면 통과
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
						
						// 덜 익은애 아니면 작업 필요 x
						if (box[nr][nc] != 0) continue;
						
						box[nr][nc] = 1;
						q.add(new int[] {nr, nc});
						remain--;
					}
					
				}
			}
			
			if (remain == 0) ans = day - 1;
			
		} else {
			ans = 0;
		}
		
		
		System.out.println(ans);
		sc.close();
	}
}
