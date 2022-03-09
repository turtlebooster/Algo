package baekjoon;

import java.util.Scanner;

public class BOJ_실버2_11722_가장긴감소하는부분수열 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 수열의 크기
		int[] arr = new int[N];	// 수열 
		int[] cnt = new int[N];	// cnt[i] : i 자리부터 시작하는 가장 긴 감소 부분 수열 길이
		
		// 데이터 입력
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 1;	// 가장 긴 길이
		for (int i = N - 1; i >= 0; i--) {
			cnt[i] = 1;	// 초기값 1 - 자기 자신만 될 경우
			for (int j = N - 1; j > i; j--) {
				if (arr[i] > arr[j]) cnt[i] = Math.max(cnt[i], cnt[j] + 1);
			}
			max = Math.max(cnt[i], max);
		}
		
		System.out.println(max);
		sc.close();
	}
}
