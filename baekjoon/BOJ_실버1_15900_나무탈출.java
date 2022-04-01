package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_실버1_15900_나무탈출 {
	public static int cnt;
	public static Node[] tree;
	public static class Node {
		List<Integer> child = new ArrayList<>();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		// 트리 초기화
		for (int i = 1; i <= N; i++) tree[i] = new Node();
		
		// 트리 구성
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int idx1 = Integer.parseInt(st.nextToken());
			int idx2 = Integer.parseInt(st.nextToken());
			
			tree[idx1].child.add(idx2);			
			tree[idx2].child.add(idx1);
		}
		
		// 리프 탐색 및 부모 설정
		// 홀수면 승리
		cnt = 0;
		travle(1, -1, 1);
		
		
		System.out.println(cnt % 2 != 0 ? "Yes" : "No");
		br.close();
	}
	
	public static void travle(int idx, int pIdx, int lv) {
		Node node = tree[idx];
		if (pIdx != -1) {
			// 부모를 자식 리스트에서 제거
			node.child.remove(node.child.indexOf(pIdx));
		}
		
		if (node.child.size() == 0) {
			// 자식이 없으면 리프노드
			cnt += lv - 1;
		}
		
		// 자식 노드 순회
		for (int i = 0; i < node.child.size(); i++) {
			travle(node.child.get(i), idx, lv + 1);
		}
	}
	
}
