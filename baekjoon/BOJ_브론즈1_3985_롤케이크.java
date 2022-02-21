package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈1_3985_롤케이크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();	// 롤 케이크 길이
		int N = sc.nextInt();	// 방청객의 수
		boolean[] check = new boolean[L + 1];
		int[] count = new int[N + 1];
				
		// 방청객의 수 만큼
		int maxWantNum = 0;	// 가장 많은 조각 기대 번호
		int realMaxNum = 0; // 실제 가장 많은 조각 받는 번호
		int temp = 0; 		// 기대되는 가장 맣은 조각 저장
		for (int i = 1; i <= N; i++) {
			int st = sc.nextInt();	// 시작 번호
			int ed = sc.nextInt();	// 끝 번호
			if (temp < ed - st + 1) {
				temp = ed - st + 1;
				maxWantNum = i;
			}
			for(int j = st; j <= ed; j++) {
				if (check[j])	continue;
				if (++count[i] > count[realMaxNum]) realMaxNum = i;
				check[j] = !check[j];
			}
		}
		
		
		System.out.println(maxWantNum);
		System.out.println(realMaxNum);
		sc.close();
	}
}
