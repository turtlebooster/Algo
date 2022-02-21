package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈2_8958_OX퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	// 테스트케이스 갯수
		
		for (int i = 0; i < T; i++) {
			String result = sc.next();
			int score = 0;
			int sub = 0;
			for (int j = 0; j < result.length(); j++) {
				// o 일 경우
				if (result.charAt(j) == 'O') {					
					if (j > 0 && result.charAt(j - 1) == 'O') {
						score += ++sub;
						continue;
					}
					score += sub = 1;
				}
				// x 일 경우
				// 자연스럽게 통과
			}
			System.out.println(score);
		}
		sc.close();
	}
}
