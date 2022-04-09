package algo.Sort;

import java.util.Arrays;

public class Sort_MergeSort {
	static int[] arr;
	static int[] sortedArr;

	public static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 시작점
		int R = mid + 1; // 오른쪽 시작점
		int idx = left;	// 인덱스 시작점
		
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) sortedArr[idx++] = arr[L++];
			else sortedArr[idx++] = arr[R++];		
		}
		while (L <= mid) sortedArr[idx++] = arr[L++];
		while (R <= right) sortedArr[idx++] = arr[R++];
		
//		if (L <= mid) {
//			for (int i = L; i <= mid; i++) {
//				sortedArr[idx++] = arr[i];
//			}
//		} else {
//			for (int j = R; j <= right; j++) {
//				sortedArr[idx++] = arr[j];
//			}			
//		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
		System.out.println(left+"부터 "+right+"까지 병합정렬");
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 왼쪽
			mergeSort(left, mid);
			// 오른쪽
			mergeSort(mid + 1, right);
			// 정렬			
			merge(left, mid, right);
		}
	}

	public static void main(String[] args) {
		arr = new int[] {7,5,4,1,2,10,3,6,9,8};
		sortedArr = new int[arr.length];
		System.out.println("정렬 수행 전: " + Arrays.toString(arr));
		mergeSort(0, arr.length-1);
		System.out.println("정렬 수행 후: " + Arrays.toString(arr));
	}

}