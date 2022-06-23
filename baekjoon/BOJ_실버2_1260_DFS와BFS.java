package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_실버2_1260_DFS와BFS {
	static boolean[] visited;
	static List<Integer>[] adjList;		
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		int s, e;
		for (int i = 0; i < M; i++) {
			s = sc.nextInt();
			e = sc.nextInt();
			adjList[s].add(e);
			adjList[e].add(s);
		}
		
		// 오름차순 정렬
		for (int i = 1; i <= N; i++) {
			adjList[i].sort((o1, o2) -> o1 - o2);
		}
		
		visited = new boolean[N + 1];
		visited[V] = true;
		sb = new StringBuilder();
		DFS(V);
		System.out.println(sb);
		
		visited = new boolean[N + 1];
		visited[V] = true;
		sb = new StringBuilder();
		BFS(V);
		System.out.println(sb);
		
		sc.close();
	}
	
	public static void DFS(int idx) {
		sb.append(idx + " ");
		
		for (int next : adjList[idx]) {
			if (visited[next]) continue;
			visited[next] = true;
			DFS(next);
		}
	}
	
	public static void BFS(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			sb.append(curr + " ");
			
			for (int next : adjList[curr]) {
				if (visited[next]) continue;
				visited[next] = true;
				q.add(next);
			}		
		}
	}
}
