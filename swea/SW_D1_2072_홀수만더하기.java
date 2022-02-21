package swea;

import java.util.Scanner;

public class SW_D1_2072_홀수만더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] sum = new int[T];
		
		for(int i = 1; i < T; i++) {
			sum[i] = 0;
		}
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 10; j++) {
				int num = sc.nextInt();
				if ( num % 2 != 0) {
					sum[i] += num;					
				}
			}
		}
		sc.close();
		
		for (int i = 0; i < T; i++) {
			System.out.println("#" + (i + 1) + " " + sum[i]);			
		}
	}
}
