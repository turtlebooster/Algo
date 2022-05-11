package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_골드4_5052_전화번호목록 {
	static class Node {
		int num;	// 번호
		int cnt;	// 자식 노드 수
		Node[] child = new Node[11]; // 0 ~ 9
		public Node(int num) {
			this.num = num;
			child[10] = this;
		}
	}
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		int N;
		Node[] root;
		// 테스트 케이스 수 만큼 반복
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());	// 전화번호의 수	1 ~ 10000
			root = new Node[11];	// 0 ~ 9
			root[10] = new Node(-1);
			boolean flag = true;
			
			// 전화 번호의 수 만큼 입력
			for (int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				int len = c.length;
				Node[] curr = root;
				for (int j = 0; j < len; j++) {
					if (!flag) break;
					int num = c[j] - '0';
					if (curr[num] == null) {
						curr[num] = new Node(num);
						curr[10].cnt++;	// 10번자리는 부모 노드
						curr = curr[num].child;
					} else {
						if (curr[num].cnt == 0) {
							// 리프노드면 접두가 겹치는 번호
							flag = false;
						} else {
							if (j == len - 1) {
								// 지금 번호가 마지막 번호일때
								// 접두가 겹치는 번호
								flag = false;
							} else {
								curr = curr[num].child;							
							}
						}
					}
				}
			}
			
			System.out.println(flag ? "YES" : "NO");
		}
	}
}
/*
// 시간 초과
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_골드4_5052_전화번호목록 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// 테스트 케이스 개수
		int N;
		String[] numbers;
		// 테스트 케이스 수 만큼 반복
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();	// 전화번호의 수	1 ~ 10000
			numbers = new String[N];
			// 전화번호의 수 만큼 반복 입력
			for (int i = 0; i < N; i++) {
				numbers[i] = sc.next();				
			}
			
			Arrays.sort(numbers, (n1, n2) -> n1.length() - n2.length());
			
			boolean flag = true;
			outer:
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (numbers[i].length() == numbers[j].length()) continue;
					if (numbers[i].equals(numbers[j].substring(0, numbers[i].length()))) {
						flag = false;
						break outer;
					}
				}
			}
			System.out.println(flag ? "YES" : "NO");
		}
		sc.close();
	}
}
*/