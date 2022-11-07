package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_골드4_16637_괄호추가하기 {
	static int N;
	static int max = Integer.MIN_VALUE;
	static char[] sp = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	static Map<Character, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt() / 2;
		String eq = sc.next();
		dfs(eq, 0);
		
		System.out.println(max);
		sc.close();
	}
	
	public static void dfs(String eq, int idx) {
		int len = eq.length(); 
		if (idx >= N) {
//			int n = eq.charAt(0);
//			if (n >= 'A' && n <= 'Z') {
//				n = map.get((char)n);
//			} else {
//				n -= '0';
//			}
			int n1 = eq.charAt(0);
			if (n1 >= 'A' && n1 <= 'Z') {
				n1 = map.get((char)n1);
			} else {
				n1 -= '0';
			}
			for (int i = 0; i < len - 2; i += 2) {
				char op = eq.charAt(i + 1);
				int n2 = eq.charAt(i + 2);
				if (n2 >= 'A' && n2 <= 'Z') {
					n2 = map.get((char)n2);
				} else {
					n2 -= '0';
				}	
				n1 = calc(n1, op, n2);
			}
			max = Math.max(max, n1);
//			System.out.println(idx);
//			max = Math.max(max, n);
			return;
		}
//		boolean flag = false;
		for (int i = 0; i < len - 2; i += 2) {
			dfs(eq, idx + 1);
			int n1 = eq.charAt(i);
			char op = eq.charAt(i + 1);
			int n2 = eq.charAt(i + 2);
			if (n1 >= 'A' && n1 <= 'Z') {
				n1 = map.get((char)n1);
				continue;
			} else {
				n1 -= '0';
			}
			if (n2 >= 'A' && n2 <= 'Z') {
				n2 = map.get((char)n2);
				continue;
			} else {
				n2 -= '0';
			}
//			flag = true;
			char c = sp[idx];
			map.put(c, calc(n1, op, n2));
			dfs(eq.substring(0, i) + c + eq.substring(i + 3), idx + 1);
			
		}
//		if (!flag) {
//			int n1 = eq.charAt(0);
//			if (n1 >= 'A' && n1 <= 'Z') {
//				n1 = map.get((char)n1);
//			} else {
//				n1 -= '0';
//			}
//			for (int i = 0; i < len - 2; i += 2) {
//				char op = eq.charAt(i + 1);
//				int n2 = eq.charAt(i + 2);
//				if (n2 >= 'A' && n2 <= 'Z') {
//					n2 = map.get((char)n2);
//				} else {
//					n2 -= '0';
//				}	
//				n1 = calc(n1, op, n2);
//			}
//			max = Math.max(max, n1);
//		}
	}
	
	public static int calc(int n1, char op, int n2) {
		int res = 0;
		
		switch (op) {
		case '+':
			res = n1 + n2;
			break;
		case '-':
			res = n1 - n2;
			break;
		case '*':
			res = n1 * n2;
			break;		
		}
		
		return res;
	}
}
