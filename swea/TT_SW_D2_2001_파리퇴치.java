package swea;

import java.util.Scanner;

public class TT_SW_D2_2001_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 파리 배열 N X N
			int[][] map = new int[N][N];
			int M = sc.nextInt();	// 파리채 크기 M X M
			
			
			// 파리 배열 담기
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					map[i][j] = sc.nextInt();
//				}				
//			}
			
			// 누적 합 활용
			// 파리 배열 담으면서 누적 합 이용 0,0 ~ i,j 위치까지의 사각 범위 합
			int[][] sum = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					sum[i][j] = map[i][j];
					
					if (i > 0) sum[i][j] += sum[i - 1][j];
					if (j > 0) sum[i][j] += sum[i][j - 1];
					if (i > 0 && j >0) sum[i][j] -= sum[i - 1][j - 1];					
				}				
			}
			// 파리채 범위 합 최대 찾기
			for (int i = M - 1; i < N; i++) {
				for (int j = M - 1; j < N; j++) {
					
				}				
			}
			
			
			
			// 파리채 크기 파리 합 최대인것 찾기
			/*
			// 옆으로 이동할때는 끝줄만 더하고 빼서 구하기
			int max = 0; // 합의 최댓값 저장할 변수
			for (int i = 0; i <= N - M; i++) {
				int sum = 0;
				for (int j = 0; j <= N - M; j++) {
					if (j == 0) { // 제일 왼쪽일때 해당 범위 합 구하기
						// i, j 위치부터 파리채 크기만큼의 합
						for (int r = i; r < i + M; r++) {
							for (int c = j; c < j + M; c++) {
								sum += map[r][c];
							}						
						}
					} else {	// 이외의 경우 이전 sum - 이전 왼쪽 끝줄 + 오른쪽 끝줄 
						for (int r = i; r < i + M; r++) {
							sum = sum - map[r][j - 1] + map[r][j + M - 1];
						}
					}
					// 합이 구해지면 최대인지 체크
					max = Math.max(sum, max);
				}				
			}
			*/
			
			/*
			// 순서대로 무작정 다 더하면서 훑기
			int max = 0; // 합의 최댓값 저장할 변수
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;
					// i, j 위치부터 파리채 크기만큼의 합
					for (int r = i; r < i + M; r++) {
						for (int c = j; c < j + M; c++) {
							sum += map[r][c];
						}						
					}
					// 합이 구해지면 최대인지 체크
					max = Math.max(sum, max);
				}				
			}
			*/
			
			
			// max 인 합을 출력
			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}
}
