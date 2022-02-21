package swea;

import java.util.Scanner;

public class SW_D3_1220_Magnetic {
	public static void main(String[] args) {
		/*
		 * N극
		 * 1 은 아래로, 2 는 위로
		 * S극
		 * 
		 * 1 형태가 되면 교착상태
		 * 2
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 정사각형 테이블 길이
			int[][] arr = new int[N][N];
			int cnt = 0;
			
			// 입력 받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
						
			// 열마다 탐색 -> 열 번호 고정 행 번호 변화 탐색
			for (int j = 0; j < N; j++) {
				boolean check = false;
				// 12 로 붙어있는 갯수 카운트
				// 1을 새로 발견한 이후부터 2가 발견되면 카운트 추가
				for (int i = 0; i < N; i++) {
					if (arr[i][j] ==  1) check = true;
					else if (check && arr[i][j] == 2) {
						cnt++;
						check = false;
					}
				}
				
			}			
			
			// 케이스 정답 출력
			System.out.printf("#%d %d\n", tc, cnt);
		}		
		
		sc.close();
	}
	
	
//	for 문이 너무 많아....
//	public static void main(String[] args) {
//		/*
//		 * N극
//		 * 1 은 아래로, 2 는 위로
//		 * S극
//		 * 
//		 * 1 형태가 되면 교착상태
//		 * 2
//		 * 
//		 */
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int T = 10;
//		
//		for(int tc = 1; tc <= T; tc++) {
//			int N = sc.nextInt(); // 정사각형 테이블 길이
//			int[][] arr = new int[N][N];
//			int cnt = 0;
//			
//			// 입력 받기
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					arr[i][j] = sc.nextInt();
//				}
//			}
//						
//			// 열마다 탐색 -> 열 번호 고정 행 번호 변화 탐색
//			for (int j = 0; j < N; j++) {
////				// 위쪽 끝 부터 1 발견 전까지 2 제거
////				for (int i = 0; i < N; i++) {
////					if(arr[i][j] == 1) break;
////					arr[i][j] = 0;
////				}
////				
////				
////				// 아래쪽 끝 부터 2 발견 전까지 1 제거
////				for (int i = N - 1; i >= 0; i--) {
////					if(arr[i][j] == 2) break;
////					arr[i][j] = 0;
////				}
//				
//				
//				// 12 로 붙어있는 갯수 카운트
//				for (int i = 0; i < N - 1; i++) {
//					if (arr[i][j] == 1) {
//						for (int k = i + 1; k < N ; k++) {
//							if (arr[k][j] == 1) break;
//							else if (arr[k][j] == 2) {
//								cnt++;
//								break;
//							}
//						}
//					}
//				}
//				
//			}			
//			
//			// 케이스 정답 출력
//			System.out.printf("#%d %d\n", tc, cnt);
//		}		
//		
//		sc.close();
//	}
	
}
