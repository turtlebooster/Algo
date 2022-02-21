package swea;

import java.util.Scanner;

public class SW_D2_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			//3 5 7 9 11 13 -> 2 * N - 1
			// 오른j 아래i 왼j 위i 
			int[] endIdx = {N - 1, N - 1, 0, 1};
			int dirIdx = 0;
			int row = 0, col = 0;
			for (int i = 1; i <= N * N; i++) {				
				// 오른쪽으로 이동
				if (dirIdx == 0) {
					arr[row][col++] = i ;
					if (col > endIdx[dirIdx]) {
						row++;
						col--;
						endIdx[dirIdx]--;
						dirIdx++;
					}
				}
				// 아래로 이동
				else if (dirIdx == 1) {
					arr[row++][col] = i;
					if (row > endIdx[dirIdx]) {
						row--;
						col--;
						endIdx[dirIdx]--;
						dirIdx++;
					}
				}
				// 왼쪽으로 이동
				else if (dirIdx == 2) {
					arr[row][col--] = i;
					if (col < endIdx[dirIdx]) {
						row--;
						col++;
						endIdx[dirIdx]++;
						dirIdx++;
					}
				}
				// 위쪽으로 이동
				else if (dirIdx == 3) {
					arr[row--][col] = i;
					if (row < endIdx[dirIdx]) {
						row++;
						col++;
						endIdx[dirIdx]++;
						dirIdx = 0;
					}
				}
				
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
			
		}
		sc.close();
	}
}