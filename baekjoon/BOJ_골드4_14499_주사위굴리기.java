package baekjoon;

import java.util.Scanner;

public class BOJ_골드4_14499_주사위굴리기 {
	static class Dice {
		int top, bottom, front, back, left, right;
	}
	static int x, y;
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	static int[][] map;
	static Dice dice;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 세로, 가로 크기
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 주사위 위치
		x = sc.nextInt();
		y = sc.nextInt();
		// 명령의 개수
		int K = sc.nextInt();
		
		// 지도 데이터 입력
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 주사위 생성
		dice = new Dice();
		// 정답 담을 sb
		StringBuilder sb = new StringBuilder();
		// 명령 실행
		int nx, ny, dir;
		for (int i = 0; i < K; i++) {
			dir = sc.nextInt();
			nx = x + dr[dir];
			ny = y + dc[dir];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			x = nx;
			y = ny;
			sb.append(roll(dir)).append("\n");
		}
		
		System.out.println(sb.toString());
		sc.close();
	}	

	public static int roll(int dir) {		
		int temp;
		switch (dir) {
		// 동쪽
		case 1:
			temp = dice.top;
			dice.top = dice.left;
			dice.left = dice.bottom;
			dice.bottom = dice.right;
			dice.right = temp;		
			break;
		// 서쪽
		case 2:
			temp = dice.top;
			dice.top = dice.right;
			dice.right = dice.bottom;
			dice.bottom = dice.left;
			dice.left = temp;
			break;
		// 북쪽
		case 3:
			temp = dice.top;
			dice.top = dice.front;
			dice.front = dice.bottom;
			dice.bottom = dice.back;
			dice.back = temp;
			break;
		// 남쪽
		case 4:
			temp = dice.top;
			dice.top = dice.back;
			dice.back = dice.bottom;
			dice.bottom = dice.front;
			dice.front = temp;
			break;
		}
				
		if (map[x][y] != 0) {
			// 주사위 바닥면에 지도 칸의 수 복사
			dice.bottom = map[x][y];
			map[x][y] = 0;			
		} else {
			// 지도 칸에 주사위 바닥면의 수 복사
			map[x][y] = dice.bottom;
		}
		
		return dice.top;
	}
	
}
