package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_골드2_1766_문제집 {
	/*
		1. N 개의 문제 모두 풀기
	   	2. 먼저 푸는 것이 좋은 문제가 있는 문제는 그 무제를 먼저 풀기 
		3. 가능하면 쉬운 문제(낮은 번호)부터 풀기
		
		3가지 다 만족하려면 PriorityQueue를 활용한 Topological sort		
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());	// 문제의 수
		int M = Integer.parseInt(st.nextToken());	// 문제 우선순위 정보 개수
		int[] inner = new int[N + 1];	// 각 문제(인덱스)를 풀기 전 먼저 풀어야 하는 문제의 수
		
		// 문제의 수가 최대 32,000 -> 인접 행렬 사용하면 메모리 초과할 가능성 높음
		// 인접 리스트 사용
		List<Integer>[] adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adjList[A].add(B);
			inner[B]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
		for (int i = 1; i <= N; i++) {
			if (inner[i] != 0) continue;
			pq.add(i);			
		}
		
		while (!pq.isEmpty()) {
			int idx = pq.poll();
			sb.append(idx + " ");
			
			for (int adjIdx : adjList[idx]) {
				if (--inner[adjIdx] != 0) continue;
				pq.add(adjIdx);
			}
		}
		
		System.out.println(sb);
	}
}
