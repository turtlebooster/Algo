package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드4_1197_최소스패닝트리 {
	static class Node {
		int e, w;
		Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Node>[] adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) adjList[i] = new ArrayList<>();
		
		int s, e, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()) - 1;
			e = Integer.parseInt(st.nextToken()) - 1;
			w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new Node(e, w));
			adjList[e].add(new Node(s, w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
		boolean[] visited = new boolean[V];
		
		pq.addAll(adjList[0]);
		visited[0] = true;
		int cost = 0;
		
		Node curr;
		int cnt = 1;
		while(cnt != V) {
			curr = pq.poll();
			
			if (visited[curr.e]) continue;
			
			cost += curr.w;
			pq.addAll(adjList[curr.e]);
			visited[curr.e] = true;
			cnt++;
		}
		
		System.out.println(cost);
	}
}
