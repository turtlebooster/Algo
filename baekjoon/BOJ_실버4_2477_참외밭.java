package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2477
public class BOJ_실버4_2477_참외밭 {
	/*
	 * 1m^2 넓이에 자라는 참외 개수를 알면,
	 * 참외밭 넓이와 비례식을 활용하여 총 참외 개수 파악할 수 있음
	 * 
	 * 밭은 직각으로만 꺾이는 육각형 모양
	 * 
	 * input : K			1m^2의 넓이에 자라는 참외 개수(1 <= K <= 20)
	 * 		   dir1 len1	방향 길이	(반시계 방향으로 둘레를 돌면서)
	 * 		   ...  ...		1 동쪽, 2 서쪽, 3 남쪽, 4 북쪽
	 * 		   dir6 len6	길이는 1 ~ 500 정수
	 * 
	 * output: num			주어진 밭에서 자라는 참외의 수
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();	// 1m2 참외 수
		int[][] round = new int[12][2];	// {{dir, len}, ...}
		HashMap<Integer, Boolean> check = new HashMap<>();
		for (int i = 1; i <= 4; i++) {
			check.put(i, false);			
		}
		
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			round[i][0] = round[i + 6][0] = dir; 
			round[i][1] = round[i + 6][1] = sc.nextInt();
			check.put(dir, !check.get(dir));
		}
		
		//큰 넓이
		int big = 1;
		for (int i = 0; i < 6; i++) {
			if(check.get(round[i][0])) big *= round[i][1];
		}
		
		// 작은 넓이 
		int small = 1;
		for (int i = 0; i < 9; i++) {
			if (round[i][0] == round[i + 2][0] && round[i + 1][0] == round[i + 3][0]) {
				small = round[i + 1][1] * round[i + 2][1];
				break;
			}
		}
		
		System.out.println((big - small) * K);
		
		sc.close();
		
	}
}
