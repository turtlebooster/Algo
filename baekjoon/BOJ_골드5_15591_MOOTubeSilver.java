package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_골드5_15591_MOOTubeSilver {
    public static class Node {
        int e, r;

        public Node(int e, int r) {
            this.e = e;
            this.r = r;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 영상 개수
        int N = Integer.parseInt(st.nextToken());
        // 질문 개수
        int Q = Integer.parseInt(st.nextToken());

        // 인접 리스트 생성 및 초기화
        List<Node>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();

        // 인접 리스트 입력
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            adjList[p].add(new Node(q, r));
            adjList[q].add(new Node(p, r));
        }

        // 질문 답변
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            // USADO 기준
            int k = Integer.parseInt(st.nextToken());
            // 보고있는 영상 번호
            int v = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];
            q.add(v);
            visited[v] = true;

            // 답변
            int ans = 0;

            while(!q.isEmpty()) {
                int curr = q.poll();

                for (Node n : adjList[curr]) {
                    // 이미 체크한 영상 패스
                    if (visited[n.e]) continue;
                    // 기준을 넘지 못하면 패스
                    if (n.r < k) continue;

                    ans++;
                    q.add(n.e);
                    visited[n.e] = true;
                }
            }
            System.out.println(ans);
        }

        br.close();
    }
}
