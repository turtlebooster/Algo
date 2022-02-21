package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈1_14696_딱지놀이 {
	/*
	 * 둘이서 하는 딱지치기
	 * 별 4, 동그라미 3, 네모 2, 세모 1 순을 우선순위로 갯수 판별하여 승부 책정
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 딱지치기 총 라운드 수 1 ~ 1000
		
		// N 라운드 진행
		for (int i = 0; i < N; i++) {
			String ans = "D";
			// 플레이어 A 각각의 그림 갯수 카운팅
			int[] A = new int[5];
			int cards = sc.nextInt();
			for (int j = 0; j < cards; j++) {
				A[sc.nextInt()]++;
			}
			// 플레이어 B 각각의 그림 갯수 카운팅
			int[] B = new int[5];
			cards = sc.nextInt();
			for (int j = 0; j < cards; j++) {
				B[sc.nextInt()]++;
			}
			// 승부!!
			for (int j = 4; j > 0 ; j--) {
				// 무승부일경우 다음 것 비교
				if (A[j] == B[j]) continue;
				// A 의 그림이 많을 경우 A 승리로 끝
				if (A[j] > B[j]) {
					ans = "A";
					break;
				}
				// B 의 그림이 많을 경우에만 내려옴 B 승리로 끝
				ans = "B";	
				break;
			}
			System.out.println(ans);
		}		
		sc.close();
	}
}
