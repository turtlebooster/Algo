package baekjoon;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_실버3_6571_피보나치수의개수 {
	@SuppressWarnings("serial")
	private static HashMap<Integer, BigInteger> piboList = new HashMap<Integer, BigInteger>() {{
		put(1, new BigInteger("1"));
		put(2, new BigInteger("2"));
	}};
	
	public static void main(String[] args) throws Exception {	
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			BigInteger a = sc.nextBigInteger();			
			BigInteger b = sc.nextBigInteger();			
			if (a.compareTo(new BigInteger("0")) == 0 && b.compareTo(new BigInteger("0")) == 0) break;
			int i = 1;
			int s = 1, e = 1;
			while(true) {
				if (pibo(i).compareTo(a) == -1) s = i + 1;
				if (pibo(i).compareTo(b) == 1) {
					e = i - 1;
					break;
				}
				i = i + 1;
			}
			System.out.println(e - s + 1);
		}
		sc.close();
	}
	
	private static BigInteger pibo (int n) {
		if (n == 1 || n == 2) return piboList.get(n);
		
		if (piboList.get(n) == null) {
			piboList.put(n, pibo(n - 1).add(pibo(n - 2)));			
		}
		return piboList.get(n);
	}
}
