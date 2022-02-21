package swea;

import java.util.Scanner;

public class SW_D3_1216_회문2 {
	static int ans, palinCnt;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			ans = 0;
//			palinCnt = sc.nextInt();
			char[][] pal1 = new char[101][101]; // 가로 데이터
			char[][] pal2 = new char[101][101]; // 세로 데이터
			// 데이터 세팅
			for (int i = 1; i <= 100; i++) {
				String line = sc.next();	//CBCCCBAB
				for (int j = 1; j <= 100; j++) {
					pal1[i][j] = pal2[j][i] = line.charAt(j - 1);					
				}
			}
			
			// 회문 카운트 세기
//			countPalin(pal1);
//			countPalin(pal2);
			
			for (palinCnt = 1; palinCnt < 100; palinCnt ++) {
				if (checkPalin(pal1)) ans = Math.max(ans, palinCnt);
				if (checkPalin(pal2)) ans = Math.max(ans, palinCnt);
				
			}
			
			
			
			System.out.println("#" + tc + " " + ans);			
		}
		sc.close();		
	}
	private static boolean checkPalin (char[][] pal) {
		int half = palinCnt / 2;
		int rest = palinCnt % 2;
		for (int i = 1; i <= 100; i++) {
			outer:
			for (int j = half + rest; j <= (100 - half); j++) {
				for (int depth = 0; depth < half; depth++) {
					if (pal[i][j - depth - rest] != pal[i][j + depth + 1]) continue outer;					
				}
				// 회문이 맞을때만 이 자리에 올 수 있다.
				return true;				
			}
		}
		return false;
	}
}
