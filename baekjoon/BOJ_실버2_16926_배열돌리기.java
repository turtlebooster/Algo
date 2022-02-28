package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버2_16926_배열돌리기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 행의 수
		int M = sc.nextInt();	// 열의 수
		int R = sc.nextInt();	// 회전의 수
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < R; i++) {
			arr = rotate(arr);
		}
		
		System.out.println(Arrays.deepToString(arr).replace("], [", "\n").replaceAll("[\\[\\,\\]]", ""));
		sc.close();		
	}
	
	private static int[][] rotate (int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		int[][] nArr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 왼쪽으로 오는거 받는 구간
				if (i < N / 2 && i <= j && j <= (M - 1) - i - 1) {
					nArr[i][j] = arr[i][j + 1];
				}
				// 오른쪽으로 오는거 받는 구간
				if ((N % 2 == 0 ? i >= N / 2 : i > N / 2) && (N - 1) - i + 1 <= j && j <= (M - 1) - ((N - 1) - i)) {
					nArr[i][j] = arr[i][j - 1];
				}				
				// 아래로 오는거 받는 구간
				if (j < M / 2 && j + 1 <= i && i <= (N - 1) - j) {
					nArr[i][j] = arr[i - 1][j];
				}				
				// 위로 오는거 받는 구간
				if ((M % 2 == 0 ? j >= M / 2 : j > M / 2) && (M - 1) - j <= i && i <= (N - 1) - ((M - 1) - j) - 1) {
					nArr[i][j] = arr[i + 1][j];
				}				
			}			
		}		
		return nArr;
	}
}
