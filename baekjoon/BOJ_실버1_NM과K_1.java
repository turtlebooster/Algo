package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버1_NM과K_1 {
    static int N, M, K, max;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        max = Integer.MIN_VALUE;
        comb(0, -1, 0, 0);

        System.out.println(max);
        br.readLine();
    }

    public static void comb(int r, int c, int cnt, int sum) {
        if (cnt >= K) {
            max = Math.max(max, sum);
            return;
        }

        boolean over = c + 1 >= M;
        int is = over ? r + 1 : r;
        int js = over ? 0 : c + 1;

        for (int i = is; i < N; i++) {
            for (int j = js; j < M; j++) {
                // 인접 체크
                if (i - 1 >= 0 && visited[i - 1][j]) continue;
                if (j - 1 >= 0 && visited[i][j - 1]) continue;

                visited[i][j] = true;
                comb(i, j, cnt + 1, sum + map[i][j]);
                visited[i][j] = false;
            }
            js = 0;
        }
    }
}
