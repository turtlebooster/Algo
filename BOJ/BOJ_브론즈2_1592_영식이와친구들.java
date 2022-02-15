package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈2_1592_영식이와친구들 {
	/*
	 * N 명이 1 ~ N 까지 적혀있는 자리에 원형으로 앉는다
	 * 1번 자리에 앉은 사람이 공을 받으며 시작
	 * 한 사람이 공을 M번 받으면 게임 끝
	 * 공을 던질 때, 공을 받은 횟수가 홀수 번: 현재 위치에서 시계방향으로 L번째 있는 사람에게 
	 * 				 공을 받은 횟수가 짝수 번: 현재 위치에서 반시계방향으로 L번째 있는 사람에게
	 * 공을 총 몇 번 던지는지 출력
	 *
	 * input :	N M L	자리 개수(3 <= N <= 50) / 최대 공 받는 횟수(M <= 50, 자연수) / 몇번째 (L <= N - 1, 자연수) 
	 * 
	 * output : num		공을 던지는 총 횟수
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 총 사람 수
		int M = sc.nextInt();	// 최대 공 받는 횟수
		int L = sc.nextInt();	// 공 받을 L 번째
		int num = 0;			// 던진 횟수 보관용 변수 
		
		int[] cnt = new int[N];	// 각 자리의 공 받은 횟수 기록 배열
		int i = 1;
		cnt[i] = 1;	// 1번 자리 에서 공 받으며 시작
		
		while(cnt[i] < M) {
			// 공 받을 사람 정하기
			if (cnt[i] %2 == 1) {
				i = (i + L) % N;
			}
			else {
				i = (i + N - L) % N;
			}
			// 공 던지기
			num++;
			// 공 받은 횟수 추가
			cnt[i]++;
		}
		
		System.out.println(num);
		sc.close();
	}
}
