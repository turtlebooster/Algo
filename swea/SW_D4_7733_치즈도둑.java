package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class SW_D4_7733_치즈도둑 {
	public static class Part {
		int score;
		int mark;
		public Part(int score) {
			this.score = score;
			this.mark = 0;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 상 하 좌 우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());	// 한 변의 길이
			Part[][] cheese = new Part[N][N];
			Map<Integer, List<int[]>> map = new HashMap<>();	// 맛있는 정도 : 좌표
			Queue<int[]> q = new LinkedList<>();
			Set<Integer> set;
			
			int max = 1;
			
			
			int s = 100;
			int e = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					cheese[i][j] = new Part(temp);
					if(map.get(temp) == null) {
						List<int[]> list = new ArrayList<>();
						list.add(new int[] {i, j});
						map.put(temp, list);
					} else {
						map.get(temp).add(new int[] {i, j});
					}
					s = Math.min(s, temp);
					e = Math.max(e, temp);
				}
			}
			
			// s ~ e 동안
			for (int i = s; i <= e; i++) {
				// 해당 맛있는 정도가 없으면 진행할 필요 없음
				if (map.get(i) == null) continue;
				// 있을 경우
				List<int[]> list = map.get(i);
				for (int j = 0; j < list.size(); j++) {
					int[] pos = list.get(j);
					// 먹은것은 -1 로 처리
					cheese[pos[0]][pos[1]].mark = -1;
				}
				
				// -1 이외의 조각들에게 새로운 마크 부여
				int num = 0;
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						// -1 마크된건 건드리지 않는다
						if (cheese[j][k].mark == -1) continue;
						cheese[j][k].mark = ++num;
						q.add(new int[] {j, k});
					}
				}
				
				while(!q.isEmpty()) {
					int[] pos = q.poll();
					for (int j = 0; j < 4; j++) {
						int nr = pos[0] + dr[j];
						int nc = pos[1] + dc[j];
						
						// 범위 벗어나면 통과
						if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						// -1 이면 통과
						if (cheese[nr][nc].mark == -1) continue;
						
						if (cheese[nr][nc].mark > cheese[pos[0]][pos[1]].mark) {
							cheese[nr][nc].mark = cheese[pos[0]][pos[1]].mark;
							q.add(new int[] {nr, nc});
						}
					}
				}
				
				set = new HashSet<>();
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(cheese[j][k].mark == -1) continue;
						set.add(cheese[j][k].mark);
					}
				}
				max = Math.max(max, set.size());
			}
			
			
			System.out.println("#" + t + " " + max);
		}
	}
}
