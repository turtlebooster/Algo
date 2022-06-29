package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_1629_곱셈 {
	public static int MOD;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		MOD = sc.nextInt();
		
		System.out.println(pow(A, B));
		sc.close();
	}
	
	public static long pow(long A, int B) {
		A %= MOD;
		if (B == 1) return A;
		
		long res = pow(A, B / 2);
		res = res * res % MOD; 
		if (B % 2 != 0) {
			res = res * A % MOD;
		}
		
		return res;
	}
}
