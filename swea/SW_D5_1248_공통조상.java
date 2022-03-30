package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
//import java.util.Scanner;

public class SW_D5_1248_공통조상 {
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		Node[] tree;
		
//		sc.nextLine();
		br.readLine();
		for (int t = 1; t <= 10; t++) {
			cnt = 0;
			
			String[] line1 = br.readLine().split(" ");	// 정점 총 수, 간선 총 수, 공통 조상 정점 번호 1, 2
			String[] line2 = br.readLine().split(" ");	// 간선 나열 : 부모-자식 순서
			
			// tree 초기화
			tree = new Node[Integer.parseInt(line1[0]) + 1];
			for (int i = 1; i < tree.length; i++) {
				tree[i] = new Node();	
			}
			
			// tree 구성
			for (int i = 0; i < Integer.parseInt(line1[1]) * 2; i += 2) {
				int pIdx = Integer.parseInt(line2[i]);
				int cIdx = Integer.parseInt(line2[i + 1]);
				
				Node cnode = tree[cIdx];
				Node pnode = tree[pIdx];
				
				cnode.data = cIdx;
				cnode.parent = tree[pIdx];
				
				pnode.data = pIdx;
				if (pnode.left == null) pnode.left = tree[cIdx];
				else pnode.right = tree[cIdx];
				
			}
		
			int idx = Integer.parseInt(line1[2]);	// 정점 번호 1
			HashMap<Integer, Integer> map = new HashMap<>();
			// 정점 번호 1 에 대한 모든 조상 매핑
			while (idx != 1) {
				idx = tree[idx].parent.data;
				map.put(idx, 1);				
			}
			
			idx = Integer.parseInt(line1[3]);	// 정점 번호 2
			while (idx != 1) {
				idx = tree[idx].parent.data;				
				if (map.get(idx) != null) break;
			}
			// idx 가 가장 가까운 공통 조상
			preorder(tree[idx]);
			
			System.out.println("#" + t + " " + idx + " " + cnt);
		}
//		sc.close();
		br.close();
	}
	

	static void preorder(Node node) {
		if (node == null) return;
		
		// 자기사진
		cnt++;
		
		// 왼
		preorder(node.left);
		
		// 오
		preorder(node.right);
	}
	
	static class Node {
		int data;
		Node parent;
		Node left;
		Node right;
	}
}
