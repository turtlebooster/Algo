package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_11729_하노이탑이동 {
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sb = new StringBuilder();
		hanoi(N, 1, 3, 2);
		
		// 하노이 탑 이동 횟수는 2^N - 1
		System.out.println((int)(Math.pow(2, N) - 1));
		System.out.println(sb);
		sc.close();
	}

	private static void hanoi(int N, int from, int to, int another) {
		if (N == 1) {
			// 한 개 옮기기
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		
		// 제일 큰 원판을 제외한 N - 1 개의 원판을 목적지가 아닌 곳에 옮기기
		hanoi(N - 1, from, another, to);
		
		// 남아있는 제일 큰 원판을 목적지로 옮기기
		sb.append(from).append(" ").append(to).append("\n");
		
		// N - 1 개의 원판을 목적지로 옮기기
		hanoi(N - 1, another, to, from);
	}
	
	
}
