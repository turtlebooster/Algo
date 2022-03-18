package baekjoon;

import java.util.Scanner;

public class BOJ_실버2_14569_시간표짜기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 데이터 입력
		int N = sc.nextInt();	// 총 과목 수
		long[] lecture = new long[N];
		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();	// 수업시간의 수
			for (int j = 0; j < k; j++) {
				lecture[i] = lecture[i] | 1L << sc.nextInt();
			}
		}
		
		int M = sc.nextInt();	// 학생 수
		long[] empty = new long[M];
		for (int i = 0; i < M; i++) {
			int p = sc.nextInt();	// 비어있는 교시 개수
			for (int j = 0; j < p; j++) {
				empty[i] = empty[i] | 1L << sc.nextInt();
			}
		}
		
		// 각 학생들의 들을 수 있는 과목 개수 출력
		// 각 학생들마다 출력
		for (int i = 0; i < M; i++) {
			// 들을 수 있는 과목 개수 카운트
			int cnt = 0;
			// 총 과목들에 대해 비교
			for (int j = 0; j < N; j++) {
				// 비어있는시간에 수업 시간이 모두 포함되면 들을 수 있음
				if ((lecture[j] & empty[i]) == lecture[j]) cnt++;
			}
			System.out.println(cnt);
		}		
		
		sc.close();
	}
}
