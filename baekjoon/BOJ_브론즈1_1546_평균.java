package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈1_1546_평균 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] scores = new int[N];
		int max = 0;
		int sum = 0;
		
		for (int i = 0; i < N; i++) {			
			scores[i] = sc.nextInt();
			max = Math.max(scores[i], max);
			sum += scores[i];
		}
		System.out.println((double)sum / N / max * 100);
		sc.close();
	}
}