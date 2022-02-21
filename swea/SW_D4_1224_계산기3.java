package swea;

import java.util.Scanner;
import java.util.Stack;

public class SW_D4_1224_계산기3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();	// 테스트케이스 길이
			String S = sc.next();	
			
			System.out.println("#" + tc + " " + calculator(postfix(S)));
		}
		sc.close();
	}
	private static int calculator (String txt) {
		Stack<Integer> box = new Stack<>();
		for (int i = 0; i < txt.length(); i++) {
			char item = txt.charAt(i);
			if (item == '*') {		// '*' 연산자일 경우
				int num2 = box.pop();
				int num1 = box.pop();
				box.push(num1 * num2);
			} 
			else if(item == '+' ) {	// '+' 연산자일 경우
				int num2 = box.pop();
				int num1 = box.pop();
				box.push(num1 + num2);
			}
			else {	// 피연산자일 경우
				box.push(item - '0');
			}
		}		
		return box.pop();
	}
	
	
	// 중위표기 -> 후위표기
	private static String postfix (String txt) {
		Stack<Character> box = new Stack<>();
		String result = "";
		for(int i = 0; i < txt.length(); i++) {
			char item = txt.charAt(i);
			if (item == '*') {		// '*' 연산자일 경우
				// box top 에 우선순위 낮은 것이 있거나 비어있을때까지 꺼내고 스택쌓기
				while(box.peek() == '*' && !box.isEmpty() ) {
					result += box.pop();
				}
				box.push(item);				
			} 
			else if(item == '+' ) {	// '+' 연산자일 경우
				// box top 에 우선순위 낮은 것이 있거나 비어있을때까지 꺼내고 스택쌓기
				// ( 이거나 비어있을때만 들어감
				while(box.peek() != '(' && !box.isEmpty()) {
					result += box.pop();
				}
				box.push(item);				
			}
			else if(item == '(' ) {	// '(' 연산자일 경우
				box.push(item);
			}
			else if(item == ')' ) {	// ')' 연산자일 경우
				while(box.peek() != '(') {
					result += box.pop();
				}
				box.pop();
			}
			else {	// 피연산자일 경우
				result += item;
			}			
		}	
		return result;
	}
}
