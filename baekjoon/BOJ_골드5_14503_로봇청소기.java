package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드5_14503_로봇청소기 {
	static int N, M, clean;
	static int[][] room;
	static boolean[][] cleaned;
	// 북 동 남 서
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 세로 크기
		M = Integer.parseInt(st.nextToken());	// 가로 크기
		
		st = new StringTokenizer(br.readLine());
		int[] robot = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		
		
		room = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean = 0;	// 청소한 칸의 수
		cleaned = new boolean[N][M];
		
		work(robot);
		
		System.out.println(clean);
	}
	private static void work(int[] robot) {
		// 자리 청소
		int r = robot[0];
		int c = robot[1];
		int dir = robot[2];
		
		if (!cleaned[r][c]) {
			clean++;
			cleaned[r][c] = true;
		}
		
		// 인접 칸 탐색
		for (int i = 1; i <= 4; i++) {
			int ndir = (dir + 4 - i) % 4;
			int nr = r + dr[ndir];
			int nc = c + dc[ndir];
			
			// 범위 밖이거나 이미 청소 됐거나 벽이면 패스
			if (nr < 0 || nr >= N || nc < 0 || nc >= M
					|| cleaned[nr][nc]
					|| room[nr][nc] == 1) continue;
			
			robot[0] = nr;
			robot[1] = nc;
			robot[2] = ndir;
			work(robot);
			return;
		}
		// 여기 내려왔으면 2a 단계가 연속 네번 실행 됨
		robot[0] -= dr[robot[2]];
		robot[1] -= dc[robot[2]];
		// 뒤가 벽인지 체크 -> 벽이면 작동 종료
		if (robot[0] < 0 || robot[0] >= N || robot[1] < 0 || robot[1] >= M
				|| room[robot[0]][robot[1]] == 1) return; 
		
		// -> 벽이 아니면 뒤로 후진
		work(robot);			
		
	}
}
