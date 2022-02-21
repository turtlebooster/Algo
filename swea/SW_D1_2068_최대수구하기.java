package swea;

import java.util.Scanner;

public class SW_D1_2068_최대수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] max = new int[T];
		
		for(int i = 1; i < T; i++) {
			max[i] = 0;
		}
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 10; j++) {
				max[i] = Math.max(max[i], sc.nextInt());
			}
		}
		sc.close();
		
		for (int i = 0; i < T; i++) {
			System.out.println("#" + (i + 1) + " " + max[i]);			
		}
	}
}
