package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드2_10423_전기가부족해 {
    static class Edge {
        int e, w;

        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시 개수, 설치 가능 케이블 수, 발전소 개수 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 발전소 입력
        st = new StringTokenizer(br.readLine());
        int[] pow = new int[K];
        for (int i = 0; i < K; i++) {
            pow[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 리스트 및 초기화
        List<Edge>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 그래프 만들기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Edge(v, w));
            adjList[v].add(new Edge(u, w));
        }

        // 방문 체크
        boolean[] visited = new boolean[N + 1];
        // 비용 적은 순 정렬
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);

        // 발전소 부터 탐색 시작
        for (int p : pow) {
            visited[p] = true;
            pq.addAll(adjList[p]);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            // 방문 체크
            if (visited[curr.e]) continue;
            visited[curr.e] = true;

            // 비용 더하기
            sum += curr.w;

            pq.addAll(adjList[curr.e]);
        }

        System.out.println(sum);
        br.close();
    }
}
