package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1733_오목 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 1 ~ 19 를 인덱스로 활용하기위해 20 * 20 크기로 배열 생성
		int[][] board = new int[20][20];
		
		// 현재 바둑판 상태 저장
		for (int i = 1; i <=19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;		// 게임 결과   검은색 win: 1, 흰색 win: 2, 미정: 0
		int r = 0, c = 0; 	// 오목 달성했을경우 기준 돌 위치
//		int[][] dir = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
		outer:
		for (int i = 1; i <=19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (board[i][j] == 0) continue;				
				int dol = board[i][j];	// 체크할 돌
				
				/* 한 번에 해보려고했으나 실패
//				for (int k = 0; k < 4; k++) {
//					if (	i + 4 * dir[k][0] >= 0	&& i + 4 * dir[k][0] <= 19
//							&& j + 4 * dir[k][1] >= 0	&& j + 4 * dir[k][1] <= 19
//							) { // 15 를 넘어가면 오른쪽 방향으로 연속 5알 불가능  
//						// 5 알이 연속으로 같고 앞뒤를 체크해 6목 이상이 되는지 확인
//						for (int n = 1; n <= 4; n++) {
//							if (dol != board[i + n * dir[k][0]][j + n * dir[k][1]]) break;
//							if (n == 4) {
//								if (	i - dir[k][0] >= 0	&& i - dir[k][0] <= 19		// 인덱스 범위를 벗어나지 않도록
//										&& j - dir[k][1] >= 0 && j - dir[k][1] <= 19
//										&& dol == board[i - dir[k][0]][j - dir[k][1]]) break;	// 뒤쪽의 돌이 같아 6목 이상이 되는 경우
//								if (	i + 5 * dir[k][0] >= 0	&& i + 5 * dir[k][0] <= 19		// 인덱스 범위를 벗어나지 않도록
//										&& j + 5 * dir[k][1] >= 0 && j + 5 * dir[k][1] <= 19
//										&& dol == board[i + 5 * dir[k][0]][j + 5 * dir[k][1]]) break;	// 앞쪽의 돌이 같아 6목 이상이 되는 경우
//								result = dol;	// 게임 결과 저장
//								r = i;	c = j;	// 기준돌 위치 저장
//								break outer;
//							}
//						}					
//					} //체크 끝	
//				}
				*/				
				
				// 가로방향 체크
				if (j <= 15) { // 15 를 넘어가면 오른쪽 방향으로 연속 5알 불가능  
					// 5 알이 연속으로 같고 앞뒤를 체크해 6목 이상이 되는지 확인
					for (int n = 1; n <= 4; n++) {
						if (dol != board[i][j + n]) break;
						if (n == 4) {
							if (j - 1 >= 0 && dol == board[i][j - 1]) break;	// 뒤쪽의 돌이 같아 6목 이상이 되는 경우
							if (j + 5 <= 19 && dol == board[i][j + 5]) break;	// 앞쪽의 돌이 같아 6목 이상이 되는 경우
							result = dol;	// 게임 결과 저장
							r = i;	c = j;	// 기준돌 위치 저장
							break outer;
						}
					}					
				}// 가로 체크 끝
				// 세로방향 체크
				if (i <= 15) { // 15 를 넘어가면 아래 방향으로 연속 5알 불가능  
					// 5 알이 연속으로 같고 앞뒤를 체크해 6목 이상이 되는지 확인
					for (int n = 1; n <= 4; n++) {
						if (dol != board[i + n][j]) break;
						if (n == 4) {
							if (i - 1 >= 0 && dol == board[i - 1][j]) break;	// 뒤쪽의 돌이 같아 6목 이상이 되는 경우
							if (i + 5 <= 19 && dol == board[i + 5][j]) break;	// 앞쪽의 돌이 같아 6목 이상이 되는 경우
							result = dol;	// 게임 결과 저장
							r = i;	c = j;	// 기준돌 위치 저장
							break outer;
						}
					}
				}// 세로 체크 끝				
				// 대각선 방향 체크
				// 대각선 오른쪽 아래 방향
				if (i <= 15 && j <= 15) { // i, j 모두 15 넘어가면 오른쪽 아래방향 연속 5알 불가능
					// 5 알이 연속으로 같고 앞뒤를 체크해 6목 이상이 되는지 확인
					for (int n = 1; n <= 4; n++) {
						if (dol != board[i + n][j + n]) break;					
						if (n == 4) {
							if (i - 1 >= 0 && j - 1 >= 0 && dol == board[i - 1][j - 1]) break;		// 뒤쪽의 돌이 같아 6목 이상이 되는 경우
							if (i + 5 <= 19 && j + 5 <= 19 && dol == board[i + 5][j + 5]) break;	// 앞쪽의 돌이 같아 6목 이상이 되는 경우
							result = dol;	// 게임 결과 저장
							r = i;	c = j;	// 기준돌 위치 저장
							break outer;
						}
					}// for문 끝					
				}// 대각선 오른쪽 아래방향 체크 끝
				// 대각선 오른쪽 위 방향
				if (i >= 5 && j <= 15) { // i, j 모두 15 넘어가면 오른쪽 아래방향 연속 5알 불가능
					// 5 알이 연속으로 같고 앞뒤를 체크해 6목 이상이 되는지 확인
					for (int n = 1; n <= 4; n++) {
						if (dol != board[i - n][j + n]) break;
						if (n == 4) {
							if (i + 1 <= 19 && j - 1 >= 0 && dol == board[i + 1][j - 1]) break;	// 뒤쪽의 돌이 같아 6목 이상이 되는 경우
							if (i - 5 >= 0 && j + 5 <= 19 && dol == board[i - 5][j + 5]) break;	// 앞쪽의 돌이 같아 6목 이상이 되는 경우
							result = dol;	// 게임 결과 저장
							r = i;	c = j;	// 기준돌 위치 저장
							break outer;
						}
					}					
				}// 대각선 오른쪽 위방향 체크 끝
			}
		}// 전체 돌 체크 끝
		
		System.out.println(result);
		if (result != 0) System.out.println(r + " " + c);
		br.close();		
	}
}
