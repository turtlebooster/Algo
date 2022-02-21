package baekjoon;

import java.util.Scanner;

public class BOJ_브론즈1_2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 색종이 수
		int[][] map = new int[100][100];
		int area = 0;
		
		// 색종이 갯수만큼 반복 진행
		for (int num = 0; num < N; num++) {
			//색종이를 놓이는 자리에 1씩 더하기
			int dx = sc.nextInt();	// y축과 떨어진 거리
			int dy = sc.nextInt();	// x축과 떨어진 거리
			// 색종이 길이 가로 세로 10
			for (int i = dy; i < 10 + dy; i++) {				
				for (int j = dx; j < 10 + dx; j++) {
					map[i][j] += 1;
				}					
			}			
		}
		
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// 색종이 가 한번이라도 올라갔으면 0 보다 크다
				// 발견될때마다 넣이 저장변수에 1씩 더하기
				if (map[i][j] > 0) area += 1;
			}			
		}
		
		System.out.println(area);
		sc.close();
	}
}
