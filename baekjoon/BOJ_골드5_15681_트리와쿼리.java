package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_골드5_15681_트리와쿼리 {
	static class Node {
		int q;		
		List<Integer> list = new LinkedList<>();		
	}
	static Node[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		// 트리 배열 생성 및 초기화
		tree = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new Node();
		}
		
		// 간선 연결
		int n1, n2;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			tree[n1].list.add(n2);
			tree[n2].list.add(n1);
		}
		
		dfs(-1, R);
		
		for (int i = 0; i < Q; i++) {
			sb.append(tree[Integer.parseInt(br.readLine())].q).append("\n");			
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	static void dfs(int from, int to) {		
		Node curr = tree[to];

		curr.q = 1;
		List<Integer> list = curr.list;
		for (int n : list) {
			if (n == from) continue;
			dfs(to, n);
			curr.q += tree[n].q;
		}
//		int size = list.size();
//		for (int i = 0; i < size; i++) {
//			int n = list.get(i);
//			if (n == from) {
//				continue;
//			}
//			dfs(to, n);
//			curr.q += tree[n].q;
//		}
	}
}
