package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_1699_제곱수의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		
		while (N > 0) {
			int R = (int)Math.sqrt(N) * (int)Math.sqrt(N);
			cnt += N / R;
			N -= N / R * R;			
		}			
		
		System.out.println(cnt);
		sc.close();
	}
}
