package swea;

import java.util.Scanner;

public class SW_D3_6190_정곤이의단조증가하는수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 주어지는 양의 정수 개수
			
			// 주어지는 양의 정수 입력
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			// 최댓값 -1으로 초기화 -> 없을경우 -1 출력
			int max = -1; 
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (danjo(nums[i] * nums[j])) max = Math.max(max, nums[i] * nums[j]);
				}
			}			
			
			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}
	
	private static boolean danjo (int num) {
		String nums = num + "";
		
		for (int i = 1; i < nums.length(); i++) {
			if (nums.charAt(i - 1) - '0' > nums.charAt(i) - '0') return false;
		}			
		return true;
	}
}