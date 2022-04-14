package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드3_16236_아기상어 {
	// 상 좌 하 우
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		
		// 공간 데이터 입력
		Queue<int[]> q = new LinkedList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((f1, f2) -> {
			if (f1[0] != f2[0]) return f1[0] - f2[0];
			return f1[1] - f2[1];
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					// 아기 상어일 경우
					pq.add(new int[] {i, j});
				} 
			}
		}
		int time = 0;
		int lv = 2;		// 상어 크기
		int cnt = -1;	// 잡은 물고기 수
		int dist = 0;	// 이동거리
		int r, c;		// 위치 표시용
		int[] pos;		// 위치 배열
		boolean[][] visited;
		while(!pq.isEmpty()) {
			time += dist;
			q.clear();
			visited = new boolean[N][N];
			pos = pq.poll();
			r = pos[0];
			c = pos[1];
			
			q.add(pos);
			pq.clear();
			visited[r][c] = true;
			map[r][c] = 0;
			// 잡은 물고기 수가 크기만큼 되면 크기 1 증가
			if (lv == ++cnt) {
				cnt = 0;
				lv++;
			}
			
			dist = 0;
//			flag = false;
			while(!q.isEmpty() && pq.isEmpty()) {
				dist++;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					pos = q.poll();
					r = pos[0];
					c = pos[1];
					
					// 4방 탐색
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						// 범위를 벗어나거나, 방문했거나, 상어보다 큰 물고기이면 패스
						if (nr < 0 || nr >= N || nc < 0 || nc >= N
							|| visited[nr][nc]
							|| map[nr][nc] > lv) continue;
						
						visited[nr][nc] = true;							
						if (map[nr][nc] != 0 && map[nr][nc] < lv) {
							// 자신보다작은 물고기이면
//							flag = true;
							pq.add(new int[] {nr, nc});
						} else {
							q.add(new int[] {nr, nc});
						}
						
					}
				}
			}
		}
//		System.out.println(Arrays.deepToString(map).replace("], ", "]\n").replaceAll("[\\[\\,\\]]", ""));
		System.out.println(time);
		
	}

}
