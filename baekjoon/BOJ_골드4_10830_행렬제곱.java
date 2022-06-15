package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_골드4_10830_행렬제곱 {
	static int N;
	static long B;
	static int[][] A;
	static int[][][] memory;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		B = sc.nextLong();		
		
		memory = new int[42][][];
		int[][] arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N ; j++) {				
				arr[i][j] = sc.nextInt() % 1000;
			}
		}
		
		
		if (B == 1) {
			A = arr;			
		} else {
			memory[0] = arr;
			int idx = 0;			
			while (Math.pow(2, idx + 1) < B) {
				memory[idx + 1] = calc(memory[idx], memory[idx]);
				idx++;
			}
			A = memory[idx];
			long rest = (long)(B - Math.pow(2, idx));
			long pow = (long)Math.pow(2, idx);
			while (rest != 0) {				
				for (int i = idx; i >= 0; i--) {
					if ( pow <= rest) {
						idx = i;
						rest -= pow;
						break;
					}		
					pow /= 2;
				}				
				A = calc(A, memory[idx]);
			}			
		}
		
		System.out.println(Arrays.deepToString(A).replace("], ", "]\n").replaceAll("[\\[\\,\\]]", ""));
		sc.close();
	}
	
	public static int[][] calc(int[][] arr1, int[][] arr2) {
		int[][] res = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += arr1[i][k] * arr2[k][j];
				}
				res[i][j] %= 1000;
			}
		}
		
		return res;
	}
}
