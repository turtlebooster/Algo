package swea;

import java.util.Scanner;

public class SW_D2_1966_숫자를정렬하자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// 선택정렬
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			
			for (int i = 0; i < N - 1; i++) {
				int minIdx = i;
				for (int j = i + 1 ; j < N ; j++) {
					if (arr[minIdx] > arr[j]) {
						minIdx = j;
					}
				}
				int temp = arr[i];
				arr[i] = arr[minIdx];
				arr[minIdx] = temp;
			}
			String msg = "#" + t;
			for (int i = 0; i < N; i++) {
				msg += " " + arr[i];
			}
			System.out.println(msg);
		}
		
		
		sc.close();
	}
}
