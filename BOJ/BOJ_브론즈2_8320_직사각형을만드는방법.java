package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈2_8320_직사각형을만드는방법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt = 0; // 갯수 카운트
		for (int i = 1; i <= N; i++) {
			for (int r = 1, c = i; r <= c; r++, c = i / r) {
				if (i == r * c) cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
