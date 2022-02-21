package swea;

import java.util.Scanner;

public class SW_D2_1979_어디에단어가들어갈수있을까 {
	/*
	 * N x N 크기 퍼즐이 주어짐
	 * K 길이의 단어가 들어갈 수 있는 자리의 수 찾기
	 * 
	 * 문자 들어갈 수 있는 공간 1, 들어갈 수 없는 공간 0
	 * 길이와 정확히 일치한 가로 세로에만 단어가 들어갈 수 있음
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	// 테스트케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;			// 들어갈 수 있는 자리의 수
			int N = sc.nextInt();	// 퍼즐 크기
			int K = sc.nextInt();	// 단어 길이
			int[][] board = new int[N][N];	// 퍼즐 담을 배열
			
			// 퍼즐 정보 세팅
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			// K 길이 자리 찾아 카운팅
			for (int i = 0; i < N; i++) {
				int r = 0, c = 0; // 행 방향 열 방향 1 연속 갯수 기록
				for (int j = 0; j < N; j++) {
					// 행 방향 체크
					if (board[i][j] == 0) {	// 0을 만남
						if (r == K) ans++;	// 0을 만날때까지 연속한 1이 K 개이면 1개 추가
						r = 0;				// 연속 1 갯수 초기화
					}
					else {	// 1을 만남
						r++;	// 연속 1 갯수 추가
					}
					// 열 방향 체크
					// 행 방향 체크
					if (board[j][i] == 0) {	// 0을 만남
						if (c == K) ans++;	// 0을 만날때까지 연속한 1이 K 개이면 1개 추가
						c = 0;				// 연속 1 갯수 초기화
					}
					else {	// 1을 만남
						c++;	// 연속 1 갯수 추가
					}					
				}
				// 연속인 채로 끝자리를 만나면
				if (r == K) ans++;	// 연속한 1이 K 개이면 1개 추가
				if (c == K) ans++;	// 연속한 1이 K 개이면 1개 추가
			}		
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
