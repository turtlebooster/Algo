package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_실버4_4949_균형잡힌세상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while (true) {
			String txt = sc.nextLine();
			if (txt.equals(".")) break;
			Stack<Character> box = new Stack<>();
			String ans = "yes";
			
			for (int i = 0; i < txt.length(); i++) {
				char c = txt.charAt(i);
				if (!"[]()".contains(c + "")) continue;
				if ("[(".contains(c + "")) box.add(c);
				else {
					// 스택에 괄호가 들어 있는지? 맨 위에 것이 이번에 닫는 괄호와 짝인지?
					if (box.empty() || "[(".indexOf(box.pop()) != "])".indexOf(c)) {
						ans = "no";
						break;
					}					
				}				
			}
			// 갯수가 맞는지 체크
			if (!box.empty()) ans = "no";
			System.out.println(ans);
		}
		
		sc.close();
	}
}
