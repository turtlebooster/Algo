package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드5_1753_최단경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());	// 정점의 수
		int E = Integer.parseInt(st.nextToken());	// 간선의 개수
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());	// 시작 정점
		
//		int[][] adjArr = new int[V + 1][V + 1];
		List<int[]>[] adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) adjList[i] = new ArrayList<>();
		
		int s, e, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()); 
			e = Integer.parseInt(st.nextToken()); 
			w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new int[] {e, w});
//			int curr = adjArr[s][e];
//			if (curr == 0 || (curr != 0 && curr > w)) {
//				adjArr[s][e] = w;
//			}
		}
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		boolean[] visited = new boolean[V + 1];
		int[] dist = new int[V + 1];
		Arrays.fill(dist, -1);
		
		pq.offer(new int[] {K, 0}); 
		dist[K] = 0;
		
		int[] way;
		while(!pq.isEmpty()) {
			way = pq.remove();
			if(visited[way[0]]) continue;
			visited[way[0]] = true;
			
			for (int[] path : adjList[way[0]]) {
				s = path[0];
				w = path[1];
				if (dist[s] == -1
						|| (dist[s] != -1 && dist[s] > dist[way[0]] + w)) {
						dist[s] = dist[way[0]] + w;
						pq.offer(new int[] {s, dist[s]});
					}
				
				
			}
			
//			for (int i = 1; i <= V; i++) {
//				w = adjArr[way[0]][i];
//				if (w == 0) continue;
//				if (dist[i] == -1
//					|| (dist[i] != -1 && dist[i] > dist[way[0]] + w)) {
//					dist[i] = dist[way[0]] + w;
//					pq.offer(new int[] {i, dist[i]});
//				}
//			}
		}
		
		
		for (int i = 1; i <= V; i++) {
			System.out.println(dist[i] != -1 ? dist[i] : "INF");			
		}
		
	}
}
