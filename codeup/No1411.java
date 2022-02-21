package codeup;

import java.util.Scanner;

public class No1411 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] comp = new int[n-1];
		
		for (int i = 0; i < n-1; i++) {
			comp[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j =0; j < n-1; j++) {
				if (arr[i] == comp[j]) arr[i] = 0;
			}				
		}
		
		for (int i = 0; i < n; i++) {
			if (arr[i] !=0) System.out.println(arr[i]);
		}
		sc.close();
	}
}
