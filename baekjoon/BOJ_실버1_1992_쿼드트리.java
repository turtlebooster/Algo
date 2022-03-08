package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_실버1_1992_쿼드트리 {
	static char[][] image;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		image = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			image[i] = br.readLine().toCharArray();
		}		
		
		recur( 0, 0, N);
		
		br.close();
	}
	
	public static void recur (int is, int js, int size) {
	    // 첫 번째 자리 글자 저장 -> 비교시 사용
		char c = image[is][js];
		
		for (int i = is; i < is + size; i++) {
			for (int j = js; j < js + size; j++) {
				// 다른 글자가 발견되면 4 조각으로 나눠서 다시
				if (image[i][j] != c) {
					System.out.print("(");
					
					int nsize = size / 2;
					
					recur(is, js, nsize);
					recur(is, js + nsize, nsize);
					
					recur(is + nsize, js, nsize);
					recur(is + nsize, js + nsize, nsize);	
					
					System.out.print(")");
					return;
				}
			}
		}		
		System.out.print(c);
	}	
}
