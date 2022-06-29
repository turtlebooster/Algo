package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_골드4_1715_카드정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		long ans = 0;
		long sum;
		// 합이 작은 순으로 지속적으로 더함
		while(pq.size() > 1) {
			ans += sum = pq.poll() + pq.poll();
			pq.add(sum);				
		}			
		
		System.out.println(ans);
	}
}
