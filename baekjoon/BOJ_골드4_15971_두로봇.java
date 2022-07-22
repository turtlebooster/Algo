package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_15971_두로봇 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int robot1 = Integer.parseInt(st.nextToken());
		int robot2 = Integer.parseInt(st.nextToken());
		
		List<int[]>[] adjList = new ArrayList[N + 1];
		
		// 초기화
		for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();
		
		// 관계 리스트 작성
		int s, e, w;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			adjList[s].add(new int[] {e, w});
			adjList[e].add(new int[] {s, w});
		}
		
		// 탐색 진행 BFS
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		
	    // {위치, 총 거리, 통로 중 거리 최대값}
		q.add(new int[] {robot1, 0, 0});
		visited[robot1] = true;
		
		int[] curr;
		while(!q.isEmpty()) {
			curr = q.poll();
			
			if (curr[0] == robot2) {
				System.out.println(curr[1] - curr[2]);				
				break;
			}
			
			for (int[] next : adjList[curr[0]]) {
				if (visited[next[0]]) continue;
				visited[next[0]] = true;
				q.add(new int[] {next[0], curr[1] + next[1], Math.max(next[1], curr[2])});
			}
		}
	}
}
