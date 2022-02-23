package baekjoon;

import java.util.Scanner;

public class BOJ_골드4_2247_실질적약수 {
	/**
	 * 실질적 약수: 1과 자기 자신을 제외한 약수
	 * SOD(n) : 정수 n의 모든 실질적 약수의 합
	 * CSOD(n) = SOD(1) + SOD(2) + ... + SOD(n)
	 * CSOD(n) 을 구하는 프로그램 작성
	 * 
	 * input : n	정수n	1 ~ 200,000,000
	 * output: ans	CSOD(n)을 1,000,000 으로 나눈 나머지
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long CSOD = 0;
		
		for (int i = 2; i <= N / 2; i++) {
			CSOD += i * (N / i - 1);
		}
		
		System.out.println(CSOD % 1000000);				
		sc.close();
	}
}
	
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long CSOD = 0;
		
		for (int i = 4; i <= N; i++) {
			CSOD += SOD_v3(i);
		}
		
		System.out.println(N + ": " + CSOD % 1000000);				
		sc.close();
	}
	*/
	
	/*
	// SOD 계산하는 함수
	private static long SOD_v3(int N) {
		long sum = 0;
		for (int i = 2; i <= (int)(Math.sqrt(N) + 0.5); i++) {
			if (N % i == 0) {
				if (N == i * i) sum += i;
				else sum += i + N / i;
			}
		}	
		return sum;
	}	
	*/
	
	/*
	// SOD 계산하는 함수
	private static long SOD_v2(int N) {
		long sum = 0;
		for (int i = 2, R = N / 2; i <= R; R = N / ++i) {
			if (N == i * R) {
				if (i == R) sum += i;
				else sum += i + R;
			}
		}	
		return sum;
	}	
	*/
	
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
		
