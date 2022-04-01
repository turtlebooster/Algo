package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_실버2_11725_트리의부모찾기 {
	public static Node[] tree;
	
	public static class Node {
		int pIdx;
		List<Integer> child = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 노드의 개수
		tree = new Node[N + 1];
		
		// 트리 초기화
		for (int i = 1; i <= N; i++) tree[i] = new Node();
		
		// 트리 구성
		for (int i = 0; i < N - 1; i++) {
			int idx1 = sc.nextInt();
			int idx2 = sc.nextInt();
			
			tree[idx1].child.add(idx2);
			tree[idx2].child.add(idx1);
		}
		
		// 순회 하며 부모 찾아 자식 리스트에서 제거 및 부모 설정
		travle(1, -1);
		
		// 출력
		for (int i = 2; i <= N; i++) System.out.println(tree[i].pIdx);
		
		sc.close();
	}
	
	public static void travle(int idx, int pIdx) {
		Node node = tree[idx];
		if (pIdx != -1) {
			// 부모로 설정
			node.pIdx = pIdx;
			// 부모를 자식 리스트에서 제거
			node.child.remove(node.child.indexOf(pIdx));
		}
		
		for (int i = 0; i < node.child.size(); i++) {
			travle(node.child.get(i), idx);
		}
		
	}
	
}
