package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_플레5_20188_등산마니아 {
	static class Node {
		int p, dist = Integer.MAX_VALUE;
	}
	static Node[] mt;
	static boolean[] visited;
	static List<Integer>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
	
		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();
	
		int s, e;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			adjList[s].add(e);
			adjList[e].add(s);
		}
		
		mt = new Node[N + 1];
		for (int i = 1; i <= N; i++) mt[i] = new Node();
		visited = new boolean[N + 1];
		visited[1] = true;
		dfs(1, 0, 1);
		
		long ans = 0;
		int common = 1;
		List<Integer> pList = new ArrayList<>();
		for (int i = 1; i < N; i++) {
			
			pList.clear();
			int idx = i;
			while (idx != 1) {					
				pList.add(idx);					
				idx = mt[idx].p;
			}
			pList.add(1);
			
			for (int j = i + 1; j <= N; j++) {
				
				idx = j;
				common = 1;
				while(true) {
					if (pList.contains(idx)) {
						common = idx;
						break;
					}
					idx = mt[idx].p;
				}
				
				ans += mt[i].dist + mt[j].dist - mt[common].dist;
			}
		}
		
		
		System.out.println(ans);
		
	}
	
	public static void dfs(int idx, int lv, int from) {
		mt[idx].dist = lv;
		mt[idx].p = from;
		
		for (int i : adjList[idx]) {
			if (i == from) continue;
			dfs(i, lv + 1, idx);
		}		
	}
}
