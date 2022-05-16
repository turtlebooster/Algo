package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드4_1647_도시분할계획 {
	static class Node {
		int e, w;
		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}
	}
	static int N;
	static List<Node>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new Node(e, w));
			adjList[e].add(new Node(s, w));
		}
		
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
		
		pq.addAll(adjList[1]);
		visited[1] = true;
		
		int cnt = 1;
		int ans = 0;		
		int max = 0;
		
		while(cnt != N) {
			Node node = pq.poll();
			if(visited[node.e]) continue;
			
			ans += node.w;
			max = Math.max(max, node.w);
			visited[node.e] = true;
			
			pq.addAll(adjList[node.e]);
			cnt++;			
		}
		
		System.out.println(ans - max);
	}	
}
