package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_D4_1226_미로1 {
	public static int[][] map;
	public static boolean possible;
	public static boolean[][] visited;
	private static final int SIZE = 16;
	// 상 우 하 좌
	public static int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 10 개의 테스트케이스
		for (int t = 1; t <= 10; t++) {
			sc.nextLine();	// 테스트케이스 번호
			map = new int[SIZE][SIZE];
			possible = false;
			visited = new boolean[SIZE][SIZE];
			
			int[] s = {-1, -1};
			int[] e = {-1, -1};
			
			// 미로 데이터 입력
			for (int i = 0; i < SIZE; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < SIZE; j++) {
					int num = Integer.parseInt(line.charAt(j) + "");
					if (num == 2) {
						s[0] = i; s[1] = j;
						num = 0;
					}
					else if (num == 3) {
						e[0] = i; e[1] = j;
						num = 0;
					}
					map[i][j] = num;
				}
			}
			
//			DFS
//			travle(s, e);
			
//			BFS
			Queue<int[]> posQ = new LinkedList<>();
			posQ.add(s);
			visited[s[0]][s[1]] = true;
			while(!posQ.isEmpty()) {
				int[] pos = posQ.poll();
				
				if (pos[0] == e[0] && pos[1] == e[1]) {
					possible = true;
					break;
				}
				
				
				for (int i = 0; i < 4; i++) {
					int[] nPos = {pos[0] + dir[i][0], pos[1] + dir[i][1]};
					if (nPos[0] < 0 || nPos[0] > SIZE || nPos[1] < 0 || nPos[1] > SIZE
							|| map[nPos[0]][nPos[1]] == 1
							|| visited[nPos[0]][nPos[1]] == true) {
						continue;
					}
					posQ.add(nPos);
					visited[nPos[0]][nPos[1]] = true;
				}
			}
			
			
			System.out.println("#" + t + " " + (possible ? 1 : 0));
			
		}
		sc.close();
	}
	
	/*
	// DFS
	public static void travle(int[] pos, int[] e) {
		if (pos[0] < 0 || pos[0] > SIZE || pos[1] < 0 || pos[1] > SIZE
				|| map[pos[0]][pos[1]] == 1
				|| visited[pos[0]][pos[1]] == true) {
			return;
		}
		
		visited[pos[0]][pos[1]] = true;
		
		if (pos[0] == e[0] && pos[1] == e[1]) {
			possible = true;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int[] nPos = {pos[0] + dir[i][0], pos[1] + dir[i][1]};
			travle(nPos, e);
		}
	}
	*/
}
