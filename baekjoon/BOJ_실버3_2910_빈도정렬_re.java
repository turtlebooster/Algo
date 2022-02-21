package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_2910_빈도정렬_re {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		
		int[] arr = new int[N];
		// C 최댓값이 10억이기때문에 메모리 초과됨
		int[] count = new int[C + 1];
		
		// 주어진 수열 입력
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 각 수에 대한 빈도 저장 행렬
		// 인덱스가 수 / 값이 빈도
		for (int i = 0; i < N; i++ ) {
			count[arr[i]] += 1;
		}
		
		
		for (int j = 0; j < N; j++) {
			int maxcnum = 0;			
			// 빈도 수 가장 큰 수 찾기
			// 같을 경우 앞쪽에 있는 수
			for (int i = 0; i < N; i++) {
				if (count[arr[i]] > count[maxcnum]) {
					maxcnum = arr[i];
				}
			}
			
			if (count[maxcnum] == 0) break;
			
			// 빈도 수 가장 큰 수를 빈도 수 만큼 문자열 출력
			for (int i = 0; i < count[maxcnum]; i++) {
				System.out.print(maxcnum + " ");
			}
			
			// 빈도 수 가장 컸던 수의 빈도를 0으로 초기화
			count[maxcnum] = 0;
		}
		sc.close();
	}
}
