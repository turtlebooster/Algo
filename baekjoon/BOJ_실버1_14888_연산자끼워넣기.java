package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_14888_연산자끼워넣기 {
	static int max = Integer.MIN_VALUE, 
			   min = Integer.MAX_VALUE;
	static int N;
	static int[] A, func;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 수의 개수
		// 수 입력
		A = new int[N];
		for (int i = 0; i < N; i++) A[i] = sc.nextInt();
		// 연산 개수 입력
		func = new int[4];	// {덧셈, 뺄셈, 곱셈, 나눗셈}
		for (int i = 0; i < 4; i++) func[i] = sc.nextInt();
		
		calc(1, A[0]);
		
		System.out.println(max + "\n" + min);
		sc.close();
	}
	private static void calc(int cnt, int res) {
		if (cnt == N) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (func[i] == 0) continue;
			func[i]--;
			switch (i) {
			case 0:
				// 덧셈
				calc(cnt + 1, res + A[cnt]);
				break;
			case 1:
				// 뺄셈
				calc(cnt + 1, res - A[cnt]);
				break;
			case 2:
				// 곱셈
				calc(cnt + 1, res * A[cnt]);
				break;
			case 3:
				// 나눗셈
				calc(cnt + 1, res / A[cnt]);
				break;		
			}
			func[i]++;			
		}
		
	}
}
