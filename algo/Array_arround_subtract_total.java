package algo;

import java.util.Arrays;

public class Array_arround_subtract_total {
	public static void main(String[] args) {
		int N = 5;
		int[][] arr = new int[N][N];
		
		int[] dr = {-1, 1, 0, 0};	//상하좌우
		int[] dc = {0, 0, -1, 1};	//상하좌우
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arr[r][c] = (int)(Math.random() * N);				
			}
		}
		
		for (int r = 0; r < N; r++) {
			System.out.println(Arrays.toString(arr[r]));			
		}
		System.out.println();
		
		// 좌표 상하좌우 차이 합 저장 행렬
		int[][] sum = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						sum[r][c] += Math.abs(arr[r][c] - arr[nr][nc]);
					}
				}
			}
		}
		
		for (int r = 0; r < N; r++) {
			System.out.println(Arrays.toString(sum[r]));			
		}
		System.out.println();
		
	}
}
