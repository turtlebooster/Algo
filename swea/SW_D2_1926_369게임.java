package swea;

import java.util.Scanner;

public class SW_D2_1926_369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 숫자로 한 자리씩 체크하기
		for (int i = 1; i <= N; i++) {
			int num = i;
			int cnt = 0;
			while (num > 0) {
				int temp = num % 10;
				if (temp == 3 || temp == 6 || temp == 9) cnt++;
				num /= 10;
			}
			
			if (cnt > 0 ) {
				while (cnt-->0) {
					System.out.print("-");
				}
			}
			else {
				System.out.print(i);
			}
			System.out.print(" ");						
		}
		
		/*
		// 문자로 바꾸어 한 자리씩 체크하기
		String num;
		for (int i = 1; i <= N; i++) {
			num = i + "";
			if (num.contains("3") || num.contains("6") || num.contains("9")) {
				int cnt = 0;
				for (int j = 0; j < num.length(); j++) {
					if (num.charAt(j) != '3' && num.charAt(j) != '6' && num.charAt(j) != '9') continue;
					cnt++;
				}
				for (int j = 0; j < cnt; j++) {
					System.out.print("-");					
				}
				System.out.print(" ");
				continue;
			}
			System.out.print(num + " ");
			
		}
		*/
		
		sc.close();
	}
}
