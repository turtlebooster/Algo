package swea;

import java.util.Scanner;

public class SW_D3_1491_원재의벽꾸미기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			long N = sc.nextLong();	// 타일 개수
			long A = sc.nextLong();	// 가중치 A
			long B = sc.nextLong();	// 가중치 B
			
			long ans = Integer.MAX_VALUE;
			// R과 C의 차이 R < C 일 경우만 확인, C < R 은 중복, 직사각형이므로 C != R
			for (int R = 1; R <= N; R++) {
				for (int C = 1; C * R <= N && C <= R; C++) {
					Long nans = A * (R - C) + B * (N - R * C);
					ans = Math.min(ans, nans);
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
