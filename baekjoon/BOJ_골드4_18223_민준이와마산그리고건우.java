package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드4_18223_민준이와마산그리고건우 {
	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
	}
	static int V, E, P;
	static List<Node>[] adjList;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new Node(e, w));
			adjList[e].add(new Node(s, w));
		}
		
		dijkstra(1);
		int minDist = dist[V];
		int distToPFromS = dist[P];
		
		dijkstra(P);
		int distToPFromV = dist[V];
		
		// 1 -> V 최단 거리 = 1 -> P 최단거리 + P -> V 최단거리 이면 가능
		System.out.println(minDist == distToPFromS + distToPFromV ? "SAVE HIM" : "GOOD BYE");
	}
	public static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
		boolean[] visited = new boolean[V + 1];
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		pq.add(new Node(st, 0));
		dist[st] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.v]) continue;
			visited[curr.v] = true;
			
			for(Node node : adjList[curr.v]) {
				if(!visited[node.v] && dist[node.v] > dist[curr.v] + node.w) {
					dist[node.v] = dist[curr.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
			
			
		}
		
	}
}
