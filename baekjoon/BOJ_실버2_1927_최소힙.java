package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_실버2_1927_최소힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 연산의 개수
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			// 0 일 경우 가장 작은 값 출력 하고 제거
			if (num == 0) {
				// 비어있을때는 0 출력
				if (pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.remove());
			} else pq.add(num);	
		}		
		
		br.close();
	}
}
