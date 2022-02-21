package swea;

import java.util.Scanner;

public class SW_D3_1215_회문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int L = sc.nextInt();
			sc.nextLine();
			
			// 문자 테이블 만들고 저장
			char[][] table = new char[8][8];			
			for (int i = 0; i < 8; i++) {
				table[i] = sc.nextLine().toCharArray();
			}
			
			// 회문 찾기
			int cnt = 0;
			boolean checkr = true;
			boolean checkc = true;
			for (int p = 0; p < 8; p++) {
				for (int i = 0; i <= 8 - L; i++) {
					// 행 방향 회문 찾기
					for (int j = i, k = i + L - 1; j<=k ;j++ , k--) {
						if (table[p][j] != table[p][k]) {
							checkr = false;
							break;
						}
						checkr = true;
					}
					// 열 방향 회문 찾기
					for (int j = i, k = i + L - 1; j<=k ;j++ , k--) {
						if (table[j][p] != table[k][p]) {
							checkc = false;
							break;
						}
						checkc = true;
					}
					if (checkr) cnt++;				
					if (checkc) cnt++;				
				}				
			}
			
			
			System.out.println("#" + tc + " " + cnt);
			
		}
		sc.close();		
	}
}
