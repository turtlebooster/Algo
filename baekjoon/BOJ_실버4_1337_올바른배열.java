package baekjoon;

import java.util.Scanner;

public class BOJ_실버4_1337_올바른배열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();       // 배열 크기 입력 받기
		int[] arr = new int[N];     // 입력 받은 크기의 배열 생성
		int max = 0;				// 최댓값 보관할 변수
		
		// 주어진 요소 배열에 입력
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
				
		// 각 배열 요소보다 1 ~ 4 가 큰 배열 요소 갯수 카운팅
		outer: for (int i = 0; i < N; i++) {
			// 자기 자신을 포함해서 5개 연속이므로 본인 포함 1 부터 시작
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if (arr[i] + 1 == arr[j]) cnt++;				
				else if (arr[i] + 2 == arr[j]) cnt++;
				else if (arr[i] + 3 == arr[j]) cnt++;
				else if (arr[i] + 4 == arr[j]) cnt++;
				// 5 개 이상이 연속된 수가 있으면 더이상 진행 할 필요가 없으니 break
				if (cnt >= 5) {
					max = 5;
					break outer;
				}
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(5-max);
		
		sc.close();
	}
}