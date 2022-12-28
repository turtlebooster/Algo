package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_2023_신기한소수 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력
        N = sc.nextInt();

        // 탐색 및 출력
        int[] nums = {2, 3, 5, 7};
        for (int num : nums) {
            search(num, 1);
        }

        sc.close();
    }

    static void search(int curr, int cnt) {
        // N 자리 수 일경우 출력
        if (cnt == N) {
            System.out.println(curr);
            return;
        }

        for (int num = 1; num < 10; num++) {
            int next = curr * 10 + num;
            // 소수 체크
            if (!isPrime(next)) continue;
            search(next, cnt + 1);
        }
    }

    static boolean isPrime(int num) {
        double lim = Math.sqrt(num);
        for (int i = 2; i <= lim; i++) {
            if (num % i != 0) continue;
            return false;
        }
        return true;
    }
}
