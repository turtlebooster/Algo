package swea;

import java.util.Scanner;

public class SW_D3_5356_의석이의세로로말해요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[][] msg = new char[5][];			
			
			int max = 0;	// 가장 긴 단어 길이
			// 각 단어를 char 배열형태로 나누어 2차원 char 배열에 저장
			// 가장 긴 단어 길이를 알아야 반복 횟수의 기준을 잡을 수 있음
			for (int i = 0; i < 5; i++) {
				msg[i] = sc.next().toCharArray();
				max = Math.max(max, msg[i].length);
			}
			
			// 정답 출력
			System.out.print("#" + tc + " ");
			// 열 번호는 최대길이 전까지
			for (int j = 0; j < max; j++) {
				for (int i = 0; i < 5; i++) {
					// 각 단어의 길이보다 작을때만 프린트
					if (j < msg[i].length) System.out.print(msg[i][j]);
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
