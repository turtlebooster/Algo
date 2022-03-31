package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_실버1_9934_완전이진트리 {
	static int size, pos;
	static int[] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();	// 트리 레벨
		List<Integer> input = new ArrayList<>();
		
		while(sc.hasNextInt()) {
			input.add(sc.nextInt());
		}
		
		size = input.size();
		tree = new int[size + 1];
		// 중위순회하며 트리 완성하기
		pos = 0;
		inorder(1, input);
		
		// 트리 출력
		for (int i = 0; i < K; i++) {
			for (int j = (int)Math.pow(2, i); j < (int)Math.pow(2, i + 1) ; j++) {
				System.out.print(tree[j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	static void inorder(int idx, List<Integer> input) {
		if (idx > size) return;
		
		inorder(2 * idx, input);
		// 현재 인덱스에 List 값 순서대로 입력
		tree[idx] = input.get(pos++);
		inorder(2 * idx + 1, input);
		
	}
}
