package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_실버3_1449_실버3_수리공항승 {
	/*
	 * 물이 새는 곳의 개수 N / 테이프의 길이 L
	 * 적어도 위치의 좌우 0.5 간격은 주어야 물이 다시는 안샘
	 * 막는 곳의 시작점 부터 막을 수 있는 범위를 알 필요가 있음
   * 시작점 a , 끝점 b 라고 하면
   * b - a 의 길이 + 1 (=양 끝 0.5) = L 을 만족할때 가장 긴 범위로 막을 수 있음
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());  // 물이 새는 곳의 개수
		int L = Integer.parseInt(st.nextToken());  // 테이프의 길이
				
		List<Integer> pos = new ArrayList<>();     // 물이 새는 곳의 위치 기록용 ArrayList

		// ArrayList에 물이 새는 곳 기록
		st = new StringTokenizer(br.readLine());    
		for (int i = 0; i < N; i++) {
				pos.add(Integer.parseInt(st.nextToken()));			
		}
		
		// Array List 오름차순 정렬
		// 1, 3, 2, 100, 200, 5 -> 1, 2, 3, 5, 100, 200 
		pos.sort((p1, p2) -> p1 - p2);
		

		// 막는 시작점 설정
		int temp = pos.get(0);
		// 사용 테이프 수 개수
		// 시작점 부터 테이프를 사용하므로 초기값 1
		int cnt = 1;
		
		for (int i = 0; i < pos.size(); i++) {			
			// 범위를 넘어갈 경우 
			// 그 지점을 새로운 시작점으로 설정
			// 새로운 테이프 사용
			if (pos.get(i) - temp + 1 > L ) {
				temp = pos.get(i);
				cnt++;
			}				 
		}
		
		System.out.println(cnt);
		
	}
}
