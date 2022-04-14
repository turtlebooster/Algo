package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_test_5656_벽돌깨기 {
	static class Brick {
		int r;
		int range;
		public Brick(int r, int range) {
			this.r = r;
			this.range = range;
		}
	}
	static int N, W, H, min;
	static int[] sel, brickCnt;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {-1, 1, 0, 0};
	static int[][] map;
	static PriorityQueue<Brick> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 구슬 쏠 수 있는 방법 수
			W = Integer.parseInt(st.nextToken());	// 가로 길이
			H = Integer.parseInt(st.nextToken());	// 세로 길이
			
			map = new int[H][W];	// 벽돌 정보
			brickCnt = new int[W];		// 열 위치별 벽돌 수
			
			// 벽돌 정보 입력
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) brickCnt[j]++;
				}
			}
			
			// 어디 부터 시작할지 선택
			sel = new int[N];
			min = Integer.MAX_VALUE;
			choose(0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	private static void choose(int cnt) {
		if (cnt == N) {
			// 남은 벽돌 수 카운트
			int sum = 0;
			for (int i = 0; i < W; i++) sum += brickCnt[i];
//			System.out.println("===============================================");
//			System.out.println(Arrays.toString(sel));
//			System.out.println(Arrays.deepToString(map).replace("], ", "]\n"));
//			System.out.println("sum : " + sum);
//			System.out.println("===============================================");
			min = Math.min(min, sum);
 			return;
		}
		// 어느 열 터뜨릴지 선택
		// 벽돌이 없는 열은 통과
		boolean flag = false;
		for (int i = 0; i < W; i++) {
			if (brickCnt[i] == 0) continue;		
			flag = true;
			// 원래 상태 저장
			int[][] mapCopy = new int[H][];
			for (int j = 0; j < H; j++) mapCopy[j] = Arrays.copyOf(map[j], map[j].length);
			int[] temp = Arrays.copyOf(brickCnt, brickCnt.length);
			
			sel[cnt] = i;
			
			bomb(H - brickCnt[i], i);	// 벽돌 터뜨리기
			clear();	// 벽돌 내리기
//			System.out.println("cnt : " + cnt + " col : " + i);
//			System.out.println(Arrays.deepToString(map).replace("], ", "]\n"));
			choose(cnt + 1);
			
			// 원상복구
			map = mapCopy;
			brickCnt = temp;
		}
		if(!flag) choose(cnt + 1);
	}
	private static void clear() {
		pq = new PriorityQueue<Brick>((b1, b2) -> {
			if (b1.range * b2.range == 0) {
				// 벽돌 아닌게 있으면
				return b1.range - b2.range;
			}
			// 벽돌은 위치 순으로
			return b1.r - b2.r;
		});
		// 열 별로 저장 후 내리기
		for (int c = 0; c < W; c++) {
			// 각 열에 행 번호 순서대로 저장
			for (int r = 0; r < H; r++) {
				pq.add(new Brick(r, map[r][c]));
			}
			// 정렬된 순서로 재입력
			for (int r = 0; r < H; r++) {
				map[r][c] = pq.poll().range;
			}
		}
	}
	private static void bomb(int r, int c) {
//		int r = H - brickCnt[c];
		int range = map[r][c];
		map[r][c] = 0;
		brickCnt[c]--;
		if (range == 1) return;
		for (int d = 0; d < 4; d++) {
			for (int n = 1; n < range; n++) {
				int nr = r + n * dr[d];
				int nc = c + n * dc[d];
				// 범위 밖이면 그만
				if (nr < 0 || nr >= H || nc < 0 || nc >= W) break;
				// 해당 열에 벽돌이 없거나 벽돌이 아니면 다음 순서로
				if (brickCnt[nc] == 0 || map[nr][nc] == 0) continue;
				// 벽돌이면
				bomb(nr, nc);
			}
		}
	}
	
}
