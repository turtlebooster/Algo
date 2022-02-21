package swea;

import java.util.Scanner;

public class SW_D2_2005_파스칼의삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 파스칼 삼각형 크기 1~10
			
			System.out.println("#" + tc);
			
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= r; c++) {
					System.out.print(pascal(r, c) + " ");
				}
				System.out.println();
			}
			
		}
		sc.close();
	}
	private static int pascal (int r, int c) {
		if (r == c) return 1;
		if (c == 1) return 1;		
		
		return pascal(r - 1, c - 1) + pascal(r - 1, c);
	}
}
