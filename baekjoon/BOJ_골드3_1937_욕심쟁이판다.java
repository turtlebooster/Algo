package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드3_1937_욕심쟁이판다 {
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 대나무 숲 크기
        N = Integer.parseInt(br.readLine());
        // 대나무 숲 정보 입력
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // r, c 에서 시작 했을 때의 최대 방문 칸 저장
        dp = new int[N][N];
        int ans = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, search(i, j));
            }
        }

        System.out.println(ans);
        br.close();
    }

    static int search(int r, int c) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        // 초기값 1년 (최소 1년)
        dp[r][c] = 1;

        // 4방 탐색
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위 체크
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            // 이동 조건 - 대나무가 더 많은지 체크
            if (map[r][c] >= map[nr][nc]) continue;

            dp[r][c] = Math.max(dp[r][c], search(nr, nc) + 1);
        }

        return dp[r][c];
    }
}
