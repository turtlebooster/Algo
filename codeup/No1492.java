package codeup;

import java.util.Scanner;

public class No1492 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] sum = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			sum[i] = 0;
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i+1; j++) {
				sum[i] += arr[j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(sum[i] + " ");
		}
	sc.close();	
	}
}
