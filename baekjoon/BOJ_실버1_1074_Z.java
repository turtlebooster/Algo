package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_1074_Z {
	public static int N, c, r, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		recur(0, 0, (int)Math.pow(2, N));
		System.out.println(cnt);
		sc.close();
	}
	
	public static void recur(int is, int js, int size) {
		// 목표 지점 도달하면 더 실행될 필요 없음
		if (size == 1 && is == r && js == c) {
			// 1 크기까지 분할되고 목표 지점에 도달하면 정지
			return;
		}
		// 사이즈를 반으로 줄여 4 분할
		size /= 2;
		// 범위 내에 없으면 건너뛰고 칸 수 만큼 카운트
		if (is <= r && r < is + size) {
			if (js <= c && c < js + size) {
				recur(is, js, size);				
			} else {
				cnt += size * size;
				recur(is, js + size, size);				
			}
		} else {
			cnt += 2 * size * size;
			if (js <= c && c < js + size) {
				recur(is + size, js, size);
			} else {
				cnt += size * size;
				recur(is + size, js + size, size);
			}
		}
	}
}
