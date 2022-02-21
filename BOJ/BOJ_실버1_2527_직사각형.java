package baekjoon;

import java.util.Scanner;

public class BOJ_실버1_2527_직사각형 {
	/*
	 * 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ans;
		
		int[] X1 = new int[2];
		int[] Y1 = new int[2];
		int[] X2 = new int[2];
		int[] Y2 = new int[2];
		
		
		// 4개의 케이스가 주어짐
		for (int tc = 1; tc <= 4; tc++) {			
			for (int i = 0; i < 2; i ++) {
				X1[i] = sc.nextInt();
				Y1[i] = sc.nextInt();
			}
			for (int i = 0; i < 2; i ++) {
				X2[i] = sc.nextInt();
				Y2[i] = sc.nextInt();
			}
			
			// 공통이 없는경우 1max < 2min	or 1min > 2max
			if (X1[1] < X2[0] || X1[0] > X2[1] || Y1[1] < Y2[0] || Y1[0] > Y2[1]) {
				ans = 'd';
			}
			// 점으로 만날때, X, Y 둘다 1min = 2max or 1max = 2min
			else if ((X1[0] == X2[1] && Y1[1] == Y2[0])
					|| (X1[0] == X2[1] && Y1[0] == Y2[1])
					|| (X1[1] == X2[0] && Y1[0] == Y2[1])
					|| (X1[1] == X2[0] && Y1[1] == Y2[0])){
				ans = 'c';
			}
			// 선분으로 만날때, 위의 경우 제외 X 또는 Y의 1min = 2max or 1max = 2min
			else if(X1[0] == X2[1] || X1[1] == X2[0] || Y1[0] == Y2[1] || Y1[1] == Y2[0]) {
				ans = 'b';
			}
			// 직사각형으로 만날때, 나머지경우 전부
			else {
				ans ='a';
			}
			
			System.out.println(ans);			
			
		}
		sc.close();
	}
}
