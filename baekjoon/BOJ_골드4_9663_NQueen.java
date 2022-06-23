package baekjoon;

import java.util.Scanner;

public class BOJ_골드4_9663_NQueen {
	static int N, cnt;
	static boolean[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new boolean[N][N];
		cnt = 0;		
		putQ(0, 0, 0, 0);
		
		System.out.println(cnt);		
		sc.close();
	}
	// 한 행에는 하나씩 놓기
	// 열, 대각선은 비트 연산자로 체크
	public static void putQ(int row, int col, int ru, int lu) {
		if (row == N) {
			cnt++;
			return;
		}
		
		for (int c = 0; c < N; c++) {
			// 세로줄 체크			
			int cbit = 1<<c; 
			if ((cbit & col) != 0) continue;
			
			// 오른 위 방향 대각선 줄 체크
			int rubit = 1<<(row + c); 
			if ((rubit & ru) != 0) continue;
			
			// 왼쪽 위 방향 대각선 줄 체크
			int lubit = 1<<(row - c + (N - 1)); 
			if ((lubit & lu) != 0) continue;	
			
			// 체크에 걸리지 않으면 놓기
			map[row][c] = true;
			col |= cbit;
			ru |= rubit;
			lu |= lubit;
			putQ(row + 1, col, ru, lu);
			
			// 원상복구			
			map[row][c] = false;
			col ^= cbit;
			ru ^= rubit;
			lu ^= lubit;
		}
		
	}
	
/*
	// 한 행에는 하나씩 놓기
	// 열은 비트 연산자로 체크
	public static void putQ(int row, int col) {
		if (row == N) {
			cnt++;
			return;
		}
		
		outer:
		for (int c = 0; c < N; c++) {
			int bit = 1<<c; 
			// 세로줄 체크			
			if ((bit & col) != 0) continue;
			if (row > 0) {
				// 오른 위 방향 대각선 줄 체크
				int sum = row + c;
				for (int r = row - 1; r >= 0; r--) {
					if (sum - r >= N) break;
					if (map[r][sum - r]) continue outer;
				}
				// 왼쪽 위 방향 대각선 줄 체크
				int sub = row - c;
				for (int r = row - 1; r >= 0; r--) {
					if (r - sub < 0) break;
					if (map[r][r - sub]) continue outer;
				}
			}			
			
			// 체크에 걸리지 않으면 놓기
			map[row][c] = true;
			col |= bit;
			putQ(row + 1, col);
			
			// 원상복구			
			map[row][c] = false;
			col ^= bit;
		}
		
	}
*/
}
