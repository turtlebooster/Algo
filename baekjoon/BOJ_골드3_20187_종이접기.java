package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_골드3_20187_종이접기 {
	static Scanner sc = new Scanner(System.in);
	static int size;
	static int[] start;
	static int[][] paper;
	static Stack<Character> stack;	
	public static void main(String[] args) {
		int K = sc.nextInt();
		size = (int)Math.pow(2, K);
		paper = new int[size][size];
		
		stack = new Stack<>();
				
		// 접어서 최종 지점 찾기
		flip(0, 0, size, size);
		paper[start[0]][start[1]] = sc.nextInt();
		
		// 펼치면서 기록하기
		unfold(start[0], start[1], 1, 1);
		
		System.out.println(Arrays.deepToString(paper).replace("], ", "]\n").replaceAll("[\\[\\,\\]]", ""));		
		sc.close();
	}
	
	public static void unfold(int is, int js, int ilen, int jlen) {
		if (stack.isEmpty()) {
			return;
		}
		
		char c = stack.pop();
		switch (c) {
		case 'D':
			for (int i = is; i < is + ilen; i++) {
				for (int j = js; j < js + jlen; j++) {
					paper[2 * is - 1 - i][j] = (paper[i][j] + 2) % 4;
				}
			}
			unfold(is - ilen, js, ilen * 2, jlen);
			break;
		case 'U':
			for (int i = is; i < is + ilen; i++) {
				for (int j = js; j < js + jlen; j++) {
					paper[2 * (is + ilen) - 1 - i][j] = (paper[i][j] + 2) % 4;
				}
			}
			unfold(is, js, ilen * 2, jlen);
			break;
		case 'R':
			for (int i = is; i < is + ilen; i++) {
				for (int j = js; j < js + jlen; j++) {
					paper[i][2 * js - 1 - j] = getReflect(paper[i][j]);
				}
			}
			unfold(is, js - jlen, ilen, jlen * 2);
			break;
		case 'L':
			for (int i = is; i < is + ilen; i++) {
				for (int j = js; j < js + jlen; j++) {
					paper[i][2 * (js + jlen) - 1 - j] = getReflect(paper[i][j]);
				}
			}
			unfold(is, js, ilen, jlen * 2);
			break;			
		}
		
		
	}
	
	public static void flip(int is, int js, int ilen, int jlen) {
		if (ilen == 1 && jlen == 1) {
			start = new int[] {is, js};
			return;
		}
		
		char c = sc.next().charAt(0);
		stack.add(c);
		switch (c) {
		case 'D':
			flip(is + ilen / 2, js, ilen / 2, jlen);
			break;
		case 'U':
			flip(is, js, ilen / 2, jlen);
			break;
		case 'R':
			flip(is, js + jlen / 2, ilen, jlen / 2);
			break;
		case 'L':
			flip(is, js, ilen, jlen / 2);
			break;			
		}
	}
	
	public static int getReflect(int num) {
		switch (num) {
		case 0:
			return 1;
		case 1:
			return 0;
		case 2:
			return 3;
		case 3: 
			return 2;
		}
		return -1;
	}
}
