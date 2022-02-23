package algo;

import java.util.Arrays;

public class Sort_SelectionSort {
	public static void main(String[] args) {
		int[] nums = {3, 7, 2, 4, 8, 9};
		int N = nums.length;
		
		// 오름차순
		// 몇번 돌건지 + 정렬 위치(앞쪽부터 채워감)		
		// 2개 남았을때 정렬 이후에는 더 정렬할 필요 없으므로 N - 1
		for (int i = 0; i < N - 1 ; i++) {
			int minIdx = i;
			for (int j = i + 1; j < N; j++) {
				// minIdx 와 j 인덱스에 해당하는 두 수 중 j 인덱스 값이 작으면 
				if (nums[minIdx] > nums[j]) {
					// minIdx 를 j로 덮어쓰기
					minIdx = j;
				}				
			}
			// 각 탐색에서 가장 작은 값이 i 의 자리에 오도록 교환
			int temp = nums[i];
			nums[i] = nums[minIdx];
			nums[minIdx] = temp;
		}
		System.out.println(Arrays.toString(nums));
		
		/*
		// 오름차순 (N이든 N-1이든 어차피 밑에 반복문을 수행하지 않게 할 수 있음.)
		for (int i = 0; i < N; i++) {
			for(int j = 1; j < N-i; j++) {
				if(nums[j-1] > nums[j]) {
					int tmp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
		*/
	}
}
