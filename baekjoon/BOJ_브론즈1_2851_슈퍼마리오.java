package baekjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2851
public class BOJ_브론즈1_2851_슈퍼마리오 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int target = 100;
		int ans = 0;
		
		for (int i = 0; i < 10; i++) {
			int beforeSum = sum;
			if (Math.abs(beforeSum - target) < Math.abs((ans = sum += sc.nextInt())) - target) ans = beforeSum;			
			if (sum >= target) break;			
		}
		
		System.out.println(ans);
		sc.close();
	}
}
