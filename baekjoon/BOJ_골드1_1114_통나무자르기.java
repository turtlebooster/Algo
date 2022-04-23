package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_골드1_1114_통나무자르기 {
	static class Log {
		int s, e, l;

		public Log(int s, int e) {
			this.s = s;
			this.e = e;
			l = e - s;
		}
	}
	static int[] pos;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 길이가 긴 나무 순으로 
		PriorityQueue<Log> pq = new PriorityQueue<>((l1, l2) -> l2.l - l1.l);
		
		int L = Integer.parseInt(st.nextToken());	// 통나무 길이
		int K = Integer.parseInt(st.nextToken());	// 자를 수 있는 위치
		int C = Integer.parseInt(st.nextToken());	// 통나무를 자를 수 있는 최대 횟수
		
		// 자를 수 있는 위치 입력
		Set<Integer> posSet = new HashSet<>();		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			posSet.add(Integer.parseInt(st.nextToken()));
		}
		
		pos = new int[posSet.size()];
		int idx = 0;
		for (int s : posSet) pos[idx++] = s;
		
		// 자를 수 있는 위치 오름차순 정렬
		Arrays.sort(pos);
		
		pq.add(new Log(0, L));		
		
	}
	
	
	public static int search(int s, int e, int target) {
		
		while (s <= e) {
			int mid = (s + e) / 2;
			if (pos[mid] > target) {
				
			}
		}
		
		
		return 0;
	}
}
