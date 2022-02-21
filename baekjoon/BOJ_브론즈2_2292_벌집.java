package baekjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2292
public class BOJ_브론즈2_2292_벌집 {
	/*
	 * 중앙 1 을 시작으로 돌아가면서 방번호를 1씩 키워 지정
	 * 1 에서 N 번 방까지 몇개의 방을 지나가는지 계산 ( 시작과 끝 포함) 
	 * 
	 * input : N		이동할 방 번호 (1 <= N <= 1,000,000,000)
	 * output : ans		지나는 방의 수 (시작과 끝 포함)
	 * 
	 *  지나는 방의 수 = 1 과의 거리(?) 범위 번째(?)
	 *  ex) 1은 1번째 범위 / 2 ~ 7 은 2 번째 범위 / ....
	 *  k 번재 범위의 숫자 갯수 = 6 * k
	 *  
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int ans;
		// k 번째 범위 끝 번호	1 7 19 37 61 91 ... 이전 값 + 6 * (k - 1)	
		
		int endNum = 1;
		for (int i = 1;;i++) {
			endNum += 6 * (i - 1);
			if (N <= endNum) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
		sc.close();		
	}
}
