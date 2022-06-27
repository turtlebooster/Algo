package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버5_2740_행렬곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] A = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		sc.nextInt();
		int K = sc.nextInt();
		
		int[][] B = new int[M][K];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < K; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		
		
		System.out.println(Arrays.deepToString(calc(A, B, N, M, K)).replace("], ", "\n").replaceAll("[\\[\\,\\]]", ""));
		sc.close();
	}
	
	public static int[][] calc(int[][] A, int[][] B, int N, int M, int K) {
		int[][] res = new int[N][K];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				for (int m = 0; m < M; m++) {
					res[i][j] += A[i][m] * B[m][j];
				}
			}
		}
		
		return res;
	}
}
