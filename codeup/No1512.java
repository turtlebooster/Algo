package codeup;

import java.util.Scanner;

public class No1512 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt(); // x-1 = i min
		int y = sc.nextInt(); // y-1 = j min 
		
		int[][] arr = new int[n][n]; 
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = Math.abs(i - (x - 1)) + Math.abs(j - (y - 1)) + 1;
			}			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
