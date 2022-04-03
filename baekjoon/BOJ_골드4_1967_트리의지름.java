package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_골드4_1967_트리의지름 {
	public static class Node {
		List<Link> link = new ArrayList<>();
	}
	public static class Link {
		int idx;
		int cost;
		
		public Link() {}		
		public Link(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
	}
	public static Node[] tree;
	public static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		int N = sc.nextInt();	// 노드의 개수
		int N = Integer.parseInt(br.readLine());	// 노드의 개수
		tree = new Node[N + 1];
		Map<Integer, Integer> cnt = new HashMap<>();
		
		for (int i = 1; i <= N; i++) tree[i] = new Node();
		
		// N - 1 개의 간선 정보
		for (int i = 0; i < N - 1; i++) {
//			int idx1 = sc.nextInt();
//			int idx2 = sc.nextInt();
//			int cost = sc.nextInt();
			st = new StringTokenizer(br.readLine());
			int idx1 = Integer.parseInt(st.nextToken());
			int idx2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if (cnt.get(idx1) == null) cnt.put(idx1, 1);
			else cnt.put(idx1, 2);
			if (cnt.get(idx2) == null) cnt.put(idx2, 1);
			else cnt.put(idx2, 2);
			
			tree[idx1].link.add(new Link(idx2, cost));
			tree[idx2].link.add(new Link(idx1, cost));
		}
		
		// 리프노드 이면 DFS
		Set<Integer> set = cnt.keySet();
		max = 0;
		for (int idx : set) {
			if (cnt.get(idx) != 1) continue;
			DFS(idx, -1, 0);
		}
		
		System.out.println(max);
//		sc.close();
	}
	
	public static void DFS(int idx, int from, int sum) {
		if (idx > tree.length - 1) return;
						
		Node node = tree[idx];
		
		for (Link link : node.link) {
			if (link.idx == from) continue;
			DFS(link.idx, idx, sum + link.cost);
		}
		
		// 리프노드일때만 최대인지 확인하고 저장
		if (node.link.size() == 1) {
			max = Math.max(max, sum);
			return;
		}
	}
}
