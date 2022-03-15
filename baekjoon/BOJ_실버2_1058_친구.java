package baekjoon;

import java.util.Scanner;

public class BOJ_실버2_1058_친구 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[][] friends = new boolean[N][N];
		boolean[][] friends2 = new boolean[N][N];
		
		// 친구 배열 입력
		for (int i = 0; i < N; i++) {
			char[] line = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				if (line[j] == 'Y') friends[i][j] = friends2[i][j] = true;
			}
		}		
		
		// 2-친구 배열 완성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 다른 사람과 친구이면 그사람의 친구와 2-친구
				if (friends[i][j]) {
					for (int k = 0; k < N; k++) {
						friends2[i][k] = friends2[i][k] || friends[j][k];
					}
				}
			}
			// 자기 자신과는 친구가 아니다
			friends2[i][i] = false;
		}		
		
		// 최대 2-친구 수
		int max = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(friends2[i][j]) cnt++; 
			}
			max = Math.max(max, cnt);
		}	
		
		System.out.println(max);
		sc.close();
	}
}
