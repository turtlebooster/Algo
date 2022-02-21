package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_5525_IOIO {
	/*
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // IOIOI 의 O 갯수
		int M = sc.nextInt(); // 문자열 길이
		sc.nextLine();
		
//		String S = sc.nextLine();
		char[] S = sc.nextLine().toCharArray();
		
		int cnt = 0;
		for (int j = 0; j < M; j++) {
			if (S[j] != 'I') continue;
			for(int i = 1; i <= 2 * N; i++) {
				if (j + i >= M) break;
				if (S[i + j - 1] == 'I') {
					if (S[i + j] != 'O') break;
				}
				else if (S[i + j - 1] == 'O') {
					if (S[i + j] != 'I') break;
					if (i == 2 * N) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
