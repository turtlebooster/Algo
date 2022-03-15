package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_12865_평범한배낭 {
	static int N, K, maxV;
	static int[] W, V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		W = new int[N];
		V = new int[N];
		
		for (int i = 0; i < N; i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();			
		}		
		
		maxV = 0;
		boolean[] inBag = new boolean[N]; 
		recur(inBag, 0, 0, 0);
		
		System.out.println(maxV);
		sc.close();
	}
	
	public static void recur(boolean[] inBag, int idx, int sumW, int sumV) {
		// 종료
		if (idx == N) {
			maxV = Math.max(maxV, sumV);
			return;
		}
		
		// 반복
		inBag[idx] = false;
		if (sumW > K) return;
		recur(inBag, idx + 1, sumW, sumV);
		
		inBag[idx] = true;
		if (sumW + W[idx] > K) return;
		recur(inBag, idx + 1, sumW + W[idx], sumV + V[idx]);
		
	}
}
