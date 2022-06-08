package baekjoon;

import java.util.Scanner;

public class BOJ_골드5_7682_틱택토 {
	static final String OK = "valid";
	static final String ERROR = "invalid";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String txt;
		char[][] map = new char[3][3];
		int oCnt, xCnt;
		boolean flag;
		while(true) {
			txt = sc.next();
			// end 키워드 입력되면 종료
			if (txt.equals("end")) break;
			
			flag = false;
			
			// 3x3 격자판에 입력
			int idx = 0;
			oCnt = 0; xCnt = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					char c = txt.charAt(idx++);
					if (c == 'O') oCnt++;
					else if (c == 'X') xCnt++;
					map[i][j] = c;
				}				
			}
			
			// 빈칸이 없을 경우
			// x 5개 o 4개 이면서 o의 3칸 잇기 없으면 가능
			if (xCnt == 5 && oCnt == 4 && !made(map, 'O')) {
				flag = true;
			} 
			// 빈칸이 있을 경우 -> 누군가의 승리로 끝남
			// x 는 3, 4개여야만 함
			else if (xCnt == 3 || xCnt == 4) {
				// X 승리
				if (oCnt == xCnt - 1 && !made(map, 'O') && made(map, 'X')) {
					flag = true;
				}
				// O 승리				
				else if (oCnt == xCnt && made(map, 'O') && !made(map, 'X')) {
					flag = true;
				}
			}				
			
			if (flag) System.out.println(OK);
			else System.out.println(ERROR);
		}
		
		sc.close();
	}
	
	public static boolean made (char[][] map, char horse) {
		// 가로 세로
		for (int i = 0; i < 3; i++) {
			if ((horse == map[i][0] && horse == map[i][1] && horse == map[i][2])
					|| (horse == map[0][i] && horse == map[1][i] && horse == map[2][i])) {
				return true;
			}
		}
		
		// 대각선
		if ((horse == map[0][0] && horse == map[1][1] && horse == map[2][2])
				|| (horse == map[0][2] && horse == map[1][1] && horse == map[2][0])) {
			return true;
		}
		
		return false;
	}
}
