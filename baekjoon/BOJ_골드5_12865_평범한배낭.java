package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_12865_평범한배낭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 물건 개수
		int K = sc.nextInt();	// 준서가 버틸 수 있는 무게
		int[] W = new int[N];	// i 번 물건 무게
		int[] V = new int[N];	// i 번 물건 가치
		
		// 물건 무게 및 가치 데이터 입력
		for (int i = 0; i < N; i++) {
			W[i] = sc.nextInt();			
			V[i] = sc.nextInt();
		}
		
		// dp[i][j]	: i 번 물건까지 고려하여 j 이하의 무게로 만들 수 있는 최대 가치
		int[][] dp = new int[N][K + 1];	
		
		// 0 번 물건까지만 고려했을 경우 
		// 0 번 무게 이상이면 0번의 가치값이 최대값
		for (int j = W[0]; j <= K; j++) {
			dp[0][j] = V[0];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= K; j++) {
				/*
				if (j < W[i]) {
					// 이번 물건의 무게 미만 에 대해서는 이번 물건을 추가로 배낭에 넣을 수 없음
					// 이전 물건까지 고려했을때의 가치 최대값이 곧 이번 물건까지 고려한 가치 최대값
					dp[i][j] = dp[i - 1][j];
				} else {
					// 이번 물건을 사용해서 j 무게 이하로 만들 수 있는 최대 가치
					// 이번 물건을 사용하지 않고 이전 물건까지만 고려했을때 j 무게 이하로 만들 수 있는 최대 가치
					// 둘 중 큰 값이 이번 물건까지 고려했을때 j 무게 이하 최대 가치
					dp[i][j] = Math.max(dp[i - 1][j - W[i]] + V[i], dp[i - 1][j]);
				}
				*/
				// 이번 물건을 사용해서 j 무게 이하로 만들 수 있는 최대 가치
				// 이번 물건을 사용하지 않고 이전 물건까지만 고려했을때 j 무게 이하로 만들 수 있는 최대 가치
				// 둘 중 큰 값이 이번 물건까지 고려했을때 j 무게 이하 최대 가치
				dp[i][j] = Math.max(j < W[i] ? 0 : dp[i - 1][j - W[i]] + V[i], dp[i - 1][j]);
			}
		}

//		System.out.println(Arrays.deepToString(dp).replace("], ", "]\n"));
		// (N - 1 번 물건 까지) 모든 물건을 고려하고 K 무게 이하로 만들수 있는 최대 가치 출력
		System.out.println(dp[N - 1][K]);
		sc.close();
	}
	
	
/*
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
	*/
}
