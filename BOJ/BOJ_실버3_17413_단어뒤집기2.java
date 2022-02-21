package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_실버3_17413_단어뒤집기2 {
	/*
	 * 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean open = false;
		String txt = br.readLine();	
		
		// Stack 사용하여 풀기
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < txt.length(); i++) {
			if (txt.charAt(i) == '<') {
				open = true;	
				while (!stack.isEmpty()) {
					bw.append(stack.pop());
//					System.out.print(stack.pop());
				}
			}
			if (open) {		// < > 내부 구간
				bw.append(txt.charAt(i));
//				System.out.print(txt.charAt(i));
				if (txt.charAt(i) == '>') open = false;
			}
			else {	// <> 외부 구간
				// 빈칸 전까지 기록한 String 뒤집어 프린트
				if (txt.charAt(i) == ' ') {
					while (!stack.isEmpty()) {
						bw.append(stack.pop());
//						System.out.print(stack.pop());
					}
					bw.append(" ");
//					System.out.print(" ");
				}
				else {
					stack.push(txt.charAt(i));					
				}
			}
		}
		while (!stack.isEmpty()) {
			bw.append(stack.pop());
//			System.out.print(stack.pop());
		}				
		
		bw.flush();
		
		/*
		// reversPrint라는 함수를 만들어서 사용한 풀이
		String sum = "";
		for (int i = 0; i < txt.length(); i++) {
			if (txt.charAt(i) == '<') {
				open = true;			
				reversePrint(sum);
				sum = "";
			}
			if (open) {		// < > 내부 구간
				System.out.print(txt.charAt(i));
				if (txt.charAt(i) == '>') open = false;
			}
			else {	// <> 외부 구간
				// 빈칸 전까지 기록한 String 뒤집어 프린트
				if (txt.charAt(i) == ' ') {
					reversePrint(sum);				
					sum = "";			
					System.out.print(" ");
				}
				else {
					sum += txt.charAt(i);					
				}
			}
		}
		reversePrint(sum);		
		 */
	}
	
	// 받은 단어를 뒤집어서 프린트하는 함수
//	private static void reversePrint(String msg) {
//		for (int i = msg.length() - 1; i >= 0; i-- ) {
//			System.out.print(msg.charAt(i));
//		}	
//	}
}
