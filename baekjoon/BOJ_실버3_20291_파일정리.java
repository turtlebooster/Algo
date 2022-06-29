package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BOJ_실버3_20291_파일정리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 파일 개수
		int N = Integer.parseInt(br.readLine());
		
		// 확장자 사전순 정렬을 위한 pq
		PriorityQueue<String> pq = new PriorityQueue<>();
		// 확장자 개수 기록을 위한 map
		Map<String, Integer> map = new HashMap<>();
		
		String format;
		for (int i = 0; i < N; i++) {
			format = br.readLine().split("\\.")[1];
			if (map.get(format) == null) {
				map.put(format, 1);
				pq.add(format);
			} else {
				map.put(format, map.get(format) + 1);				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			format = pq.poll();
			sb.append(format).append(" ").append(map.get(format)).append("\n");
//			System.out.println(format + " " + map.get(format));
		}
		System.out.print(sb);
	}
}
