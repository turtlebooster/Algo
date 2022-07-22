package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_골드4_15685_드래곤커브 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[101][101];
		
		int x, y, d, g;
		List<Integer> dirList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			dirList.clear();
			dirList.add(d);
			
			// g 세대까지의 방향 리스트 구하기
			for (int j = 0; j < g; j++) {
				for (int k = dirList.size() - 1; k >= 0; k--) {
					// 방향은 역순으로 반시계방향으로 돌리는 것과 같음
					dirList.add((dirList.get(k) + 1) % 4);
				}
			}
			
			// 드래곤 커브가 지나가는 점 표시
			map[x][y] = true;
			for (int dir : dirList) {
				switch (dir) {
				case 0:
					map[++x][y] = true;
					break;
				case 1:
					map[x][--y] = true;
					break;
				case 2:
					map[--x][y] = true;
					break;
				case 3:
					map[x][++y] = true;
					break;
				}
			}
		}
		
		
		// 1 x 1 정사각형 개수 구하기	
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) cnt++; 
			}
		}
		
		System.out.println(cnt);
	}
}
