package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SW_D1_중간값찾기 {
	public static void main(String[] args) {
		/*
		 * N 개의 점수
		 * N 은 홀수, 9 <= N <= 199
		 * 중간 값에 해당하는 점수 찾기
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[N/2]);		
				
		sc.close();
	}
}
