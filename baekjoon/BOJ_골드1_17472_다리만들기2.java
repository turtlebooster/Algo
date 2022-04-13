package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_골드1_17472_다리만들기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 세로 크기
		int M = Integer.parseInt(st.nextToken());	// 가로 크기
		int[][] map = new int[N][M];
		
		Set<Integer>[] row = new HashSet[N];	// 각 행에 포함된 섬 번호	
		Set<Integer>[] col = new HashSet[M];	// 각 열에 포함된 섬 번호	
		//set 배열 초기화
		for (int i = 0; i < N; i++) row[i] = new HashSet<>();
		for (int i = 0; i < M; i++) col[i] = new HashSet<>();
		
		// 바다 0, 섬 -1 로 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = - Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 개수 파악 및 표시
		int mark = 0; // 섬 번호 표시 및 카운팅 용 - 1 부터 시작  	2 ~ 6
		// 방향 벡터 상하좌우
		int[] dr = {-1, 1, 0, 0};		
		int[] dc = {0, 0, -1, 1};
		
		Queue<int[]> q;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					
					q = new LinkedList<>();
					map[i][j] = ++mark;	// 섬 번호 표시
					
					row[i].add(mark);
					col[j].add(mark);
					
					q.offer(new int[] {i, j});
					
					//bfs
					while (!q.isEmpty()) {
						int[] pos = q.remove();
						
						// 사방탐색
						for (int d = 0; d < 4; d++) {
							int nr = pos[0] + dr[d];
							int nc = pos[1] + dc[d];
							
							// 범위 벗어나거나, 아직 표시하지 않은 섬(= -1)이 아니라면 다음 방향으로
							if (nr < 0 || nr >= N || nc < 0 || nc >= M
									|| map[nr][nc] != -1) continue;
							
							// 범위 안이고, 표시 안한 섬이라면
							map[nr][nc] = mark;
							
							row[nr].add(mark);
							col[nc].add(mark);
							
							q.add(new int[] {nr, nc});
						}
					}
				}
			}
		}
		
//		System.out.println(Arrays.deepToString(map).replace("], ", "]\n").replaceAll("[\\[\\,\\]]", ""));
//		System.out.println(Arrays.deepToString(row).replace("], ", "]\n"));
//		System.out.println(Arrays.deepToString(col).replace("], ", "]\n"));
		
		// 다리 배열 만들기 시작, 끝, 길이
		int[][] adjArr = new int[mark + 1][mark + 1];
				
		// 행 방향 탐색
		for (int i = 0; i < N; i++) {
			if (row[i].size() < 2) continue;
			int cnt = 0;
			int num = 0;
			for (int j = 0; j < M; j++) {
				int n = map[i][j];
				if (map[i][j] == 0) cnt++;
				else {
					if (num != 0 && n != num) {
						int curr = adjArr[num][n];
						if (cnt >= 2 && (curr == 0 || (curr != 0 && curr > cnt))) {
							// 저장된 다리 길이보다 작으면 저장
							adjArr[num][n] = cnt;
							adjArr[n][num] = cnt;		
						}
					}
	
					cnt = 0;
					num = map[i][j];
				}
			}
		}
		
		// 열 방향 탐색
		for (int j = 0; j < M; j++) {
			if (col[j].size() < 2) continue;
			int cnt = 0;
			int num = 0;
			for (int i = 0; i < N; i++) {
				int n = map[i][j];
				if (map[i][j] == 0) cnt++;
				else {
					if (num != 0 && n != num) {
						int curr = adjArr[num][n];
						if (cnt >= 2 && (curr == 0 || (curr != 0 && curr > cnt))) {
							// 저장된 다리 길이보다 작으면 저장
							adjArr[num][n] = cnt;
							adjArr[n][num] = cnt;		
						}
					}
	
					cnt = 0;
					num = map[i][j];
				}
			}
		}	
		
//		System.out.println(Arrays.deepToString(adjArr).replace("], ", "]\n").replaceAll("[\\[\\,\\]]", ""));
		
		// prim 써보자!
		boolean[] visited = new boolean[mark + 1];
		int[] dist = new int[mark + 1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		// 1번 섬 부터 시작
		dist[1] = 0;
		
		int min, idx, ans = 0;
		boolean flag = true;
		for (int i = 0; i < mark; i++) {
			min = Integer.MAX_VALUE;
			idx = -1;
			for (int j = 1; j <= mark; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			if (idx == -1) {
				flag = false;
				break;
			}
			visited[idx] = true;
			for (int j = 1; j <= mark; j++) {
				if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
				}
			}
		}
		
		if (flag) {
			for (int i = 1; i <= mark; i++) {
				ans += dist[i];
			}			
		} else {
			ans = -1;
		}
		
		System.out.println(ans);
		br.close();
	}
}
