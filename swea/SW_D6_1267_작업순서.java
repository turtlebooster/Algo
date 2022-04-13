package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_D6_1267_작업순서 {
	static boolean[] visited;
	static List<Integer>[] adjList;
//	static Stack<Integer> ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V, E, s, e;
		int[] inner;
		Queue<Integer> q;
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());		// 정점의 총 수
			E = Integer.parseInt(st.nextToken());		// 간선의 총 수
			
			inner = new int[V + 1];	// 진입차수 - 1 ~ V 까지의 정수값으로 정점 번호를 가짐
			st = new StringTokenizer(br.readLine());
			
			// 인접 리스트
			adjList = new ArrayList[V + 1];
			// 인접 리스트 초기화
			for (int i = 1; i <= V; i++) adjList[i] = new ArrayList<>();
			
			for (int i = 0; i < E; i++) {
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				adjList[s].add(e);
				// 진입차수 증가
				inner[e]++;
			}
			
			// Queue 사용
			q = new LinkedList<>();
			visited = new boolean[V + 1];
			
			System.out.print("#" + t + " ");
			
			for (int i = 1; i <= V; i++) {
				if (inner[i] != 0) continue;
				q.offer(i);
				visited[i] = true;
				System.out.print(i + " ");
			}
			
			while (!q.isEmpty()) {
				int idx = q.remove();
				
				for (int adjIdx : adjList[idx]) {
					if (visited[adjIdx]) continue;
					if (--inner[adjIdx] == 0) {
						q.offer(adjIdx);
						System.out.print(adjIdx + " ");
					};
				}
			}
			System.out.println();
			
			/*
			// Stack 사용
			ans = new Stack<>();
			visited = new boolean[V + 1];
			for (int i = 1; i <= V; i++) {
				if(inner[i] != 0) continue;				
				DFS(i);
			}
			System.out.print("#" + t + " ");
			while(!ans.isEmpty()) {
				System.out.print(ans.pop() + " ");
			}
			System.out.println();
			*/
		}
	}
	/*
	private static void DFS(int idx) {
		visited[idx] = true;
		for (int adjIdx : adjList[idx]) {
			if(visited[adjIdx]) continue;
			DFS(adjIdx);
		}
		ans.push(idx);
	}
	*/
}
