package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_골드5_12865_평범한배낭 {
	static int K, max;
	static PriorityQueue<Integer>[] pq;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 물품의 수
		K = sc.nextInt();	// 버틸 수 있는 무게
		
		pq = new PriorityQueue[K + 1];
		for (int i = 1; i <= K; i++) pq[i] = new PriorityQueue<>((v1, v2) -> (v1 - v2) * -1);
		
		for (int i = 0; i < N; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			// 버틸 수 있는 무게를 넘는 물품은 고려하지 않음
			if (w > K) continue;
			pq[w].add(v); 
		}
		
		max = 0;
		recur(1, 0, 0);
		
		System.out.println(max);
		sc.close();
	}
	
	public static void recur(int W, int Wsum, int Vsum) {
		max = Math.max(max, Vsum);
		if (Wsum + W > K) return;
		
		if (!pq[W].isEmpty()) {
			int V = pq[W].poll();
			recur(W, Wsum + W, Vsum + V);
			pq[W].add(V);			
		}
		recur(W + 1, Wsum, Vsum);
	}
	
}
