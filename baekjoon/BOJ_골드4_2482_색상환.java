package baekjoon;

import java.util.Scanner;

public class BOJ_골드4_2482_색상환 {
    public static final int MOD = 1_000_000_003;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        // dp[i][j] i 개 중 j 개를 인접하지 않게 고르는 방법의 수
        int[][] dp = new int[N + 1][K + 1];

        // 초기화
        // 1 개 고르기 -> i 가지 / 0 개 고르기 -> 1 가지
        for (int i = 0; i <= N; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        // dp 계산
        for (int i = 2; i < N; i++) {
            for (int j = 2; j <= K; j++) {
                // i 번째 자리를 고르는 경우의 수 + 고르지 않는 경우의 수
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.println((dp[N - 1][K] + dp[N - 3][K - 1]) % MOD);
        sc.close();
    }
}
