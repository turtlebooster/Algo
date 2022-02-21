package codeup;

import java.util.Scanner;

public class No1380 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		for (int i = 1; i <= 6; i++) {
			for (int j = 6; j >= 1; j--) {
				if ( (i + j) == sum) System.out.printf("%d %d\n", i, j);
			}			
		}
		sc.close();
	}
}
