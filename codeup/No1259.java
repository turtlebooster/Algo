package codeup;

import java.util.Scanner;

public class No1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0 )
				sum += i;
		}
		System.out.println(sum);
		sc.close();
	}
}
