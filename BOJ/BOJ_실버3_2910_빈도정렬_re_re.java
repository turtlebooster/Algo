package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_실버3_2910_빈도정렬_re_re {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
//		int C = sc.nextInt();
		sc.nextInt();
		
		int[] arr = new int[N];
		// 빈도수 기록을 위한 HashMap
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// 주어진 수열 입력
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (map.get(arr[i]) == null) map.put(arr[i], 1);
			else map.put(arr[i], map.get(arr[i]) + 1);
		}		
		
		for (int j = 0; j < N; j++) {
			int maxcnum = arr[0];			
			// 빈도 수 가장 큰 수 찾기
			// 같을 경우 앞쪽에 있는 수
			for (int i = 0; i < N; i++) {
				if (map.get(arr[i]) > map.get(maxcnum)) {
					maxcnum = arr[i];
				}
			}
			
			if (map.get(maxcnum) == 0) break;
			
			// 빈도 수 가장 큰 수를 빈도 수 만큼 문자열 출력
			for (int i = 0; i < map.get(maxcnum); i++) {
				System.out.print(maxcnum + " ");
			}
			
			// 빈도 수 가장 컸던 수의 빈도를 0으로 초기화
			map.put(maxcnum, 0);
		}
		
		
		sc.close();
	}
}
