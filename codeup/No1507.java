package codeup;

import java.util.Scanner;

public class No1507 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int[][] arr = new int[4][4];
//		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				arr[i][j] = sc.nextInt();
//			}			
//		}
//		
//		
//		
//		// x 범위 찾기
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 4; j++) {
//				
//			}
//			
//		}
//		
//		
//		//check 상단 y max
//		//check 하단 y min
//		
//	sc.close();		
//	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		for(int i = 0; i < 4; i++) {
			int sR = sc.nextInt();
			int sC = sc.nextInt();
			int eR = sc.nextInt();
			int eC = sc.nextInt();
			//sR부터 eR까지 반복
			for(int j = sR; j < eR; j++) {
				//sC부터 eC까지 반복
				for(int k = sC; k < eC; k++) {
					map[j][k] = 1;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if( map[i][j] == 1 )
					cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();		
	}
}
