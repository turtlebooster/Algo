package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_1074_Z {
	public static int N, c, r, cnt;
	public static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		flag = false;
		recur(0, 0, (int)Math.pow(2, N));
		System.out.println(cnt);
		sc.close();
	}
	
	public static void recur(int is, int js, int size) {
		if (flag) return;
		if (size == 1) {
			if (is == r && js == c) {				
				flag = true;
				return;
			}
			System.out.println("r : " + is + " c : " + js + " cnt : " + cnt);
			cnt++;
			return;
		}
		for (int i = is; i < is + size; i++) {
			for (int j = js; j < js + size; j++) {
				size /= 2;
				recur(i, j, size);
				recur(i, j + size, size);
				
				recur(i + size, j, size);
				recur(i + size, j + size, size);
			}
		}
		
		
	}
	
}
