package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_20164_홀수홀릭호석 {
	static int min, max;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		min = Integer.MAX_VALUE;
		
		int cnt = 0;
		
		calc(input, 0, 0, cnt);

		
		System.out.println(min + " " + max);
		sc.close();
	}
	
	public static void calc (String input, int idx1, int idx2, int cnt) {
		// 1 자리 수 인 경우
		if (input.length() == 1) {
			if ((Integer.parseInt(input)) % 2 != 0) cnt++;
			if (min > cnt) min = cnt;
			if (max < cnt) max = cnt;
			return;
		}
		// 2 자리 수 인 경우
		if (input.length() == 2) {
			for (int i = 0; i < input.length(); i++) {
				if ((input.charAt(i) - '0') % 2 != 0) cnt++;
			}	
			
			int num = ((input.charAt(0) - '0') + (input.charAt(1) - '0'));
			
			if (num >= 10) {
				if (num % 2 == 0) cnt++;
				else cnt += 2;
				num = num / 10 + num % 10;
			}
			
			if (num % 2 != 0) cnt++;		
			if (min > cnt) min = cnt;
			if (max < cnt) max = cnt;
			return;
		}
		// 3 자리 수 이상
		String input2;
		if (idx1 == 0) {
			input2 = input;
		} else {
			for (int i = 0; i < input.length(); i++) {
				if ((input.charAt(i) - '0') % 2 != 0) cnt++;
			}		
			input2 = Integer.parseInt(input.substring(0, idx1)) 
					+ Integer.parseInt(input.substring(idx1, idx2))
					+ Integer.parseInt(input.substring(idx2, input.length()))
					+ "";			
			if (input2.length() <= 2) {
				calc(input2, 0, 0, cnt);
				return;
			}
		}
		
		
		for (int i = 1; i < input2.length() - 1; i++) {
			for (int j = i + 1; j < input2.length(); j++) {
				calc(input2, i, j, cnt);
			}
		}
		
	}
}
