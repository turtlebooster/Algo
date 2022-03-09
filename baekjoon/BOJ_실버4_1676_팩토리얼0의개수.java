package baekjoon;

import java.util.Scanner;

public class BOJ_실버4_1676_팩토리얼0의개수 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] divider5pow = new int[N + 1];	// divider5pow[i] = n : i 가 5의 거듭제곱을 약수로 가질때 최대 5^n 
		
		for (int i = 1; i <= N; i++) {
			if (i * 5 > N) break;
			divider5pow[i * 5] = divider5pow[i] + 1;
		}
		
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += divider5pow[i];
		}
		
		System.out.println(sum);
		sc.close();
	}
}
