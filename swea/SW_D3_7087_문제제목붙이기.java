package swea;

import java.util.Scanner;

public class SW_D3_7087_문제제목붙이기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;	// 최대 문제 제목의 개수
			int N = sc.nextInt();	// 주어지는 단어 개수
			boolean[] check = new boolean['Z' - 'A' + 1]; 
			
			for (int i = 0; i < N; i++) {
				char c = sc.next().charAt(0);	// 단어의 첫글자
				check[c - 'A'] = true;
			}
			
			for (int i = 0; i < check.length; i++) {
				if (!check[i]) break;
				ans++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
