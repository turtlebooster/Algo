package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_골드4_2247_실질적약수_미완 {
	/*
	 * 실질적 약수: 1과 자기 자신을 제외한 약수
	 * SOD(n) : 정수 n의 모든 실질적 약수의 합
	 * CSOD(n) = SOD(1) + SOD(2) + ... + SOD(n)
	 * CSOD(n) 을 구하는 프로그램 작성
	 * 
	 * input : n	정수n
	 * output: ans	CSOD(n)을 1,000,000 으로 나눈 나머지
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int CSOD = 0;
		
		for (int i = 1; i <= N; i++) {
			CSOD += SOD_v2(i);
		}
		
		System.out.println(CSOD % 1000000);		
		sc.close();
	}
	
	// SOD 계산하는 함수
	private static int SOD_v2(int N) {
		int sum = 0;
		HashMap<Integer, Integer> divisorCnt = new HashMap<>();
		for (int i = 2; i < N; i++) {
			if (N % i == 0) sum += i;
		}	
		return sum;
	}	
	
	/*
	// SOD 계산하는 함수 - 시간초과
	private static int SOD_v1(int N) {
		int sum = 0;
		// 1과 자기자신 제외 나눈 나머지가 0 이면 실질적 약수
		for (int i = 2; i < N; i++) {
			if (N % i == 0) sum += i;
		}	
		return sum;
	}
	*/	
}
