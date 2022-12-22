package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_골드5_13023_ABCDE {
    static boolean flag;
    static boolean[] visited;
    static List<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 관계 리스트 초기화
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 관계 리스트 작성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        // 방문체크 배열
        visited = new boolean[N];
        // 조건 만족 체크
        flag = false;

        // 사람 별 탐색
        for (int i = 0; i < N; i++) {
            if (flag) break;
            dfs(1, i);
        }

        System.out.println(flag ? 1 : 0);
        br.close();
    }

    private static void dfs(int cnt, int curr) {
        if (flag) {
            return;
        }
        if (cnt >= 5) {
            flag = true;
            return;
        }

        visited[curr] = true;
        for (int next : adjList[curr]) {
            if (visited[next]) continue;
            dfs(cnt + 1, next);
        }
        visited[curr] = false;
    }
}
