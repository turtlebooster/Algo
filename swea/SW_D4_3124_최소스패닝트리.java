package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// KRUSKAL
public class SW_D4_3124_최소스패닝트리 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[][] link = new int[E][3];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				link[i][0] = Integer.parseInt(st.nextToken());	// 시작
				link[i][1] = Integer.parseInt(st.nextToken());	// 끝
				link[i][2] = Integer.parseInt(st.nextToken());	// 비용
			}
			
			Arrays.sort(link, (l1, l2) -> l1[2] - l2[2]);
			
			p = new int[V + 1];
			for (int i = 1; i <= V; i++) p[i] = i;
			long ans = 0;
			
			int cnt = 1;
			for (int i = 0; i < E; i++) {
				int px = findSet(link[i][0]);
				int py = findSet(link[i][1]);
				
				if (px != py) {
					unionSet(px, py);
					ans += link[i][2];
					if (++cnt == V) break;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
		br.close();
	}
	private static int findSet(int x) {
		if (x == p[x]) return x;
		return p[x] = findSet(p[x]);
	}
	
	private static void unionSet(int px, int py) {
		p[py] = px;
	}
}
/*
// PRIM
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SW_D4_3124_최소스패닝트리 {
	public static class Edge {
		int ed;
		int cost;
		public Edge(int ed, int cost) {
			this.ed = ed;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			List<Edge>[] adjList = new ArrayList[V + 1];
			
			for (int i = 1; i <= V; i++) adjList[i] = new ArrayList<>();
			
			for (int i = 0; i < E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				int cost = sc.nextInt();
				
				adjList[st].add(new Edge(ed, cost));
				adjList[ed].add(new Edge(st, cost));
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
			boolean[] visited = new boolean[V + 1];
			
			pq.addAll(adjList[1]);
			visited[1] = true;
			
			int cnt = 1;
			long ans = 0;
			
			while (cnt != V) {
				Edge edge = pq.poll();
				
				if (visited[edge.ed]) continue;
				
				ans += edge.cost;
				visited[edge.ed] = true;
				pq.addAll(adjList[edge.ed]);
				
				cnt++;				
			}
			
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
}
*/