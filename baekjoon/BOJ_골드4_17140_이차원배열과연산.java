package baekjoon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class BOJ_골드4_17140_이차원배열과연산 {
	static class Num {
		int val, cnt;
		public Num(int val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt() - 1;	// 행
		int c = sc.nextInt() - 1;	// 열
		int k = sc.nextInt();		// 목표 값
		
		int[][] arr = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int time = 0;
		
		while ((r >= arr.length || c >= arr[0].length
				|| arr[r][c] != k) && time < 100) {
			time++;
			if (arr.length >= arr[0].length) {
				// 행의 개수 >= 열의 개수
				arr = Rcalc(arr);
			} else {
				// 행의 개수 < 열의 개수
				arr = Ccalc(arr);
			}
		}
		
		if (r >= arr.length || c >= arr[0].length
				|| arr[r][c] != k) time = -1;
		System.out.println(time);		
		sc.close();
	}
	
	private static int[][] Rcalc(int[][] arr){
		int rmax = arr.length, cmax = 0;
		Map<Integer, Integer> map;
		Set<Integer> set = new HashSet<>();
		PriorityQueue<Num>[] pq = new PriorityQueue[rmax];
		for (int i = 0; i < rmax; i++) {
			pq[i] = new PriorityQueue<Num>((n1, n2) ->  {
				if (n1.cnt != n2.cnt) return n1.cnt - n2.cnt;
				return n1.val - n2.val;
			});
		}
		
		
		for (int i = 0; i < rmax; i++) {
			map = new HashMap<>();
			for (int j = 0; j < arr[i].length; j++) {
				int num = arr[i][j];
				if (num == 0) continue;
				if (map.get(num) == null) {
					map.put(num, 1);
				} else {
					map.put(num, map.get(num) + 1);
				}
			}
			set = map.keySet();
			cmax = Math.max(cmax, set.size());
			
			for (int num : set) {
				pq[i].add(new Num(num, map.get(num)));
			}
		}		
		cmax *= 2;
		if (cmax > 100) cmax = 100;
		
		arr = new int[rmax][cmax];
		
		for (int i = 0; i < rmax; i++) {
			int j = 0;
			while (!pq[i].isEmpty()) {
				Num n = pq[i].poll();
				arr[i][j++] = n.val;
				arr[i][j++] = n.cnt;
				if (j == cmax) break;
			}
		}
		
		return arr;
	}
	
	private static int[][] Ccalc(int[][] arr){
		int rmax = 0, cmax = arr[0].length;
		Map<Integer, Integer> map;
		Set<Integer> set = new HashSet<>();
		PriorityQueue<Num>[] pq = new PriorityQueue[cmax];
		for (int j = 0; j < cmax; j++) {
			pq[j] = new PriorityQueue<Num>((n1, n2) ->  {
				if (n1.cnt != n2.cnt) return n1.cnt - n2.cnt;
				return n1.val - n2.val;
			});
		}
		
		
		for (int j = 0; j < cmax; j++) {
			map = new HashMap<>();
			for (int i = 0; i < arr.length; i++) {
				int num = arr[i][j];
				if (num == 0) continue;
				if (map.get(num) == null) {
					map.put(num, 1);
				} else {
					map.put(num, map.get(num) + 1);
				}
			}
			set = map.keySet();
			rmax = Math.max(rmax, set.size());
			
			for (int val : set) {
				pq[j].add(new Num(val, map.get(val)));
			}
		}
		rmax *= 2;
		if (rmax > 100) rmax = 100;
		
		arr = new int[rmax][cmax];
		
		for (int j = 0; j < cmax; j++) {
			int i = 0;
			while (!pq[j].isEmpty()) {
				Num n = pq[j].poll();
				arr[i++][j] = n.val;
				arr[i++][j] = n.cnt;
				if (i == rmax) break;
			}
		}
		return arr;
	}
}
