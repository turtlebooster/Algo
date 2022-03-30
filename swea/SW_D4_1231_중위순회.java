package swea;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_D4_1231_중위순회 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			sc.nextLine();
			
			Node[] tree = new Node[N + 1];
			
			// 트리 제작
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(sc.nextLine());
				Node node = new Node();
				
				int idx = Integer.parseInt(st.nextToken());
				node.data = st.nextToken();
				if (st.hasMoreTokens()) node.left = Integer.parseInt(st.nextToken());
				if (st.hasMoreTokens()) node.right = Integer.parseInt(st.nextToken());
				
				tree[idx] = node;				
			}
			
			System.out.print("#" + t + " ");
			// 중위 순회
			inorder(1, tree);
			System.out.println();
		}
		sc.close();
	}
	
	public static void inorder(int idx, Node[] tree) {
		// 왼
		if (idx <= tree.length + 1 && tree[idx].left != 0)
		inorder(tree[idx].left, tree);
		
		// 자신
		System.out.print(tree[idx].data);
		
		// 오른
		if (idx <= tree.length + 1 && tree[idx].right != 0)
		inorder(tree[idx].right, tree);
		
	}
	
	static class Node {
		String data;
		int left;
		int right;
	}
}
