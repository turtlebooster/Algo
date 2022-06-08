package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_실버1_맥주마시면서걸어가기 {
	static final String POSSIBLE = "happy";
	static final String IMPOSSIBLE = "sad";
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	// 테스트 케이스 개수
		while(T-- > 0) {
			int N = sc.nextInt();	// 맥주를 파는 편의점의 개수
			Pos[] location = new Pos[N + 2];
			
			// i = 0 : 집	/	i = 1 ~ N : 편의점	/	i = N + 1 : 펜타포트
			for (int i = 0; i < N + 2; i++) {
				location[i] = new Pos(sc.nextInt(), sc.nextInt());				
			}			
			
			int[][] dist = new int[N + 2][N + 2];
			for (int i = 0; i < N + 1; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					dist[i][j] = dist[j][i] = getDist(location[i], location[j]);
				}
			}
			
			//BFS
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[N + 2];
			q.add(0);	// 집에서 출발
			visited[0] = true;
					
			while(!q.isEmpty()) {
				int idx = q.poll();
//				Pos curr = location[idx];
				
				if (idx == N + 1) {
					// 펜타포트 도착					
					break;
				}				
				
				for (int i = 1; i < N + 2; i++) {
					if (i == idx) continue;
					if (dist[idx][i] <= 1000
							&& !visited[i]) {
						visited[i] = true;
						q.add(i);						
					}					
					
				}				
			}
			
			if (visited[N + 1]) {
				System.out.println(POSSIBLE);
			} else {
				System.out.println(IMPOSSIBLE);				
			}
		}
		
		sc.close();
	}
	public static int getDist(Pos p1, Pos p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}
