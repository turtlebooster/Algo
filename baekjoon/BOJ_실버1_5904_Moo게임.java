package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_실버1_5904_Moo게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// N 번째 글자 찾기
		
		
		int m = 1;
		ArrayList<Integer> plus = new ArrayList<>();
		plus.add(3);
		
		char ans = 'o';
		if (N == 1) {
			ans = 'm';
		} else {
			int i = 0;
			int max = 3;
			int len = plus.size();
			while (m < N) {
				if (i >= len) {
					plus.add(++max);
					for (int j = 0; j < len; j++) {
						plus.add(plus.get(j));
					}
					len = plus.size();
				}
				m += plus.get(i++);
				
			}
			if (m == N) ans = 'm';
		}
		
		System.out.println(ans);
		
		/*
		String moo = "moo";
		for (int k = 1; moo.length() < N; k++) moo = nextMoo(moo, k);
		System.out.println(moo.charAt(N - 1));		
		 */
		
		sc.close();
	}
	/* 메모리 초과
	public static String nextMoo (String moo, int k) {
		
		String nmoo = moo + "m";
		
		for (int i = 0; i < k + 2; i++) {
			nmoo += "o";
		}
		nmoo += moo;
		
		return nmoo;
	}
	*/
}
