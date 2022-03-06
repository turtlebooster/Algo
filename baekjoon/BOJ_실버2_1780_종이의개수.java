package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버2_1780_종이의개수 {
	/**
	 * 
	 * N X N 크기 종이
	 * 각 칸에는 -1, 0 , 1 중 하나가 저장됨
	 * 적절한 크기로 종이 자르는 규칙
	 * 1. 종이가 모두 같은 수로 이루어져있다면 -> 그대로 사용
	 * 2. 1이 아닌 경우 같은 크기의 종이 9개로 자르고, 각각의 종이에 대해 다시 1 확인
	 * 
	 * 
	 * input N						종이 크기
	 * 		 k11 k12 k13...k1N		각 자리의 숫자
	 * 		 ...	
	 * 		 kN1 kN2 kN3...kNN			
	 * 
	 * output c1					-1 로만 채워진 종이 수
	 * 		  c2					0 로만 채워진 종이 수
	 * 	      c3					1 로만 채워진 종이 수
	 * 
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */	
	static int[][] arr;	
	static int[] cnt = new int[3];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 종이의 크기
		// 종이 데이터 입력
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 종이 확인 작업
		check(0, N, 0, N);
		
		// 답 출력
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}
		
		br.close();
	}
	
	// 주어진 범위 내에서 하나의 수로 채워져있는지 확인
	public static void check(int is, int ie, int js, int je) {
		int num = arr[is][js];	// 첫 번째 자리의 수
		
		// 주어진 범위 내 탐색
		for (int i = is; i < ie; i++) {
			for (int j = js; j < je; j++) {
				// 한 가지 수가 아닐 경우
				if (num != arr[i][j]) {
					// 9가지로 잘라서 다시 확인
					int len = (ie - is) / 3;	// 잘라진 각 종이의 크기
					check (is, is + len, js, js + len);
					check (is, is + len, js + len, js + 2 * len);
					check (is, is + len, js + 2 * len, js + 3 * len);
					
					check (is + len, is + 2 * len, js, js + len);
					check (is + len, is + 2 * len, js + len, js + 2 * len);
					check (is + len, is + 2 * len, js + 2 * len, js + 3 * len);
					
					check (is + 2 * len, is + 3 * len, js, js + len);
					check (is + 2 * len, is + 3 * len, js + len, js + 2 * len);
					check (is + 2 * len, is + 3 * len, js + 2 * len, js + 3 * len);
					return;
				}
			}
		}
		
		switch (num) {
		case -1:
			cnt[0]++;
			break;
		case 0:
			cnt[1]++;
			break;
		case 1:
			cnt[2]++;
			break;
		}
	}
	
}
