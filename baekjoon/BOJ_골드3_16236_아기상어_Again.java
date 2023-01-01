package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드3_16236_아기상어_Again {
    static class Baby {
        // 위치, 먹은 물고기 수, 크기
        int r, c, cnt;
        int lv = 2;

        public Baby(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static Baby baby;
    static int N, time;
    // 사방 탐색
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 공간 크기
        N = Integer.parseInt(br.readLine());

        // 공간 상태 입력
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    // 아기 상어일 경우
                    num = 0;
                    baby = new Baby(i, j);
                }
                board[i][j] = num;
            }
        }
        int[] next;
        // 먹을 수 있는 물고기가 없을 때까지 진행
        do {
            next = search();
        } while (next[0] != -1);

        System.out.println(time);
        br.close();
    }

    static int[] search() {
        int[] pos = {-1, -1};

        boolean[][] visited = new boolean[N][N];
        // 이동 수 적은 순 > r 좌표 작은 순 > c 좌표 작은 순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> {
            if (i1[0] != i2[0]) return i1[0] - i2[0];
            if (i1[1] != i2[1]) return i1[1] - i2[1];
            return i1[2] - i2[2];
        });

        visited[baby.r][baby.c] = true;
        // 이동 수, r 좌표, c 좌표
        pq.add(new int[] {0, baby.r, baby.c});

        int add = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = pq.poll();

                int r = curr[1];
                int c = curr[2];

                if (board[r][c] != 0 && board[r][c] != baby.lv) {
                    board[r][c] = 0;
                    pos[0] = baby.r = r;
                    pos[1] = baby.c = c;

                    if (baby.cnt + 1 == baby.lv) {
                        baby.cnt = 0;
                        baby.lv++;
                    } else {
                        baby.cnt += 1;
                    }
                    time += add;

                    return pos;
                }

                // 4방 탐색
                for (int d = 0; d < 4; d++) {
                    int nr = curr[1] + dr[d];
                    int nc = curr[2] + dc[d];

                    // 범위, 방문 체크, 물고기 크기 비교
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (visited[nr][nc]) continue;
                    if (board[nr][nc] > baby.lv) continue;
                    visited[nr][nc] = true;
                    pq.add(new int[] {add, nr, nc});
                }
            }
            // 시간 추가
            add++;
        }

        return pos;
    }
}
