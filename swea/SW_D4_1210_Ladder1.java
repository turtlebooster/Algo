package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D4_1210_Ladder1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();

			// 케이스 입력
			int[][] ladder = new int[100][100]; 
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			// 첫 행 순서대로 1 찾기
			outer: for(int j = 0; j < 100; j++) {
				if (ladder[0][j] == 0) continue;
				int posj = j;
				// 1일 경우 for 문 진행
				for (int i = 0; i < 100; i++) {
					
					// 2를 만나면 해답 찾음
					if(ladder[i][posj] == 2) {
						System.out.printf("#%d %d\n", tc, j);
						break outer;
					}
					
					// 좌, 우 확인
					int[] dr = {-1, 1};
					// 좌, 우 로 이동할 방향이 없으면 아래로 한 칸 이동 -> i 가 하나 올라감 
					if ((posj !=0 && ladder[i][posj + dr[0]] == 0) && (posj !=99 && ladder[i][posj + dr[1]] == 0))  continue;
					
					if(posj != 0 && ladder[i][posj + dr[0]] == 1) {
						while(true) {
							if(posj == 0 || ladder[i][posj + dr[0]] == 0) break;
							posj += dr[0];							
						}
					} 
					else if(posj != 99 && ladder[i][posj + dr[1]] == 1) {
						while(true) {
							if(posj == 99 || ladder[i][posj + dr[1]] == 0) break;
							posj += dr[1];							
						}
					}				
					
				}
				
				
			}
			
			
		}
		
	}
}
