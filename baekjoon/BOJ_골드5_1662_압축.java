package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_1662_압축 {	
	static int idx;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(zip(sc.next()));
	}
	
	public static int zip(String txt) {
		int cnt = 0;
		for (; idx < txt.length(); idx++) {
			if (txt.charAt(idx) == '(') {
				// 마지막에 카운트 한 숫자는 곱셈으로 사용
				cnt--;
				int multiple = txt.charAt(idx - 1) - '0';
				// 재귀 부를때 idx를 다음 자리로 만들어줘야 함
				idx++;
				// 곱해야할 수 * 카운트 된 수
				cnt+= multiple * zip(txt); 
				continue;
			} else if (txt.charAt(idx) == ')') {
				return cnt;
			}
			cnt++;
		}		
		return cnt;
	}

}

/*
	public static int zip(String txt, int idx) {
		
		int cnt = 0;
		for (int i = idx; i < txt.length(); i++) {
			if (txt.charAt(i) == '(') {
				return cnt - 1 + (txt.charAt(i - 1) - '0') * zip(txt, i + 1); 
			} else if (txt.charAt(i) == ')') {
				return cnt;
			}
			cnt++;
		}
		
		return cnt;
	}
 */