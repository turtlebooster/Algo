package algo.Sort;

import java.util.Arrays;

public class Sort_CountingSort {
	public static void main(String[] args) {
		int[] data = {0, 4, 1, 3, 1, 2, 4, 1};
		int N = data.length;	// data 길이
		
		// data 최댓값 찾기
		int maxIdx = 0;
		for (int i = 1; i < N; i++) {
			if (data[maxIdx] < data[i]) maxIdx = i;
		}		
		
		int[] counts = new int[data[maxIdx] + 1];	// 데이터의 최대값 + 1 의 크기를 갖는 배열
		
		// 카운팅
		for (int i = 0; i < N; i++) {	
			counts[data[i]]++;
		}
		
		// 누적 합
		for (int i = 1; i <counts.length; i++) {
			counts[i] += counts[i - 1];
		}
		
		// 정렬 진행
		int[] sorted = new int[N];
		for (int i = N - 1; i >=0 ; i--) {
			sorted[--counts[data[i]]] = data[i];
		}
		
		System.out.println(Arrays.toString(data));
		System.out.println(Arrays.toString(counts));
		System.out.println(Arrays.toString(sorted));
	}
}
