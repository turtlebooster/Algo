package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우주의 신이 하는 별 이어 붙이기
public class BOJ_골드4_4386_별자리만들기 {
	public static class Edge {
		int s;
		int e;
		double w;
		public Edge(int s, int e, double w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 별의 개수 1 ~ 100
		double[][] stars = new double[N][];
		// 별 좌표 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i] = new double[] {Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())};
		}
		
		// 그래프 저장 -> 인접 리스트
		List<Edge>[] adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) adjList[i] = new ArrayList<>();
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double d = dist(stars[i], stars[j]);
				adjList[i].add(new Edge(i, j, d));
				adjList[j].add(new Edge(j, i, d));
			}
		}
		
		// prim
		boolean[] visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
				if (e1.w > e2.w) return 1;
				else if (e1.w == e2.w) return 0;
				else return -1;
			});
		
		// 따로 정해지진 않았으니 0 번 부터 시작
		pq.addAll(adjList[0]);
		visited[0] = true;
		
		int cnt = 1;
		double ans = 0;
		
		while (cnt != N) {
			Edge edge = pq.poll();
			
			if (visited[edge.e]) continue;
			
			ans += edge.w;
			pq.addAll(adjList[edge.e]);
			visited[edge.e] = true;
			cnt++;
		}
		
		System.out.printf("%.2f\n", ans);
	}
	
	private static double dist(double[] s1, double[] s2) {
		return Math.sqrt(Math.pow(s1[0] - s2[0], 2) + Math.pow(s1[1] - s2[1], 2));
	}
	
}
