package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 사람 수
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 선택정렬
		for (int i = 0; i < N - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < N ; j++) {
				if (arr[minIdx] > arr[j]) minIdx = j;
			}
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < N; i++) {
			temp += arr[i];
			sum += temp;
		}
		
		System.out.println(sum);
		sc.close();
	}
}
