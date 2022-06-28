package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_5582_공통부분문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String txt1 = sc.next();
		String txt2 = sc.next();
		
		if (txt1.length() > txt2.length()) {
			String temp = txt1;
			txt1 = txt2;
			txt2 = temp; 
		}
		
		int len1 = txt1.length();
		int len2 = txt2.length();
		int max = 0;
		
		// 대각선 탐색
		// i - j = sub -> j = i + sub
		int cnt;		
		for (int sub = len1; sub >= -len2; sub--) {
			cnt = 0;
			for (int i = 0; i < len1; i++) {
				int j = i + sub;
				if (j < 0 || j >= len2) continue;
				if (txt1.charAt(i) == txt2.charAt(j)) {
					cnt++;
					if (cnt > max) max = cnt;
				} else cnt = 0;
			}
		}
		
//		// DP 활용		
//		int[][] dp = new int[len1][len2];
//		for (int i = 0; i < len1; i++) {
//			for (int j = 0;  j < len2; j++) {
//				if (txt1.charAt(i) != txt2.charAt(j)) continue;
//				if (i > 0 && j > 0)	dp[i][j] = dp[i - 1][j - 1] + 1;
//				else dp[i][j] = 1;
//				if (dp[i][j] > max) max = dp[i][j];
//			}
//		}
		
		System.out.println(max);
		sc.close();
	}

}
