package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_골드4_2239_스도쿠 {
	static int[] rbit, cbit;
	static int[][] map, rcbit, order;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		// 스도쿠 입력
		map = new int[9][9];
		rbit = new int[9];
		cbit = new int[9];
		rcbit = new int[3][3];
		order = new int[81][2];
		int num, bit;
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			line = br.readLine();
			for (int j = 0; j < 9; j++) {
				order[idx++] = new int[] {i, j};
				num = line.charAt(j) - '0';
				map[i][j] = num;
				if (num == 0) continue;
				bit = 1 << num;
				rbit[i] |= bit;
				cbit[j] |= bit;
				rcbit[i / 3][j / 3] |= bit;
			}
		}	
		
		fill(0);
		
		br.close();
	}
	
	public static void fill(int idx) {		
		if (flag) {
			return;
		}
		if (idx >= 81) {
			System.out.println(Arrays.deepToString(map).replaceAll("\\], ", "\n").replaceAll("[\\[\\,\\] ]", ""));
			flag = true;
			return;
		}		
				
		int r = order[idx][0];
		int c = order[idx][1];
		
		if (map[r][c] != 0) {
			fill(idx + 1);
			return;
		}
		
		int bit;
		for (int n = 1; n <= 9; n++) {
			bit = 1 << n;
			if (
					(rbit[r] & bit) > 0 ||
					(cbit[c] & bit) > 0 ||
					(rcbit[r / 3][c / 3] & bit) > 0
					) {
				continue;
			}
			
			map[r][c] = n;
			rbit[r] |= bit;
			cbit[c] |= bit;
			rcbit[r / 3][c / 3] |= bit;
			
			fill(idx + 1);
			
			map[r][c] = 0;
			rbit[r] ^= bit;
			cbit[c] ^= bit;
			rcbit[r / 3][c / 3] ^= bit;
		}
	}
}
