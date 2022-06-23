package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드2_1167_트리지름 {
	static int V;
	static List<Node>[] adjList;
	public static class Node {		
		int e, d;
		public Node(int e, int d) {
			this.e = e;
			this.d = d;
		}
	}	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) adjList[i] = new ArrayList<>();
		
		int s, e, d;
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			
			while((e = Integer.parseInt(st.nextToken())) != -1) {
				adjList[s].add(new Node(e, Integer.parseInt(st.nextToken())));
			}
			
		}
		
		int ans = getMaxDist(getMaxDist((int)(Math.random() * V + 1)).e).d;	
		
		System.out.println(ans);
	}
	public static Node getMaxDist(int s) {
		boolean[] visited = new boolean[V + 1];
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(s, 0));
		visited[s] = true;
		
		Node res = new Node(s, 0);
		
		while(!q.isEmpty()) {
			Node c = q.poll();
			
			if (res.d < c.d) {
				res = c;
			}			
			
			for (Node n : adjList[c.e]) {
				if (visited[n.e]) continue;
				visited[n.e] = true;
				q.add(new Node(n.e, c.d + n.d));				
			}
			
		}
		
		return res;
	}
	
}
