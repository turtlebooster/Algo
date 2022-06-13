package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_2502_떡먹는호랑이 {
	static int D;
	static int[] ttuk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		D = sc.nextInt();		// 넘어온 날
		
		ttuk = new int[D + 1];
		ttuk[D] = sc.nextInt();	// 그 날 준 떡의 개수 
		
		outer:
		for (int num = ttuk[D] / 2; num < ttuk[D]; num++) {
			ttuk[D - 1] = num;
			for (int i = D - 2; i > 0; i--) {
				int res = ttuk[i + 2] - ttuk[i + 1];
				if (res < 1 || res > ttuk[i + 1]) {
					continue outer;
				}
				ttuk[i] = res;
			}
			break;			
		}
		
		System.out.println(ttuk[1]);
		System.out.println(ttuk[2]);
		
		sc.close();
	}
}
