package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드4_4913_페르마의크리스마스정리 {
    static final int N = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 소수 찾기
        boolean[] prime = new boolean[N];
        boolean[] visited = new boolean[N];

        for (int i = 2; i < N; i++) {
            if (visited[i]) continue;

            prime[i] = true;
            for (int j = i; j < N; j += i) {
                visited[j] = true;
            }
        }

        // 누적 소수 개수
        int[] cntSum = new int[N];
        // 제곱수 합 개수
        int[] powSum = new int[N];

        cntSum[2] = 1;
        powSum[2] = 1;
        for (int i = 3; i < N; i++) {
            if (prime[i]) cntSum[i] = cntSum[i - 1] + 1;
            else cntSum[i] = cntSum[i - 1];

            if (prime[i] && (i % 4) == 1) powSum[i] = powSum[i - 1] + 1;
            else powSum[i] = powSum[i - 1];
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());

            // L, U 모두 -1 이면 종료
            if (L == -1 && U == -1) break;

            int s, e;
            if (L < 1) s = 1;
            else s = L;

            if (U < 0) e = 0;
            else e = U;

            System.out.println(L + " " + U + " " + (cntSum[e] - cntSum[s - 1]) + " " + (powSum[e] - powSum[s - 1]));
        }

        br.close();
    }
}
