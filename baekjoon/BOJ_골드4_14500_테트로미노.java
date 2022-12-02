package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드4_14500_테트로미노 {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N, M, max;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 각 칸 데이터 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색 진행
        max = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;

                // 세로, ㅏ, ㅓ 모양
                if (i - 1 >= 0 && i + 1 < N) {
                    int sum = map[i - 1][j] + map[i][j] + map[i + 1][j];
                    if (j + 1 < M) max = Math.max(sum + map[i][j + 1], max);
                    if (j - 1 >= 0) max = Math.max(sum + map[i][j - 1], max);
                }

                // 가로, ㅜ, ㅗ 모양
                if (j - 1 >= 0 && j + 1 < M) {
                    int sum = map[i][j - 1] + map[i][j] + map[i][j + 1];
                    if (i + 1 < N) max = Math.max(sum + map[i + 1][j], max);
                    if (i - 1 >= 0) max = Math.max(sum + map[i - 1][j], max);
                }
            }
        }

        System.out.println(max);
        br.close();
    }

    static void dfs(int r, int c, int cnt, int sum) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (visited[nr][nc]) continue;
            if (cnt == 3) {
                max = Math.max(sum + map[nr][nc], max);
            } else {
                visited[nr][nc] = true;
                dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }
}
