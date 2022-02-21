package codeup;

import java.util.Scanner;

public class No1355 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 1 ; i <= num ; i++) {
			for(int k = 1; k <= i - 1; k++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= num - i + 1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		sc.close();
	}
}
