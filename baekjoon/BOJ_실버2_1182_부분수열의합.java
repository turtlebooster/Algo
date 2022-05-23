package baekjoon;

import java.util.Scanner;

public class BOJ_실버2_1182_부분수열의합 {
	static int N, S, ans;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		partSum(0, 0);		
		
		System.out.println(ans);
		sc.close();
	}
	public static void partSum(int idx, int sum) {		
		if (idx == N) return;
		
		partSum(idx + 1, sum);
		
		// 크기가 양수, 동일하게 선택된 경우 제외 -> 더해졌을때만 합이 S인지 체크
		sum += arr[idx];
		if (sum == S) ans++;
		partSum(idx + 1, sum);
		
	}
}
