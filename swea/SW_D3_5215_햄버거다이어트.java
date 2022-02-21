package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SW_D3_5215_햄버거다이어트 {
	
	static int ans, L;
	static boolean[] sel;
	static int[][] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			int N = sc.nextInt();	// 재료의 수
			sel = new boolean[N];
			L = sc.nextInt();	// 제한 칼로리
			list = new int[N][2];	// i 메뉴 점수, 칼로리 저장 배열
			
			for (int i = 0; i < N; i++) {
				list[i][0] = sc.nextInt();		// 점수
				list[i][1] = sc.nextInt();		// 칼로리
			}
			
			powerset(0);
			
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
	
	
	private static void powerset(int idx) {
		if (idx == sel.length) {
			int cSum = 0;	// 칼로리 합
			int sSum = 0;	// 점수 합
			// 한번 다만들었다. 합을 구해보자
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					sSum += list[i][0];					
					cSum += list[i][1];
				}
			}
			// 
			if (cSum <= L) {
				ans = Math.max(ans, sSum);
			}
			System.out.println(Arrays.toString(sel));
			return;
		}
		// 재귀파트 
		// idx번째에 원소를 선택하여 true로 바꾸고 다음 원소를 선택하기 위해서 재귀호출
		sel[idx] = true;
		powerset(idx + 1);
		// idx번째에 원소를 선택하지 X 다음 원소를 선택하기 위해서 재귀호출
		sel[idx] = false;
		powerset(idx + 1);
	}	
}
