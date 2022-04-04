package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_실버3_16922로마숫자만들기 {
	public static int N;
	public static int[] nums = {1, 5, 10, 50};
	public static Set<Integer> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		set = new HashSet<>();
		
		comb(3, N, 0);
		// set 의 크기가 곧 서로 다른 수의 개수
		System.out.println(set.size());
		sc.close();
	}
	
	public static void comb(int nIdx, int r, int sum) {
		// r 이 0 이면 다 뽑은 상태
		if (r == 0) {
			// 중복이 제거되는 set 사용
			set.add(sum);
			return;
		}
		// nIdx 가 nums 배열 범위 벗어나면 중지
		if (nIdx < 0) return;
		comb(nIdx, r - 1, sum + nums[nIdx]);	// 넣고 다음에 그 숫자 또 넣을지 말지 
		comb(nIdx - 1, r, sum);					// 안넣고 다음에 그 숫자 안 넣음
	}
}
