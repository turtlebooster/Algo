package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_11726_2xn타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 1 ~ 1000 	2 x n 크기 직사각형 채우기
		int[] dp = new int[n + 1];	// dp[i] : 2 x i 크기 직사각형 채우는 방법의 수
		
		dp[0] = 1;
		dp[1] = 1;
		
		
		// 방법1: 한 칸 적은 직사각형 옆에 긴 타일 하나 붙이기
        // 방법2: 두 칸 적은 직사각형 옆에 눕힌 타일 2개 쌓아서 붙이기
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		
		
		System.out.println(dp[n]);
		sc.close();
	}
}
