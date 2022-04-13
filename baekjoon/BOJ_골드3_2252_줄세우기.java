package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_골드3_2252_줄세우기 {
	static Stack<Integer> ans;
	static boolean[] visited;
	static List<Integer>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] inner = new int[N + 1];
		
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();
		
		int s, e;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			adjList[s].add(e);
			inner[e]++;
		}
		
		// Stack, DFS 사용
		ans = new Stack<>();
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if(inner[i] != 0) continue;
			DFS(i);
		}
		
		while(!ans.isEmpty()) System.out.print(ans.pop() + " ");
		
	}
	
	static void DFS (int idx) {
		visited[idx] = true;
		for (int adjIdx : adjList[idx]) {
			if (visited[adjIdx]) continue;
			DFS(adjIdx);
		}
		ans.push(idx);
	}
}
