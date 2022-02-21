package baekjoon;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_골드3_1918_후위표기식 {
	/*
	 * 중위표기식 -> 후위표기식
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 각 기호별 랭킹 기록용 HashMap
		HashMap<Character, Integer> rank = new HashMap<>();
		rank.put('(', 0);
		rank.put('+', 1);
		rank.put('-', 1);
		rank.put('*', 2);
		rank.put('/', 2);
		
		char[] susik = sc.next().toCharArray();
		Stack<Character> box = new Stack<>();
		
		// 들어온 문자열에대해 한자리씩 체크
		for (char c : susik) {
			if (!"()+-*/".contains(c + "")) { // 숫자인 경우 -> 여기서는 ABC...
				System.out.print(c);
			} else { // 기호인 경우
				if (c == ')') {	// 닫는 괄호를 만나면
					// 여는 괄호 나올때까지 꺼내기
					while (box.peek() != '(') System.out.print(box.pop());
					box.pop();	// '(' 버리기
				} 
				// 여는 괄호는 무조건 stack에 쌓기
				else if(c == '(') box.push(c); 
				else {
					//  현재의 기호 랭킹보다 스택 peek 의 랭크가 같거나 높은녀석은 내보내기
					while (!box.empty() && rank.get(c) <= rank.get(box.peek())) System.out.print(box.pop());
					box.push(c);
				}
			}			
		}	
		while(!box.empty()) System.out.print(box.pop());
		
		sc.close();
	}
}
