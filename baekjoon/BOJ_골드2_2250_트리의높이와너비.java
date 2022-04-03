package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_골드2_2250_트리의높이와너비 {
	public static class Node {
		int l;	// 왼쪽 자식
		int r;	// 오른쪽 자식
		int p = -1; 	// 부모
	}
	public static Node[] tree;
	public static int cnt;
	public static int[] max;
	public static int[][] len;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 노드의 개수
		tree = new Node[N + 1];
		
		// 트리 초기화
		for (int i = 1; i <= N; i++) {
			tree[i] = new Node();
		}
		
		for (int i = 1; i <= N; i++) {
			int idx = sc.nextInt();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			// 자식 표기
			tree[idx].l = c1;
			tree[idx].r = c2;
			// 부모 표기
			if (c1 != -1 ) tree[c1].p = idx;
			if (c2 != -1 ) tree[c2].p = idx;
		}
		
		// 루트 찾기
		int root = 1;
		for (int i = 1; i <= N; i++) {
			if (tree[i].p == -1) root = i;
		}
		
		len = new int[N + 1][2];	// {레벨}{시작점, 끝점}
		for (int lv = 1; lv <= N; lv++) {
			len[lv][0] = 10001;
			len[lv][1] = -1;
		}
		cnt = 0;
		inorder(root, 1);
		
		max = new int[2];			// {최대일때 레벨, 최대 너비}
		for (int lv = 1; lv <= N; lv++ ) {
			// 해당 lv의 끝점 값이 0 이면 그 층은 없는 것
			// 그러면 다음 층도 없다!
			if (len[lv][1] == -1) break;
			if (max[1] < len[lv][1] - len[lv][0] + 1) {
				max[0] = lv;
				max[1] = len[lv][1] - len[lv][0] + 1;
			} else if (max[1] == len[lv][1] - len[lv][0] + 1 && max[0] > lv) {
				max[0] = lv;
			}
		}
		
		System.out.println(Arrays.toString(max).replaceAll("[\\[\\,\\]]", ""));
		sc.close();
	}
	
	public static void inorder(int idx, int lv) {
		
		if(tree[idx].l != -1) inorder(tree[idx].l, lv + 1);
		cnt++;
		len[lv][0] = Math.min(len[lv][0], cnt);
		len[lv][1] = Math.max(len[lv][1], cnt);
		if(tree[idx].r != -1) inorder(tree[idx].r, lv + 1);
	}
}
