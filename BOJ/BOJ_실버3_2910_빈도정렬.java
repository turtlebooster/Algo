package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_2910_빈도정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		
		int[] count = new int[C + 1];
		
		for (int i = 0; i < N; i++) {
			count[sc.nextInt()] += 1;
		}
		
		for (int j = 0; j < N; j++) {			
			int maxIdx = 0;
			for (int i = C; i > 0; i--) {
				if (count[maxIdx] < count[i]) maxIdx = i;			
			}
			
			for (int i = 0; i < count[maxIdx]; i++) {
				System.out.printf("%d ", maxIdx);
			}
			count[maxIdx] = 0;
		}
		
		
		sc.close();
	}
}
