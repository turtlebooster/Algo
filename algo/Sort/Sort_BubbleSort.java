package algo.Sort;

import java.util.Arrays;

public class Sort_BubbleSort {
	public static void main(String[] args) {
		int[] nums = {3, 7, 2, 4, 8, 9};
		int N = nums.length;
		
		/*
		// 오름차순
		// 몇번 돌건지 + 정렬 위치(뒷쪽부터 채워감)		
		// 2개 남았을때 정렬 이후에는 더 정렬할 필요 없으므로 등호 없음
		for (int i = N - 1; i > 0 ; i--) {
			for (int j = 0; j < i; j++) {
				// 인접한 두 수 중 앞으 수가 더 크면 
				if (nums[j] > nums[j + 1]) {
					// 서로 교환
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;					
				}				
			}
		}
		System.out.println(Arrays.toString(nums));
		*/
		
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

	}
}
