package codeup;

import java.util.Scanner;

public class No1257 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		for (int i = a;i <= b ; i++ ) {
			if ( i % 2 != 0) System.out.printf("%d ",i);
		sc.close();
	}	
			}
}
