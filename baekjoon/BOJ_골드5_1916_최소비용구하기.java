package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_골드5_1916_최소비용구하기 {
	static class Bus {
		int e, c;
		Bus(int e, int c) {
			this.e = e;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		// 시작점 별 버스 리스트
		List<Bus>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 버스 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Bus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Bus> pq = new PriorityQueue<>((b1, b2) -> b1.c - b2.c);
		int[] costs = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[start] = 0;
		pq.add(new Bus(start, 0));
		
		Bus curr;
		while(!pq.isEmpty()) {
			curr = pq.poll();
			if (visited[curr.e]) continue;
			visited[curr.e] = true;
			
			for (Bus next : list[curr.e]) {
				if (costs[next.e] > costs[curr.e] + next.c) {
					costs[next.e] = costs[curr.e] + next.c;
					pq.add(new Bus(next.e, costs[next.e]));
				}
			}
		}
		
		System.out.println(costs[end]);
		br.close();
	}
}
