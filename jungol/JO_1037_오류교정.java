package jungol;

import java.util.ArrayList;
import java.util.Scanner;

public class JO_1037_오류교정 {
	/*
	 * 패리티 검사법
	 * 각각의 열과 행이 짝수 합을 가질 때 패리티 성질을 가지고 있다고 한다.
	 * 
	 * 1. 패리티 성질 유무 판별
	 * 2. 없을경우 하나의 비트를 바꾸어 성질을 가질 수 있는지 판별
	 * 3. 그렇지 않을경우 잘못된 행렬
	 * 
	 * 패리티성질일경우 "OK"
	 * 하나의 비트 변경해서 성질을 가질경우 "Change bit (i,j)"
	 * 두 경우 모두 해당되지 않을 경우 "Corrupt"
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans = "OK";		// 답 출력을 위한 변수
		int N = sc.nextInt();	// 행렬의 크기 N X N  (N < 100)
		int[][] map = new int[N][N];
		ArrayList<Integer> r = new ArrayList<>(); 	// 합이 짝수 아닌 행 번호 저장할 리스트
		ArrayList<Integer> c = new ArrayList<>();	// 합이 짝수 아닌 열 번호 저장할 리스트
		
		
		// 데이터 입력받기	동시에 각 행의 합이 짝수인지 확인
		for (int i = 0; i < N; i++) {
			int rSum = 0; // 행 합
			for (int j = 0; j < N; j++) {				
				rSum += map[i][j] = sc.nextInt(); 
			}
			if (rSum % 2 != 0) {
				r.add(i);
			}
		}
		
		// 2개 이상의 행 합이 홀수일 경우 Corrupt
		if (r.size() >=2) {
			System.out.println("Corrupt");
			sc.close();
			return;
		}
		
		// 각 행의 합이 짝수인지 확인
		for (int j = 0; j < N; j++) {
			int cSum = 0;		// 열 합
			for (int i = 0; i < N; i++) {				
				cSum += map[i][j]; 
			}
			if (cSum % 2 != 0) {
				c.add(j);
			}
		}
		// 2개 이상의 열 합이 홀수일 경우 Corrupt
		if (c.size() >=2) {
			System.out.println("Corrupt");
			sc.close();
			return;
		}
		// 패리티 아닐경우
		// 합이 홀수인 행 과 열이 각각 1개씩만 있는지 확인
		// 해당 (행, 열)에 1 -> 0, 0 -> 1 하면 패리티 행렬이 됨
		// 이외의 경우에는 불가능
		if (r.size() == 1 && c.size() == 1) ans = "Change bit " + "(" + (r.get(0) + 1) + "," + (c.get(0) + 1) + ")";
				
		System.out.println(ans);
		sc.close();
	}
}
