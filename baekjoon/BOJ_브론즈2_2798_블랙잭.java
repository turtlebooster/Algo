package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈2_2798_블랙잭 {
	/*
	 * N 장의 카드 중에서 
	 * 딜러가 외치는 숫자 M 보다 합이 작으면서 최대한 가깝도록
	 * 3장의 카드를 고른다  
	 * 
	 * M에 최대한 가까운 카드 3장의 합 출력
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 카드 개수 3 ~ 100
		int M = sc.nextInt();	// 넘지 않아야하는 합 10 ~ 300,000
		
		// 카드 세팅
		int[] cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		
		// 카드 중 3장 골라 합 최대 찾기
		int max = 0;
		outer:
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if (sum > M) continue;
					if (sum == M) {
						max = sum;
						break outer;
					}
					max = Math.max(max, sum);
				}				
			}			
		}
		
		System.out.println(max);
		sc.close();
	}
}
