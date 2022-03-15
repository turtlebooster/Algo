package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_2579_계단오르기 {
	static int N, max;
	static int[] scores;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 단어의 개수
		
		scores = new int[N];
		
		for(int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
		}		
		
		max = 0;
		
		stairs(0, 0, 0);
		
		stairs(1, 0, 0);
		
		System.out.println(max);		
		sc.close();
	}
	
	public static void stairs(int now, int from, int sum) {
		
		if (now >= N) return;
		
		sum += scores[now];		
		
		if (now == N - 1) {
			max = Math.max(max, sum);
			return;
		}
		

		if (now == 0 || from != now - 1) stairs(now + 1, now, sum);
		stairs(now + 2, now, sum);	
		
	}
}
