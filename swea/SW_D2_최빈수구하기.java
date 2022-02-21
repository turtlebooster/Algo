package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SW_D2_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt();
			int[] arr = new int[1000];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 정렬
			Arrays.sort(arr);

			int max = 0;		 // 최대 카운트 비교용
			int cnt = 0;		 // 중복 점수 갯수 체크
			int temp = arr[999]; // 카운트 비교용
			int ans = arr[999];  // 답변 제출용
			
			// 카운트, 카운트 맥스
			for (int i = arr.length -1 ; i >= 0; i--) {
				if (arr[i] == temp) {
					cnt++; 
				} else {
					if (max < cnt) {
						max = cnt;
						ans = arr[i+1];
					}
					cnt = 1;
					temp = arr[i];
				}
			}		
			
			System.out.printf("#%d %d\n", t, ans);
		}		
		sc.close();
	}
}
