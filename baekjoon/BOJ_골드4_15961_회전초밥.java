package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_골드4_15961_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		// 회전초밥 위치별 초밥 번호
		int[] table = new int[N + K - 1];
		// 초밥 번호별 먹는 수
		int[] sushiCnt = new int[D + 1];
		// 먹는 초밥 종류 저장
		Set<Integer> sushiEat = new HashSet<>();
		
		// N 개의 회전초밥 위치 별 초밥 번호 기록
		for (int i = 0; i < N; i++) {
			table[i] = Integer.parseInt(br.readLine());
		}
		// 뒷쪽에 앞쪽 번호 반복 -> 마지막 번째 ~ K개 초밥 선택 가능하도록
		for (int i = N; i < table.length; i++) {
			table[i] = table[i - N];
		}
		
		// 첫 번째 K개 연속 기록
		int idx;
		for (int i = 0; i < K; i++) {
			idx = table[i];
			sushiCnt[idx]++;
			sushiEat.add(idx);
		}
		
		// 최대로 먹을수 있는 종류 수
		int max = sushiEat.size() + (sushiCnt[C] == 0 ? 1 : 0);		
		
		int removeIdx, addIdx;
		for (int i = 1; i < N; i++) {
			removeIdx = table[i - 1];
			addIdx = table[i + K - 1];
			
			if (--sushiCnt[removeIdx] == 0) {
				sushiEat.remove(removeIdx);
			}
			sushiCnt[addIdx]++;
			sushiEat.add(addIdx);
			
			max = Math.max(max, sushiEat.size() + (sushiCnt[C] == 0 ? 1 : 0));
		}
		
		System.out.println(max);
	}
}
