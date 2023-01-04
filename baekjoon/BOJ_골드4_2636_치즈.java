package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_2636_치즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로, 가로 길이 입력
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 치즈 분포 입력
        Queue<int[]> q = new LinkedList<>();
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                if (Integer.parseInt(st.nextToken()) != 1) continue;
                map[i][j] = 1;
                q.add(new int[] {i, j});
            }
        }

        int time = 0;
        int[][] remove = new int[R * C][2];
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, 1, -1, 0};
        // 녹일 치즈 개수
        int cnt = 0;
        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            cnt = 0;

            // 외부 공기 설정
            boolean[][] visited = new boolean[R][C];
            Queue<int[]> airQ = new LinkedList<>();
            visited[0][0] = true;
            airQ.add(new int[] {0, 0});

            while (!airQ.isEmpty()) {
                int[] a = airQ.poll();
                int r = a[0];
                int c = a[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (visited[nr][nc] || map[nr][nc] == 1) continue;
                    visited[nr][nc] = true;
                    map[nr][nc] = -1;
                    airQ.add(new int[] {nr, nc});
                }
            }

            // 녹일 치즈 선정
            outer:
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                int r = p[0];
                int c = p[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (map[nr][nc] == -1) {
                        remove[cnt++] = new int[] {r, c};
                        continue outer;
                    }
                }
                q.add(p);
            }

            // 치즈 녹이기
            for (int i = 0; i < cnt; i++) {
                map[remove[i][0]][remove[i][1]] = -1;
            }

            // 치즈가 모두 녹아 없어 지면 종료
        }

        System.out.println(time);
        System.out.println(cnt);
        br.close();
    }
}
