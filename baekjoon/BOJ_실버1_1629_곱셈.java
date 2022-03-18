package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_1629_곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		long remain = A % C;
		int cnt = 1;
		
		while (cnt * 2 <= B) {
			remain *= remain;
			cnt *= 2;
			
			if(remain > C) remain %= C;
		}
		
		for (int i = 0; i < B - cnt; i++) {
			remain *= A % C;

			if (remain > C) remain %= C; 
		}		
		
		System.out.println(remain);		
		sc.close();
	}
	/*
	// 시간 초과
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		long remain = A % C;
		for (int i = 1; i < B; i++) {
			remain *= A % C;
			if (remain > C) remain %= C;			
		}
		
		System.out.println(remain);		
		sc.close();
	}
	*/
}
