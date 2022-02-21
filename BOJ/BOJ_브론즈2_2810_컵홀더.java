package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈2_2810_컵홀더 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 	  // 좌석 수
		String seats = sc.next(); // 좌석 배치
		
		int cnt = 1; // 컵홀더 수 카운트
		for (int i = 0; i < N; i++) {
			// 커플석일 경우 한 자리 건너 뛰고 카운트
			if (seats.charAt(i) == 'L') i++;
			cnt++;
		}
		
		// 컵홀더가 좌석 수 보다 크면 좌석 수만큼
		if (cnt > N) {
			System.out.println(N);
		}
		// 컵홀더가 좌석 수보다 작거나 같으면 컵홀더 수만큼
		else {
			System.out.println(cnt);
		}
		sc.close();
	}
}
