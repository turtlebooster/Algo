package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Scanner;

public class SW_D4_5432_쇠막대기자르기 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int T = sc.nextInt();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			
			// 입력받기			
			String pos = br.readLine();
//			String pos = sc.next();
			
			// 탐색
			// '(', ')', () 갯수 저장
			int openN = 0, closeN = 0, laserN = 0;
			// '(' 직후에 ')' 가 오면 레이저 갯수를 카우트 해주기 위한 flag
			boolean flag = false;
			for (int i = 0; i < pos.length(); i++) {
				if (pos.charAt(i) == '(') {
					openN++;	// 열린 괄호 갯수 카운트
					flag = true;// 열린 직후라는 신호
				}
				else {
					closeN++;	// 닫힌 괄호 갯수 카운트
					if (flag) {	// 닫힌 괄호인데 열린 괄화 직후일때 -> 레이저
						laserN++;	// 레이저 갯수 카운트
						ans += (openN - laserN) - (closeN - laserN);	// 레이저 일때마다 쪼개진 조각 갯수 더하기
																		// openN - laserN : (레이저 제외) 순수 열린 괄호 갯수
																		// closeN - laserN : (레이저 제외) 순수 닫힌 괄호 갯수
																		// 둘 의 차 : 쇠막대기 갯수 -> 쇠막대기 갯수만큼 조각이 생김
					} 
					else {
						ans++;	// 잘리지 않는 쇠막대기는 없다 최소 (()) // ()는 레이저
								// 닫힐때마다 조각 갯수 추가
					}					
					flag = false;// 닫힌 괄호 직후라는 신호
				}					
			}
			
			
			
			
			// 시간 초과
//			for (int i = 0; i < pos.length(); i++) {
//				// ( 일 경우에만 탐색 진행
//				if (pos.charAt(i) != '(') continue;
//				// i 자리에서 ( 인 것들에 대해서
//				int openN = 0, closeN = 0, laserN =0;
//				for (int j = 0; j < pos.length() - i ; j++) {
//					if (pos.charAt(i + j) == '(') openN++;
//					else if (pos.charAt(i + j) == ')') closeN++;
//					if (pos.charAt(i + j) == '(' && pos.charAt(i + j + 1) == ')') laserN++;
//										
//					if (openN <= closeN) {
//						if (openN == 1) break;
//						ans += laserN + 1;
//						break;
//					}
//				}	
//				
//			}			
			
			
			System.out.println("#" + tc + " " + ans);
		}
		br.close();
//		sc.close();
	}
}
