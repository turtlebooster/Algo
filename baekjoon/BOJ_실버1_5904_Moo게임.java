package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_5904_Moo게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char ans = 'o';
		
		while (true) {
			int len = 0;
			int moo = 2;
			while (2 * len + ++moo < N) {			
				len = 2 * len + moo;			
			}
			if (2 * len + moo == N) {
				ans = 'o';
				break;
			}
			else if (len + 1 == N) {
				ans = 'm';
				break;
			}
			else if (len + moo >= N) {
				ans = 'o';
				break;
			}
			else {
				N -= len + moo;
			}
		}
		System.out.println(ans);
		sc.close();
	}	
	/*
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
		sc.close();
	}
	*/
}
