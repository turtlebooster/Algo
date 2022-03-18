package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_2630_색종이만들기 {
	static int[] cnt;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		map = new int[N][N];
		
		// 데이터 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}		
		cnt = new int[2];
		cut(0, 0, N);
		
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		
		sc.close();
	}
	
	public static void cut(int is, int js, int len) {
		// 첫번째 자리를 비교하기 위한 수로 사용
		int num = map[is][js];
		
		for (int i = is; i < is + len; i++) {
			for (int j = js; j < js + len; j++) {
				if (map[i][j] == num) continue;
				// 다른 값이 올 경우 종이를 4등분 하여 자름
				len /= 2;
				
				cut(is, js, len);
				cut(is, js + len, len);
				cut(is + len, js, len);
				cut(is + len, js + len, len);
				
				return;
			}
		}
		
		// 모든 값이 같으면 해당하는 종이 개수 + 1
		cnt[num]++;
	}
}
