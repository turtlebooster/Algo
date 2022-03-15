package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_실버1_2447_별찍기10 {
	static char[][] star; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// N x N 별 배열 생성
		star = new char[N][N];
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				star[i][j] = '*';
			}
		}
		
		blank(0, 0, N);
		
		System.out.println(Arrays.deepToString(star).replace("], ", "\n").replace(", ", "").replaceAll("[\\[\\]]", ""));
		sc.close();
	}
	static void blank(int is, int js, int len) {
		len /= 3;	// 단위길이 / 3
		
		// 중앙 부분만 빈칸만들기
		for (int i = is + len; i < is + 2 * len; i++) {
			for (int j = js + len; j < js + 2 * len; j++) {
				star[i][j] = ' ';
			}			
		}
		
		// 단위길이가 1이 되면 함수를 더 호출할 필요 없음
		if(len == 1) return;

		// 중앙 부분을 제외하고 같은 동작 반복
		blank(is, js, len);		
		blank(is, js + len, len);		
		blank(is, js + 2 * len, len);		
		
		blank(is + len, js, len);		
		blank(is + len, js + 2 * len, len);		
		
		blank(is + 2 * len, js, len);		
		blank(is + 2 * len, js + len, len);		
		blank(is + 2 * len, js + 2 * len, len);		
	}
}
