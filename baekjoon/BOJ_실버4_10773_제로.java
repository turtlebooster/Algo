package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_실버4_10773_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();	// 주어지는 정수의 개수
		Stack<Integer> box = new Stack<>();
		
		// 주어지는 정수 개수 만큼 반복 진행
		for (int i = 0; i < K; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				box.pop();
			} else {
				box.add(num);
			}			
		}
		
		int sum = 0;
		while (!box.empty()) {
			sum += box.pop();
		}
		
		System.out.println(sum);
		sc.close();
	}
}
