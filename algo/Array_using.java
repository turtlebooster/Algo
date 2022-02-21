package algo;

import java.util.Arrays;

public class Array_using {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		
		
		for (int i : nums) {
			i = 1;
			if (i != 1);
		}
		
		System.out.println(Arrays.toString(nums));
		System.out.println();
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = 1;
		}
		
		System.out.println(Arrays.toString(nums));
		System.out.println();
		
		// 전치 행렬
		int N = 5;
		int[][] arr = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = (i + 1) * 10 + (j + 1);
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		} 
		System.out.println();
		
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++){
				if (i < j) {
					int temp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = temp;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		} 
		System.out.println();
		
	}
}
