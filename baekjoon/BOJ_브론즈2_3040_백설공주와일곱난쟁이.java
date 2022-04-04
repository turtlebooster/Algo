package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈2_3040_백설공주와일곱난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		nanjangs = new int[9];
		for (int i = 0; i < 9; i++) {
			nanjangs[i] = sc.nextInt();
		}
		
		sel = new int[7];
		
		comb(9, 7);
		for (int i = 0; i < 7; i++) {
			System.out.println(sel[i]);
		}
		sc.close();
	}
	public static int[] nanjangs, sel;
	public static boolean flag = false;
	public static void comb(int n, int r) {
		if (flag) return;
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += sel[i];
			}
			if (sum == 100) flag = true;
			return;
		}
		if (n < r) return;
		sel[r - 1] = nanjangs[n - 1];
		comb(n - 1, r - 1);
		comb(n - 1, r);
	}
	
	
	
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		nanjangs = new int[9];
		for (int i = 0; i < 9; i++) {
			nanjangs[i] = sc.nextInt();
			sum += nanjangs[i];
		}
		
		sel = new int[7];
		
		int idx1 = -1;
		int idx2 = -1;
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - nanjangs[i] - nanjangs[j] == 100) {
					idx1 = i;
					idx2 = j;
					break;
				}
			}
		}
		
		for (int i = 0; i < 9; i++) {
			if (i == idx1 || i == idx2) continue;
			System.out.println(nanjangs[i]);
		}
		sc.close();
	}
	*/
}
