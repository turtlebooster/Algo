package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_골드2_27086_점수내기 {
    static int MOD = 998_244_353;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int[] score = new int[N];
        int tokkiScore = score[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);

        int[] sum = new int[N];
        int cnt = 0;
        sum[N - 1] = score[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + score[i];
            if (sum[i] == sum[i + 1]) cnt++;
        }

        long total = 0;
        int tokki = 0;

        for (int i = 1; i < N; i++) {
            long d = (sum[i] - (N - i) * score[i - 1]);
            total += (d / x * y) % MOD;
            total %= MOD;
        }

        total += ((N * (N - 1)) / 2 - cnt) * y;
        total %= MOD;

        System.out.println(total + " " + tokki);
        br.close();
    }
}
