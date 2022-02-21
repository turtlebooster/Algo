package swea;

import java.util.Scanner;

public class SW_D2_1984_중간평균값구하기 {
	static String data = "3      \r\n" + 
			"3 17 1 39 8 41 2 32 99 2 \r\n" + 
			"22 8 5 123 7 2 63 7 3 46 \r\n" + 
			"6 63 2 3 58 76 21 33 8 1   ";
	public static void main(String[] args) {
		Scanner sc = new Scanner(data);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			int max = 0;
			int min = 10000;
			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				sum += num;
				max = Math.max(max, num);
				min = Math.min(min, num);
			}		
			System.out.printf("#%d %.0f\n", tc, (sum - max - min) / 8.0);
		}		
		sc.close();
	}
}
