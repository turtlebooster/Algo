package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_D3_1209_Sum {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
//			sc.nextInt();
//			int[][] arr = new int[100][100];
			
//			for (int i = 0; i < 100; i++) {				
//				for (int j = 0; j < 100; j++) {
//					arr[i][j] = sc.nextInt();
//				}					
//			}
			
			int[] sum = new int[2 * 100 + 2];
			
			// 행 합 0 ~ 99
			// 열 합 100 ~ 199
			// 대각선 합 200, 201
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					int num = Integer.parseInt(st.nextToken());
//					int num = sc.nextInt();
                    // 행 합
					sum[i] += num;
                    // 열 합
					sum[j + 100] += num;
                    // 대각선 합
					if (i == j)	sum[199 + 1] += num;
					else if (i + j == 100 - 1) sum[199 + 2] += num;
				}
			}
			
			// 선택정렬
			int maxIdx = 0;
			for (int i = 0; i < sum.length; i++) {
					if (sum[maxIdx] < sum[i]) maxIdx = i;
			}
						
			System.out.println("#" + tc + " " + sum[maxIdx]);
			
		}
		br.close();
	}
}
