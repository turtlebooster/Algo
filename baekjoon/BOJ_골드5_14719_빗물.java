package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_14719_빗물 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		int[] map = new int[W];
		
		// 빗물 높이 입력
		for (int i = 0; i < W; i++) {
			map[i] = sc.nextInt();
		}
		
		int ans = 0;
		// 현재 위치에서 좌 우 확인	
		for (int i = 0; i < W; i++) {
			int now = map[i];
			int l = now;
			int r = now;
			
			// 왼쪽 최고 높이 찾기
			for (int j = 0; j < i; j++) {
				l = Math.max(l, map[j]);
			}
			
			// 오른쪽 최고 높이 찾기
			for (int j = i + 1; j < W; j++) {
				r = Math.max(r, map[j]);
			}
			
			// 높이차 누적			
			if (r > now && l > now) {
				ans += Math.min(r, l) - now;
			}
			
		}
		
		System.out.println(ans);
		sc.close();
	}
}
