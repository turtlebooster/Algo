package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_골드5_1068_트리 {
	static int cnt;
	static class Node {
		List<Integer> child = new ArrayList<>();
		int parent;
	}
	static Node[] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 노드의 개수
		tree = new Node[N];	// 노드 0 번부터 N-1 번
		int num = -1;
		int root = 0;
		
		// 트리 입력
		for (int i = 0; i < N; i++) {
			if (tree[i] == null) tree[i] = new Node();
			num = sc.nextInt();
			// -1 이면 루트
			if (num == -1) {
				root = i;
				continue;
			}
			
			// 부모 인덱스 리스트에 추가
			tree[i].parent = num;
			
			// 부모 노드 없을 경우 생성
			if (tree[num] == null) tree[num] = new Node(); 
			
			// 자식 인덱스 리스트에 추가
			tree[num].child.add(i);			
		}
		
		// 삭제
		int idx = sc.nextInt();
		Node node = tree[tree[idx].parent];
		int size = node.child.size();
		
		for (int i = 0; i < size; i++) {
			if (node.child.get(i) == idx) {
				node.child.remove(i);
				break;
			}
		}
		
		tree[idx] = null;
		
		// 순회하여 리프노드 수 파악
		cnt = 0;
		travle(root);
		
		System.out.println(cnt);
		sc.close();
	}

	public static void travle(int idx) {
		Node node = tree[idx];
		if (node == null) return;
		
		// 자식이 없으면 카운트
		if(node.child.size() == 0) cnt++;
		
		for (int i = 0; i < node.child.size(); i++) {
			travle(node.child.get(i));
		}
		
	}
	
}
