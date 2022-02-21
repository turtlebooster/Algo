package swea;

import java.util.Scanner;
import java.util.Stack;

public class SW_D4_1218_괄호짝짓기_prof {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int ans = 1;	// 유효
			
			sc.nextInt();
			
			Stack<Character> stack = new Stack<>();
			char[] data = sc.next().toCharArray();
			for (char c : data) {
				if ("[{(<".contains(c + "")) {	// 여는 괄호일 경우 스택에 푸쉬
					stack.push(c);
					continue;
				}
				// 닫는괄호일 경우
				if (stack.empty() || "[{(<".indexOf(stack.pop()) != "]})>".indexOf(c)) {
					ans = 0;
					break;
				}				
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
