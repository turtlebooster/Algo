package swea;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_D2_1961_숫자배열회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 행렬 크기
			int[][] arr90 = new int[N][N];	// 90도 회전 행렬
			
			
			for (int j = N - 1; j >= 0;j--) {
				for (int i = 0; i < N; i++) {
					arr90[i][j] = sc.nextInt();
				}
			}
			
			int[][] arr180 = rotation90(arr90);	//180도 회전 행렬
			int[][] arr270 = rotation90(arr180);	//270도 회전 행렬
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println();				
			}
			
			
		}
		sc.close();
	}
	
	private static int[][] rotation90 (int[][] arr) {
		String s = "";
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				s += arr[i][j] + " ";
			}
		}
		
		StringTokenizer st = new StringTokenizer(s);
		
		int[][] arr90 = new int[N][N];
		for (int j = N - 1; j >= 0;j--) {
			for (int i = 0; i < N; i++) {
				arr90[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		return arr90;
	}
	
}
