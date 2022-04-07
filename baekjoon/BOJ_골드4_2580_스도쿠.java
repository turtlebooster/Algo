package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_골드4_2580_스도쿠 {
	public static int[][] sudoku;
	public static Stack<int[]> blank;
	public static int[] row;
	public static int[] col;
	public static int[][] box;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sudoku = new int[9][9];
		blank = new Stack<>();
		row = new int[9];
		col = new int[9];
		box = new int[3][3];
		
		// 데이터 입력
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				sudoku[i][j] = num;
				int bit = 1<<num;
				row[i] |= bit;
				col[j] |= bit;
				box[i / 3][j / 3] |= bit;
				// 빈칸 수 파악
				if (sudoku[i][j] == 0) blank.add(new int[] {i, j});
			}
		}
		
		
		dropTheNum();
		System.out.println(Arrays.deepToString(sudoku).replace("], ", "\n").replaceAll("[\\[\\,\\]]", ""));
		br.close();
	}
	
	static boolean dropTheNum() {
		if (blank.isEmpty()) return true;
		// 스도쿠 채우기
		// blank 가 모두 사라질때까지
		// 빈칸이었던 좌표 가져오기
		int[] pos = blank.pop();
		// 가로 줄 체크 | 세로줄 체크 | 3 X 3 체크
		int check = row[pos[0]] | col[pos[1]] | box[pos[0] / 3][pos[1] / 3];
		
		// 남은 수가 있으면 넣고 다음 자리 넣어보기
		for (int num = 1; num <= 9; num++) {
			int bit = 1<<num;
			if ((check & bit) == 0) {
				
				
				row[pos[0]] |= bit;
				col[pos[1]] |= bit;
				box[pos[0] / 3][pos[1] / 3] |= bit;
				
				if (dropTheNum()) {
					sudoku[pos[0]][pos[1]] = num;
					return true;
				}
				
				// 틀렸으면 다시 빼기
				row[pos[0]] ^= bit;
				col[pos[1]] ^= bit;
				box[pos[0] / 3][pos[1] / 3] ^= bit;
			}
		}
		
		// 다 해봤는데 틀린경우 
		// 윗 단계에서 숫자 수정하고 다시 진행 -> 스택에 넣기
		blank.add(pos);
		return false;
	}
}
