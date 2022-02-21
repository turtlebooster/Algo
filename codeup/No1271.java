package codeup;

import java.util.Scanner;

public class No1271 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int cnt = sc.nextInt();
		int num1 = 0;
		int num2 = 0;		
		for (int i = 0; i < cnt; i++) {
			num1 = sc.nextInt();
			if (num1 > num2) {
				num2 = num1;
			}
		}
		System.out.println(num2);
		sc.close();
	}
}
