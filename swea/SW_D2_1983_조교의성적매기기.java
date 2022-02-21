package swea;

import java.util.Scanner;

public class SW_D2_1983_조교의성적매기기 {
	/*
	 * 10 개의 평점 A+0- B+0- C+0- D0
	 * 총점 = 중간(35%) + 기말(45%) + 과제(20%)
	 * 
	 * 평점은 총점이 높은 순서대로 같은 비율로 부여
	 * N 명일 경우 N/10 명씩 동일 평점
	 * N 은 10의 배수
	 * 
	 * K번째 학생의 학점 출력
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String ans;
			int N = sc.nextInt();	// 학생 수
			int K = sc.nextInt();	// 학점 알고싶은 학생의 번호
			int[] score = new int[N + 1]; // 인덱스 = 학생의 번호, 총점 보관 배열
			
			// 총점 배열 데이터 세팅
			for (int i = 1; i <= N; i++) {
				score[i] = sc.nextInt() * 35 + sc.nextInt() * 45 + sc.nextInt() * 20;	// 어차피 등수만 알면 되니까 100으로 나누지 않음
			}
			
			// K 번째 학생의 등수 확인
			// 초기값을 1 로 두고 더 높은 점수가 있을때마다 등수가 밀린다(+ 1)
			double rank = 1;	// 평점 계산을 위해 double 로 선언
			for (int i = 1; i <= N; i++) {
				if(score[i] > score[K]) rank++;
			}
			
			// 평점 저장 행렬
			String[] S = {"", "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
			ans = S[(int)Math.ceil((rank / (N / 10)))];
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
