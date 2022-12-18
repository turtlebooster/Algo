package baekjoon;

import java.util.Scanner;

public class BOJ_골드2_1300_K번째수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        // 이분탐색
        long s = 1;
        long e = K;
        long mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;
            long cnt = 0;

            // mid 이하 숫자 개수 합
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (K <= cnt) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        System.out.println(s);
        sc.close();
    }
}
