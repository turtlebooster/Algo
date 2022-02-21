package codeup;

import java.util.Scanner;

public class No1274 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) cnt += 1;
		}
		if (cnt == 2) System.out.println("prime");
		else System.out.println("not prime");
		sc.close();
	}
}
