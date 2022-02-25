package baekjoon;

import java.util.Scanner;

public class BOJ_실버2_2304_창고다각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	   // 기둥의 개수	1 ~ 1000
		int[] arr = new int[1001]; // 기둥 높이 배열, 기둥의 위치를 인덱스로 사용
		
		int maxIdx = 0;			// 최고 높이 기둥 위치
		int st = 1000, ed = 0;	// 기둥 위치 시작점, 끝점 
		for (int i = 0; i < N; i++) {
			int idx = sc.nextInt();
			int tall = sc.nextInt();
			arr[idx] = tall;
			if (tall > arr[maxIdx]) maxIdx = idx;
			if (idx < st) st = idx;
			if (idx > ed) ed = idx;
		}
		
		// 총 면적 = 최고 높이 * 1 + 최고높이 왼쪽 면적 + 최고높이 오른쪽 면적
		int area = arr[maxIdx];	// 답으로 제출할 면적	
		
		// 시작점 부터 maxIdx 까지
		int max = arr[st];		// 구간 최대 높이
		for (int i = st; i <= maxIdx; i++) {
			if (max < arr[i]) {
				area += max * (i - st);
				max = arr[i];	// 구간 최대 높이 변경
				st = i;			// 시작점 변경
			}
		}		
		area += max * (maxIdx - st);
		
		// 끝점 부터 maxIdx 까지
		max = arr[ed];
		for (int i = ed; i >= maxIdx; i--) {
			if (max < arr[i]) {
				area += max * (ed - i);
				max = arr[i];	// 구간 최대 높이 변경
				ed = i;			// 시작점 변경
			}
		}
		area += max * (ed - maxIdx);
		
		System.out.println(area);
		sc.close();
	}
}
