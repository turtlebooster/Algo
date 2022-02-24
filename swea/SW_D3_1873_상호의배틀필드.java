package swea;

import java.util.HashMap;
import java.util.Scanner;

public class SW_D3_1873_상호의배틀필드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 전차가 바라보는 방향, 입력의 방향에 따른 탐색 방향 설정
		HashMap<Character, Integer> dMap = new HashMap<>();
		dMap.put('^', 0);
		dMap.put('v', 1);
		dMap.put('<', 2);
		dMap.put('>', 3);
		dMap.put('U', 0);
		dMap.put('D', 1);
		dMap.put('L', 2);
		dMap.put('R', 3);
		
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		char[] tank = {'^', 'v', '<', '>'};
		
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();	// 맵의 높이
			int W = sc.nextInt();	// 맵의 너비
			char[][] map = new char[H][W];	// 맵
			
			// 게임 맵 입력
			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray(); 
			}
			
			int N = sc.nextInt();	// 사용자 입력 개수
			char[] cmd = sc.next().toCharArray();	// 사용자 입력 배열
			
			// 전차 위치 찾기
			int r = -1, c = -1;	// 전차 위치 저장할 변수
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					// 전차인 경우
					if ("^v<>".contains(map[i][j] + "")) {
						r = i; c = j;	// 전차 초기좌표 기록 후 반복 종료
						break;
					}
					
				}
			}
			
			if (r != -1 && c != -1) {				
				// 사용자 입력 수 만큼 동작 실행
				for (int i = 0; i < N; i++) {
					switch (cmd[i]) {
					case 'U':
					case 'D':
					case 'L':
					case 'R':
						// 전차가 이동해야할 방향 벡터 설정
						int dirN = dMap.get(cmd[i]);
						int dr = dir[dirN][0];
						int dc = dir[dirN][1];
						// 해당 방향으로의 이동이 맵 범위 안에 있고 평지라면
						if (r + dr >= 0 && r + dr < H && c + dc >= 0 && c + dc < W && map[r + dr][c + dc] == '.') {
							map[r + dr][c + dc] = tank[dirN];
							map[r][c] = '.';
							r = r + dr;	c = c + dc;
						} else {
							map[r][c] = tank[dirN];
						}
						break;
					case 'S':
						// 전차가 바라보고 있는 방향 한칸 앞 부터 탐색 진행
						// 벽 또는 맵 밖으로 나갈때까지
						
						// 포탄이 이동해야할 방향 벡터 설정
						int dr1 = dir[dMap.get(map[r][c])][0];
						int dc1 = dir[dMap.get(map[r][c])][1];
						
						for (int d = 1;;d++) {
							// 포탄 cannon 위치
							int cr = r + d * dr1;
							int cc = c + d * dc1;
							if (cr < 0 || cr >= H || cc < 0 || cc >= W) break;
							if (map[cr][cc] == '#') break;
							if (map[cr][cc] == '*') {
								map[cr][cc] = '.';
								break;
							}
						}
						break;
					}
				}
			}			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();				
			}
		}
		sc.close();
	}
}