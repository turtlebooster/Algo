package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_골드1_21611_마법사상어와블리자드 {
	static class Pos {
		int r, c; // 행, 열
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class Num {
		int val, cnt;	// 숫자 개수

		public Num(int val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}
	}
	static int N, M, size, score;
	// 방향 벡터: 좌 하 우 상 순서
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	static Pos[] line;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//////////////////////// 데이터 입력 //////////////////////////
		N = Integer.parseInt(st.nextToken());	// 연습장 크기
		M = Integer.parseInt(st.nextToken());	// 블리자드 시전 횟수
		
		map = new int[N][N];
		// 연습장 정보 입력
		// 입력에는 4개 이상 연속하는 구슬 없음 -> 그대로 받으면 됨
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] D = new int[M];	// 마법 방향
		int[] S = new int[M];	// 마법 거리
		
		// 마법 시전 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			D[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		// 중앙부터 좌표 순서를 저장하는 배열 생성
		size = N * N;
		line = new Pos[size]; 
		linearize();
		
		/*
		line 배열 확인
		int[][] test = new int[N][N];
		int num = 0;
		for (int i = 0; i < N * N; i++) {
			Pos p = line[i];
			test[p.r][p.c] = num++;
		}
		
		System.out.println(Arrays.deepToString(test).replace("], ", "]\n"));
		*/
		
		/////////////////////// 마법 연습 ///////////////////////
		// 방향 벡터 재설정 : 0, 상, 하, 좌, 우 
		dr = new int[] {0, -1, 1, 0, 0};
		dc = new int[] {0, 0, 0, -1, 1};
		
		score = 0;
		
		// 마법 시전 횟수 만큼 진행
		for (int n = 0; n < M; n++) {
			blizzard(D[n], S[n]);
			removeBlank();
			bomb();
		}
		System.out.println(score);
	}
	// 폭발
	private static void bomb() {
		Stack<Integer> stack = new Stack<>();
		
		while(true) {
			boolean flag = false;
			int cnt = 1;
			int bf = 0;
			for (int i = 1; i < size; i++) {
				Pos p = line[i];
				int num = map[p.r][p.c];
				if (num == 0) break;
				if (bf == num) cnt++;
				else {
					// 4 개이상 연속하는 구슬이 있을 때
					if (cnt >= 4) {
						flag = true;
						// 구슬 번호 * 폭발한 구슬 개수 만큼 점수 추가
						score += bf * cnt;
						// 터진 구슬 제거
						for (int j = 0; j < cnt; j++) {
							stack.pop();
						}
					}				
					cnt = 1;
				}
				stack.add(num);
				bf = num;
			}
			
			// 4 개이상 연속하는 구슬이 있을 때
			if (cnt >= 4) {
				flag = true;
				// 구슬 번호 * 폭발한 구슬 개수 만큼 점수 추가
				score += bf * cnt;
				// 터진 구슬 제거
				for (int j = 0; j < cnt; j++) {
					stack.pop();
				}
			}		
			
			if(!flag) {
				if(!stack.isEmpty()) replace(stack);				
				return;
			}
			
			int idx = size - 1;
			for (;idx > stack.size(); idx--) {
				Pos p = line[idx];
				map[p.r][p.c] = 0;
			}
			
			while(!stack.isEmpty()) {
				Pos p = line[idx--];
				map[p.r][p.c] = stack.pop();
			}
		}
		
	}
	private static void replace(Stack<Integer> stack1) {
		int len = stack1.size();
		Stack<Num> stack2 = new Stack<>();
		int cnt = 1;
		int bf = stack1.pop();
		while(!stack1.isEmpty()) {
			int num = stack1.pop();
			if (bf == num) {
				cnt++;
			}
			else {
				stack2.add(new Num(bf, cnt));
				cnt = 1;
			}
			if (stack1.isEmpty()) {
				stack2.add(new Num(num, cnt));
				break;
			}
			bf = num;
		}
		
		int idx = 1;
		while(!stack2.isEmpty()) {
			Num n = stack2.pop();	
			if (idx >= size) break;
			Pos p = line[idx++];
			map[p.r][p.c] = n.cnt;
			if (idx >= size) break;
			p = line[idx++];
			map[p.r][p.c] = n.val;
		}
		for (;idx <= len; idx++) {
			Pos p = line[idx];
			map[p.r][p.c] = 0;
		}
		
		
	}
	// 당겨서 빈 칸 제거
	private static void removeBlank() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < size; i++) {
			Pos p = line[i];
			int num = map[p.r][p.c];
			if (num == 0) continue;
			q.add(num);
			map[p.r][p.c] = 0;
		}
		
		int idx = 1;
		while(!q.isEmpty()) {
			Pos p = line[idx++];
			map[p.r][p.c] = q.poll();
		}
		
	}
	// 블리자드 시전
	private static void blizzard(int d, int s) {
		int r = N / 2;
		int c = N / 2;
		
		// 시전 범위만큼 진행
		for (int i = 0; i < s; i++) {
			r += dr[d];
			c += dc[d];
			// 빈칸 0으로 표시
			map[r][c] = 0;
		}
	}
	// 중앙부터 좌표 순서를 저장하는 배열 생성
	private static void linearize() {
		int idx = 0;
		int r = N / 2;
		int c = N / 2;
		line[idx++] = new Pos(r, c);
		
		int dir = 0;
		int len = 1;
		outer:
		while (true) {
			// 2 가지 방향씩 반복
			for (int n = 0; n < 2; n++) {
				for (int i = 0; i < len; i++) {
					r += dr[dir];
					c += dc[dir];
					line[idx++] = new Pos(r, c);
					if (idx == size) break outer;
				}
				dir = (dir + 1) % 4;
			}			
			len++;
		}
	}
}
