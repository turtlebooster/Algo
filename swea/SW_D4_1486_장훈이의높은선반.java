package swea;

import java.util.Scanner;

public class SW_D4_1486_장훈이의높은선반 {
	static int N, B, min;
	static int[] H;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// 테스트 케이스의 수
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			B = sc.nextInt();
			
			H = new int[N];
 			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}
 			min = 200000;
			tower(0, 0);
 			
			System.out.println("#" + t + " " + (min - B));
		}
		sc.close();
	}
	
	public static void tower(int idx, int sum) {
		if (sum >= B) {
			// 합이 B 이상이면 최소값 갱신 
			min = Math.min(min, sum);
			return;
		}
		if(idx >= N) return;
		
		tower(idx + 1, sum + H[idx]);	// 뽑은 경우
		tower(idx + 1, sum);	// 안뽑은 경우
	}
}
