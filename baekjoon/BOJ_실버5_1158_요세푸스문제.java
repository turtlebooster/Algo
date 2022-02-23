package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_실버5_1158_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 사람 수	1 ~ 5000
		int K = sc.nextInt();	// 제거할 사람 K 번째	K <= N	1 ~ 5000
				
		Queue<Integer> people = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			people.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 1; people.size() != 1; i++) {
			if (i % K == 0) sb.append(people.remove() + ", ");
			else people.add(people.remove());
		}
		sb.append(people.remove() + ">");
		System.out.println(sb);
		
		sc.close();
	}
}
