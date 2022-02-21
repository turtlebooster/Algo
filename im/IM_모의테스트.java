package im;

import java.util.Scanner;

public class IM_모의테스트 {
	/*
	 * 2 * h + a = X
	 * 		a = X - 2 * h
	 * 2 * h + b = Y
	 * 		b = Y - 2 * h
	 * 부피 = a * b * h
	 * 		= (X - 2 * h) * ( Y - 2 * h) * h
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int X = sc.nextInt();	// 골판지 크기 X
			int Y = sc.nextInt(); 	// 골판지 크기 Y
			
			double h = (X + Y) / 6;
			double max = (X - 2 * h) * ( Y - 2 * h) * h;			
			
			
			System.out.printf("#%d %.6f\n", tc, max);
		}
		sc.close();
	}
}
