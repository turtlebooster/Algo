package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_9996_한국이그리울땐서버에접속하지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] ptn = sc.next().split("\\*");
		int ptnLen = ptn[0].length() + ptn[1].length();
		
		String file;
		boolean flag;
		for (int i = 0; i < N; i++) {
			file = sc.next();
			flag = false;
			if (file.length() >= ptnLen && file.startsWith(ptn[0]) && file.endsWith(ptn[1])) {
				flag = true;
			}
			if (flag) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
				
			}
		}
		
		sc.close();
	}
}
