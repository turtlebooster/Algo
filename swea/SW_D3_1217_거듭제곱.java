package swea;

import java.util.Scanner;

public class SW_D3_1217_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();	// 테스트케이스 번호
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + tc + " " + multiple(N, M));
		}
		sc.close();
	}
	private static int multiple(int N, int M) {
		if (M == 1) return N;
		
		return N * multiple(N, M - 1);
	}
	
}