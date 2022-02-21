package swea;

import java.util.Scanner;

public class SW_D3_2817_부분수열의합 {
	/*
	 * N 개의 자연수가 주어졌을때, 최소 1개 이상의 수를 선택하여 
	 * 그 합이 K가 되는 경우의 수를 구하는 프로그램 작성
	 * 
	 * input : T				테스트케이스 수
	 * 		   N K				(1 <= N <= 20, 자연수) (1 <= K <= 1000, 자연수)
	 * 		   A1 A2 ... An		수열 A	1 이상 100 이하 자연수
	 * 
	 * output: #tc ans			테스트케이스 번호 / 부분 수열의 합이 K가 되는 경우의 수
	 * 
	 */
	
	static int ans, K;
	static boolean[] sel;
	static int[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			K = sc.nextInt();
			A = new int[N];
			sel = new boolean[N];
			ans = 0;
			
			for (int i = 0; i < N; i++ ) {
				A[i] = sc.nextInt();
			}
			
			powerset(0);			
				
			System.out.printf("#%d %d\n", tc, ans);
		}
		
		
		
		sc.close();
	}
	
	private static void powerset(int idx) {
		if (idx == sel.length) {
			int sum = 0;
			// 한번 다만들었다. 이제 해당 숫자들을 더해보자.
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					sum += A[i];
				}
			}
			// 합이 K 이면 경우의 수 + 1
			if (sum == K) {
				ans++;
			}
			return;
		}
		// 재귀파트 
		// idx번째에 원소를 선택하여 true로 바꾸고 다음 원소를 선택하기 위해서 재귀호출
		sel[idx] = true;
		powerset(idx + 1);
		// idx번째에 원소를 선택하지 X 다음 원소를 선택하기 위해서 재귀호출
		sel[idx] = false;
		powerset(idx + 1);
	}	
}
