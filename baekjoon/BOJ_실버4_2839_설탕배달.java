package baekjoon;

import java.util.Scanner;

public class BOJ_실버4_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		
		
		dp[3] = 1;
		if (N >= 5) dp[5] = 1;
		
		for (int i = 6; i <= N; i++) {
			if (dp[i - 5] == 0 && dp[i - 3] == 0) {
				dp[i] = 0;
			}
			else if (dp[i - 5] * dp[i - 3] == 0) {
				dp[i] = Math.max(dp[i - 5], dp[i - 3]) + 1;				
			} else {
				dp[i] = Math.min(dp[i - 5], dp[i - 3]) + 1;				
			}
		}
		
		System.out.println(dp[N] == 0 ? -1 : dp[N]);
		sc.close();
	}
}

/*
public class BOJ_실버4_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int ans = -1;
		
		for (int i = N / 5; i >= 0; i--) {
			if ((N - i * 5) % 3 != 0) continue;			
			ans = i + ((N - i * 5) / 3);
			break;
		}
		
		System.out.println(ans);
		sc.close();
	}
}
*/