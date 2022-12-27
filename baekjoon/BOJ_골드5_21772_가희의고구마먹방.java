package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드5_21772_가희의고구마먹방 {
    static int R, C, T, max;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로, 가로, 이동시간
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // 시작 위치
        int r = -1;
        int c = -1;

        // 주어진 맵
        board = new char[R][];
        for (int i = 0; i < R; i ++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (board[i][j] != 'G') continue;
                r = i;
                c = j;
            }
        }

        // 탐색 진행
        dfs(r, c, 0, T);

        System.out.println(max);
        br.readLine();
    }

    static void dfs (int r, int c, int cnt, int t) {
        // 시간 만료
        if (t <= 0) {
            max = Math.max(max, cnt);
            return;
        }

        // 4방 탐색
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위 체크
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            // 장애물 체크
            if (board[nr][nc] == '#') continue;
            // 고구마 체크
            boolean isS = board[nr][nc] == 'S';

            if (isS) board[nr][nc] = '.';
            dfs(nr, nc, isS ? cnt + 1 : cnt, t - 1);
            if (isS) board[nr][nc] = 'S';
        }
    }
}
