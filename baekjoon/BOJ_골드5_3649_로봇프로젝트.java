package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_골드5_3649_로봇프로젝트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt()) {
			// 구멍 너비 [nm]
			int X = sc.nextInt() * 10000000;
			// 레고 조각 수
			int N = sc.nextInt();
			// 레고 배열
			int[] legos = new int[N];
			// 레고 길이 입력
			for (int i = 0; i < N; i++) {
				legos[i] = sc.nextInt();
			}
			Arrays.sort(legos);
			int s = 0;
			int e = N - 1;
			boolean flag = false;
			int sum;
			while(s < e) {
				sum = legos[s] + legos[e];
				if (sum == X) {				
					flag = true;
					break;
				} else if (sum > X) {
					e--;
				} else {
					s++;
				}
			}
			
			if (flag) {
				System.out.println("yes " + legos[s] + " " + legos[e]);
			} else {
				System.out.println("danger");
			}
		}
		
		sc.close();
	}
}
