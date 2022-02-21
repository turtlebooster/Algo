package swea;

import java.util.Scanner;

public class SW_D2_1940_가랏RC카 {
	/*
	 * 매 초 command 가 입력됨
	 * 0: 현재 속도 유지 / 1: 가속 / 2: 감속
	 * 가속 또는 감속일 경우 가속도의 값이 추가로 주어짐
	 * 
	 *  N 초동안 이동한 거리 계산
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// command의 수, 이동하는 시간	2 ~ 30
			
			int V = 0; 	// 초기속도 0
			int L = 0;	// 이동거리 
			for (int i = 0; i < N; i++) {
				switch (sc.nextInt()) {
				case 0:	// 현재 속도 유지
					break;
				case 1:	// 가속
					V += + sc.nextInt();
					break;
				case 2:	// 감속
					V -= sc.nextInt();
					if (V < 0) V = 0;
					break;
				}				
				L += V;					
			}			
			
			System.out.println("#" + tc + " " + L);
		}
		sc.close();
	}
}
