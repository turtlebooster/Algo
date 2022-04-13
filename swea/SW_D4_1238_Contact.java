package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class SW_D4_1238_Contact {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int dataLen = Integer.parseInt(st.nextToken()) / 2;		// 간선의 수
			int start = Integer.parseInt(st.nextToken());	// 시작점
			
			// 중복 제거에 용이해보임 인접행렬 ㄱㄱ
			int[][] adjArr = new int[101][101];		// 인접행렬
			Set<Integer> node = new HashSet<>();	// 사람 번호 담을 set
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < dataLen; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());			
				
				adjArr[from][to] = 1;
				node.add(from);
				node.add(to);
			}
			
			boolean[] visited = new boolean[101];
			
			Queue<Integer> q = new LinkedList<>();
			
			q.add(start);
			visited[start] = true;
			
			// BFS 
//			int rank = 0;
//			int[] max = new int[101];
			int max = -1;
			while (!q.isEmpty()) {
				int size = q.size();
//				rank++;
				max = -1;
				for (int i = 0; i < size; i++) {
					int from = q.poll();
					max = Math.max(max, from);
					for (int to : node) {
						if (visited[to] || adjArr[from][to] == 0) continue;
						visited[to] = true;
						q.add(to);
//						max[rank] = Math.max(max[rank], to);
					}
				}
			}
			
//			System.out.println("#" + t + " " + max[rank - 1]);
			System.out.println("#" + t + " " + max);
		}
		br.close();
	}
}
