package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드5_6987_월드컵 {
	static boolean wrong;
	static int[][] score = new int[6][3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int winCnt, drawCnt, loseCnt;
		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			winCnt = 0;
			drawCnt = 0;
			loseCnt = 0;
			wrong = false;
			
			// 점수 기록
			// 승, 무승부, 패의 합 기록
			for (int i = 0; i < 6; i++) {
				winCnt += score[i][0] = Integer.parseInt(st.nextToken());
				drawCnt += score[i][1] = Integer.parseInt(st.nextToken());
				loseCnt += score[i][2] = Integer.parseInt(st.nextToken());
				if (score[i][0] + score[i][1] + score[i][2] != 5) wrong = true;
			}
			
			if (wrong || winCnt != loseCnt || drawCnt % 2 != 0) {
				System.out.print("0 ");
			} else {
				wrong = true;
				comb(0, 1);
				
				if (wrong) {
					System.out.print("0 ");					
				} else {
					System.out.print("1 ");					
				}
			}			
		}
	}
	private static void comb(int i, int j) {
		if (!wrong) {
			return;
		}			
		if (i >= 5) {
			wrong = false;
			return;
		}
		
		// i 승 j 패
		if(score[i][0] > 0 && score[j][2] > 0) {
			score[i][0]--;						
			score[j][2]--;
			if (j == 5) comb(i + 1, i + 2);
			else comb(i, j + 1);
			score[i][0]++;						
			score[j][2]++;			
		}
		// 무승부
		if(score[i][1] > 0 && score[j][1] > 0) {
			score[i][1]--;						
			score[j][1]--;						
			if (j == 5) comb(i + 1, i + 2);
			else comb(i, j + 1);
			score[i][1]++;						
			score[j][1]++;						
		}
		// i 패 j 승
		if(score[i][2] > 0 && score[j][0] > 0) {
			score[i][2]--;						
			score[j][0]--;
			if (j == 5) comb(i + 1, i + 2);
			else comb(i, j + 1);
			score[i][2]++;						
			score[j][0]++;			
		}
	}
}
