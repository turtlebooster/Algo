package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈2_13300_방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 학생 수
		int K = sc.nextInt();	// 한 방에 배정할 수 있는 최대 인원
		int[] boy = new int[7];	// 남학생 학년별 카운팅	1
		int[] girl = new int[7];// 여학생 학년별 카운팅	0
		
		// 각 성별에 대한 학년별 인원 카운트
		for (int i = 0; i < N; i++) {
			// 남학생일 경우
			if (sc.nextInt() == 1) {
				boy[sc.nextInt()]++;
				continue;
			}
			// 여학생일 경우
			girl[sc.nextInt()]++;
		}
		
		// 학년별로 방 수 카운팅
		int ans = 0;
		for (int i = 1; i <= 6; i++) {
			ans += boy[i] / K;
			ans += girl[i] / K;
			// 남은 인원이 있을경우 추가 방 필요
			if (boy[i] % K != 0) ans++;
			if (girl[i] % K != 0) ans++;
		}
		
		System.out.println(ans);
		sc.close();
	}
}
