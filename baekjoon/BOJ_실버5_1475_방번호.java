package baekjoon;

import java.util.Scanner;

public class BOJ_실버5_1475_방번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[9];	// 각 인덱스 번호를 가지고 있는 세트 개수로 사용	9는 6 인덱스 같이 사용
		String num = sc.next();
		
		int cnt = 0;	// 사용한 세트 수 체크
		for (int i = 0; i < num.length(); i++) {
			int n = num.charAt(i) - '0';
			if (n == 9) n = 6;	// 들어온 수가 9 이면 6으로 간주
			if (nums[n] == 0) {	// 숫자가 없을 경우
				cnt++;			// 세트 추가
				// 숫자 추가
				for (int j = 0; j < 9; j++) {
					nums[j]++;	// 사용할 수 있는 숫자 개수 추가
				}
				nums[6]++;		// 9를 6으로 간주하므로 6에 한 개 더 추가
			}
			// 숫자 사용
			nums[n]--;
		}
		System.out.println(cnt);		
		sc.close();
	}
}
