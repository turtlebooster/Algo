package swea;

import java.util.Scanner;

public class SW_D2_1959_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int j = 0; j < M; j++) {
				B[j] = sc.nextInt();
			}
						
			int[][] arr = new int[2][];
			if (N <= M)	{
				arr[0] = A;
				arr[1] = B;				
			} else {
				arr[0] = B;
				arr[1] = A;				
			}
			
			int[] sum = new int[arr[1].length - arr[0].length + 1];
			
			for (int i = 0; i < arr[1].length - arr[0].length + 1; i++) {
				for (int j = i; j < arr[0].length + i; j++) {
					sum[i] += arr[0][j - i] * arr[1][j];
				}
			}
			
			int maxIdx = 0;
			for (int i = 0; i < sum.length; i++) {
				if (sum[maxIdx] < sum[i]) maxIdx = i;
			}
			
			System.out.printf("#%d %d\n", tc, sum[maxIdx]);
			
		}
		
		sc.close();
		
	}
}
