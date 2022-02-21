package baekjoon;

import java.util.Scanner;

public class BOJ_실버4_1205_등수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] scores = new int[N];
		int nscore = sc.nextInt();
		int maxrank = sc.nextInt();
		int rank = 1;
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
			if (scores[i] > nscore) rank++;
			else if (scores[i] == nscore) cnt++;
		}
		
		if (rank + cnt <= maxrank) {
			System.out.println(rank);
		} else {
			System.out.println(-1);
		}
		sc.close();
	}
}
