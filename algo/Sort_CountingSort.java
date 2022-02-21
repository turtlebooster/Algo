package algo;

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
		
		/*
		// 배열을 정렬해보자.
		int[] arr = { 5, 2, 4, 1, 2, 3, 3 };

		int N = arr.length; // 배열의 크기
		int K = -1;// 데이터의 최댓값 (모든 데이터가 양수라고 가정)

		// 최댓값 찾기
		for (int i = 0; i < N; i++) {
			if (K < arr[i])
				K = arr[i];
		}
		// K값 찾았당
		int[] count = new int[K + 1];

		int[] sorted = new int[N];

		// 카운팅 레츠두잇 ㅎ~~~
		for (int i = 0; i < N; i++) {
			int idx = arr[i];
			count[idx]++;
		}

		// 누적합을 구해보장~~~
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// 정렬을 한다~~~!!!!!!
		for (int i = N - 1; i >= 0; i--) {
			// 마음의 숙제 나눠서 변수에 할당하고 작성을 해보장
			sorted[--count[arr[i]]] = arr[i];
		}

		System.out.println(Arrays.toString(sorted));
		*/
	}
}
