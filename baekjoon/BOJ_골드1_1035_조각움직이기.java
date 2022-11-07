package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_골드1_1035_조각움직이기 {
	static int N, min, size;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static boolean[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = 5;
		map = new boolean[N][N];
		int[][] origin = new int[5][];
		size = 0;
		for (int i = 0; i < N; i++) {
			char[] input = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				if (input[j] == '*') {
					map[i][j] = true;
					origin[size++] = new int[] {i, j}; 
				}
			}
		}
		min = Integer.MAX_VALUE;
		int[][] stars = new int[size][];
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				stars[k] = Arrays.copyOf(origin[k], 2);
			}
			getCnt(stars, 0, i, 0);
		}
		
		System.out.println(min);
		sc.close();
	}
	private static void getCnt(int[][] stars, int idx, int pin, int sum) {
		if (sum >= min) {
			return;
		}
		if (idx >= size) {
			min = sum;
			return;
		}
		
		List<int[]> boundary = new ArrayList<>();
		if (idx == pin || isConnected(stars[pin], stars[idx], boundary)) {
			getCnt(stars, idx + 1, pin, sum);
			return;
		}
		
		boundary.sort((b1, b2) -> b1[2] - b2[2]);
		int dist = boundary.get(0)[2];
		
		
		
		for (int[] b : boundary) {
			if (b[2] > dist) break;
			int[] temp2 = stars[idx];
			map[temp2[0]][temp2[1]] = false;
			map[b[0]][b[1]] = true;
			stars[idx] = b;
			getCnt(stars, idx + 1, pin, sum + dist);
			stars[idx] = temp2;
			map[temp2[0]][temp2[1]] = true;
			map[b[0]][b[1]] = false;
		}
		
		
	}
	public static boolean isConnected(int[] star1, int[] star2, List<int[]> boundary) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.add(star1);
		visited[star1[0]][star1[1]] = true;
		
		int[] curr;
		while(!q.isEmpty()) {
			curr = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(visited[nr][nc]) continue;
				if (!map[nr][nc]) {
					int[] pos = {nr, nc};
					boundary.add(new int[] {nr, nc, getDist(pos, star2)});
					continue;
				}
				
				if (nr == star2[0] && nc == star2[1]) {
					return true;
				}
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		
		return false;
	}
	public static int getDist(int[] pos1, int[] pos2) {
		return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
	}
}
