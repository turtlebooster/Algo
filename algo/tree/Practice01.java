package algo.tree;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
13
1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
 */

public class Practice01 {
	public static HashMap<Integer, Integer[]> tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 정점의 개수
		tree = new HashMap<>();
		sc.nextLine();
		
		// 트리 입력
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		boolean flag = false;
		int root = -1;
		while(st.hasMoreTokens()) {
			int node = Integer.parseInt(st.nextToken());
			if(!flag) {
				root = node;
				flag = true;
			}
			Integer[] child;
			if (tree.get(node) == null) {
				child = new Integer[2];
				child[0] = Integer.parseInt(st.nextToken());
			} else {
				child = tree.get(node);
				child[1] = Integer.parseInt(st.nextToken());
			}
			
			tree.put(node, child);
		}
		preorder(root);
				
		sc.close();
	}
	
	public static void preorder(int node) {
		System.out.print(node + " ");
		Integer[] child = tree.get(node);
		if (child != null) {
			if (child[0] != null) preorder(tree.get(node)[0]);		
			if (child[1] != null) preorder(tree.get(node)[1]);		
		}
	}
}
