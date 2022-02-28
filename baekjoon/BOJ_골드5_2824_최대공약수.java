package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_골드5_2824_최대공약수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// A 를 만들기 위해 곱하는 수의 개수
		BigInteger A = new BigInteger("1");
		for (int i = 0; i < N; i++) {
			A = A.multiply(sc.nextBigInteger());
		}		
		
		int M = sc.nextInt();	// B 를 만들기 위해 곱하는 수의 개수
		BigInteger B = new BigInteger("1");
		for (int i = 0; i < M; i++) {
			B = B.multiply(sc.nextBigInteger());
		}		
		
		String txt = gcd(A, B).toString();
		if (txt.length() > 9) txt = txt.substring(txt.length() - 9);
		System.out.println(txt);
		
		sc.close();		
	}
	
	private static BigInteger gcd (BigInteger n1, BigInteger n2) {
		if (n1.compareTo(n2) == -1) {
			BigInteger tmp = n1;
			n1 = n2;
			n2 = tmp;
		}		
		
		if (n1.remainder(n2).compareTo(new BigInteger("0")) == 0) return n2;
		return gcd(n2, n1.remainder(n2));
	}
}
