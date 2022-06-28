package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_골드5_2565_전깃줄 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 전깃줄의 수
		
		int[][] line = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			line[i][0] = sc.nextInt();
			line[i][1] = sc.nextInt();
		}
		
		// A 번호 낮은 순 정렬
		Arrays.sort(line, (l1, l2) -> l1[0] - l2[0]);
		
		// dp[i] i 번째 전깃줄까지 봤을때 겹치지 않게 설치할 수 있는 전깃줄의 최대 개수
		int[] dp = new int[N];
		// 설치할 수 있는 최대 전깃줄 개수
		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;	// 자기 자신
			// 이전의 전깃줄과 겹치는지 안겹치는지 판단
			for (int j = 0; j < i; j++) {
				// 이전의 전깃줄과 겹치면 패스
				if (line[i][1] < line[j][1]) continue;
				// dp[j] + 1 -> j 까지 겹치지 않으므로 j 까지 최대 개수 + 자기 자신
				if (dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;				
			}
			// 최대 전깃줄 개수 갱신
			if (max < dp[i]) max = dp[i];
		}
		
		System.out.println(N - max);
		sc.close();
	}
}
