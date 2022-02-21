package swea;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class SW_D4_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 닫힘 괄호에 대한 짝을 저장하기 위한 HashMap
		HashMap<Character, Character> lover = new HashMap<>();
		lover.put(']', '[');
		lover.put(')', '(');
		lover.put('>', '<');
		lover.put('}', '{');
				
		for (int tc = 1; tc <= 10; tc++) {
			int ans = 0;	// 정답 초기값 0으로 설정
			
			
			int L = sc.nextInt();	// 문자열 길이
			String S =sc.next();	// 괄호 문자열
			// 문자열 길이가 홀수이면 짝이 안맞으므로 잘못된 짝짓기
			if (L % 2 != 0 ) {				
				System.out.println("#" + tc + " " + ans);
				continue;
			}
			
			Stack<Character> box = new Stack<>();
			
			for (int i = 0; i < L; i++) {
				char item = S.charAt(i);
				// 여는 괄호일 경우 stack에 저장
				if (item == '[' || item == '(' || item == '<' || item == '{') {
					box.push(item);
				}
				// 이외의 경우 = 닫는괄호일 경우 
				else {
					// 닫는 괄호의 짝이 스택의 마지막 값과 틀릴경우 잘못된 괄호 짝짓기
					// 닫는 괄호의 수가 더 많을 경우 -> 스택의 여는 괄호가 부족할 경우 잘못된 괄호 짝짓기
					// 더 진행할 필요 없으니 break
					if (box.isEmpty() || lover.get(item) != box.pop()) {
						break;
					}
				}				
			}
			
			// stack에 여는 괄호가 남은 채로 끝났을 경우 잘못된 괄호 짝짓기
			if (box.isEmpty()) ans = 1;
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
