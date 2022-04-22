package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드3_1238_파티 {
	static class Node {
		int e;
		int w;
		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		List<Node>[] adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();
		
		// M개의 단방향 도로 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			adjList[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		PriorityQueue<Node> pq;
		boolean[] visited;
		int[] dist;
		int max = 0;
		
		//다익스트라 X 에서 각 마을까지 최단거리 배열 구하기
		pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
		visited = new boolean[N + 1];
		int[] distX = new int[N + 1];	// X에서 각 마을까지 최단 거리
		Arrays.fill(distX, Integer.MAX_VALUE);
		
		distX[X] = 0;
		pq.add(new Node(X, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if (visited[node.e]) continue;
			visited[node.e] = true;
			
			for (Node n : adjList[node.e]) {
				if (!visited[n.e] && distX[n.e] > distX[node.e] + n.w) {
					distX[n.e] = distX[node.e] + n.w;
					pq.add(new Node(n.e, distX[n.e]));
				}
			}
		}
		
		// 다익스트라
		// 각 마을(i)에서 X 까지 최단거리 구하기
		for (int i = 1; i <= N; i++) {
			// X 마을에 사는 학생은 제외
			if (i == X) continue;
			// 다익스트라 i 부터
			pq.clear();
			visited = new boolean[N + 1];
			dist = new int[N + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			dist[i] = 0;
			pq.add(new Node(i, 0));
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				
				if (visited[node.e]) continue;
				visited[node.e] = true;
				if (node.e == X) {
					// X까지의 최단거리가 정해지면
					// (i -> X 최단 거리 + X -> i 최단 거리) 최대값 구하기
					max = Math.max(max, dist[node.e] + distX[i]);
					break;
				}
				
				for (Node n : adjList[node.e]) {
					if (!visited[n.e] && dist[n.e] > dist[node.e] + n.w) {
						dist[n.e] = dist[node.e] + n.w;
						pq.add(new Node(n.e, dist[n.e]));
					}
				}
			}
		}
		System.out.println(max);
	}
}
