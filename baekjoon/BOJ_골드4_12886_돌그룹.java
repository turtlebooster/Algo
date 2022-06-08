package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_골드4_12886_돌그룹 {
	static int[] stone;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		
		stone = new int[3];
		
		int total = 0;
		for (int i = 0; i < 3; i++) {
			stone[i] = sc.nextInt();
			total += stone[i];
		}
		
		// 3으로 나누어떨어지지 않으면 살펴볼 필요 없이 불가능
		if (total % 3 == 0) {
			visited = new boolean[1501][1501];
			int target = total / 3;
			
			recur();
			if (visited[target][target]) ans = 1;
		}
		
		System.out.println(ans);		
		sc.close();
	}
	
	public static void recur() {
		if (visited[stone[0]][stone[1]]) {
			return;
		}
		visited[stone[0]][stone[1]] = true;
		
		
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				int[] origin = Arrays.copyOf(stone, stone.length);
				move(i, j);	
				Arrays.sort(stone);
				recur();
				stone = origin;
			}
		}		
	}
	
	public static void move(int idx1, int idx2) {
		if (stone[idx1] > stone[idx2]) {
			int temp = idx1;
			idx1 = idx2;
			idx2 = temp;
		}
		// stone[idx1] < stone[idx2]
		
		stone[idx2] -= stone[idx1];
		stone[idx1] *=  2;
	}
}
