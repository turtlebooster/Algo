package baekjoon;

import java.util.Scanner;

public class BOJ_실버3_1244_스위치켜고끄기 {
	/*
	 *  1: 스위치 켜짐 / 0: 스위치 꺼짐
	 *  학생들에게 1 ~ N 개 자연수 (N <= 스위치 수)
	 *  남학생: 받은 수의 배수에 해당하는 스위치 상태를 바꿈
	 *  여학생: 받은 수를 중심으로 좌우 대칭이 연속되있는 곳까지 스위치 상태 모두 바꿈 
	 *  		받은 수에 해당하는 스위치 상태는 항상 바뀜
	 *  
	 *  input : 	N				스위치 개수
	 *  			s1 s2 ... sn	스위치 상태
	 *  			P				학생 수 (100 이하 양의 정수)
	 *  			G num			성별 / 받은 수
	 *  
	 *  output :	s1 s2 ... s20	스위치 상태 (한 줄에 20개씩)
	 *  			s21 ...	  sn
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 스위치 개수
		int[] S = new int[N + 1];	// 스위치 배열
		for (int i = 1; i <= N; i++) {
			S[i] = sc.nextInt(); // i 번째 스위치 상태
		}
		
		int P = sc.nextInt();	// 학생 수
		for (int i = 0; i < P; i++) {
			int G = sc.nextInt(); 	// 성별 - 남학생: 1, 여학생: 2
			int num = sc.nextInt();	// 학생이 받은 수
			if (G == 1) { // 남학생
				int d = 1;
				while(num * d <= N) {
					// 배수일때 스위치 전환
					S[num * d] = (S[num * d] + 1) % 2;
					d++;
				}
			}
			else {	// 여학생
				S[num] = (S[num] + 1) % 2;
				int d = 1;
				while(num + d <= N && num - d >= 1) {
					// 좌우 대칭이 아니면 정지
					if (S[num + d] != S[num - d]) break; 
					S[num + d] = S[num - d] = (S[num - d] + 1) % 2;
					d++;
				}				
			}			
		}
		
		// 한 줄에 20개씩 출력
		for (int i = 1; i <= N; i++) {
			System.out.print(S[i] + " ");
			if (i % 20 == 0) System.out.println();
		}
		sc.close();
	}
}
